package unityToJava.unity.statements.assignments;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.program.UnityProgram;
import unityToJava.unity.program.memory.MemoryCopy;
import unityToJava.unity.statements.AssignmentStatement;
import unityToJava.unity.statements.Quantification;
import unityToJava.unity.thread.ThreadManager;
import unityToJava.unity.thread.tasks.Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;

public class QuantifiedAssignment extends Assignment {

    List<Task> tasks;
    Quantification quantification;
    AssignmentStatement assignmentStatement;

    public QuantifiedAssignment(Quantification quantification, AssignmentStatement assignmentStatement) {
        this.quantification = quantification;
        this.assignmentStatement = assignmentStatement;
        this.tasks = new ArrayList<>();
    }

    @Override
    public String toString() {
        return quantification.toString() + " " + assignmentStatement.toString();
    }

    @Override
    public void prepareExecution(List<MemoryCopy> memorySnapshots) throws ProgramRunException {
        tasks = new ArrayList<>();
        solveQuantification(memorySnapshots);
        for (Assignment assignment : assignmentStatement.getAssignments()){
            assignment.prepareExecution(quantification.getMemorySnapshots());
            tasks.addAll(assignment.getTasks());
        }
    }

    private void solveQuantification(List<MemoryCopy> memorySnapshots) throws ProgramRunException {
        if (memorySnapshots != null) {
            for (MemoryCopy memoryCopy : memorySnapshots) {
                memoryCopy.loadIntoProgramMemory();
                evaluateQuantification();
            }
        } else {
            evaluateQuantification();
        }
    }

    private void evaluateQuantification() throws ProgramRunException {
        quantification.initVariables();
        quantification.evaluate();
        quantification.destroyVariables();
    }

    @Override
    public void executeAssignment() throws ProgramRunException {
        ThreadManager threadManager = UnityProgram.getUnityProgram().getThreadManager();
        if (threadManager != null && tasks.size() > 1) {
            List<Future<?>> submittedTasks = executeParallel(threadManager);
            while (!threadManager.allDone(submittedTasks)) {
                //wait
            }
        } else {
            executeSingleThread();
        }
    }

    private void executeSingleThread() throws ProgramRunException {
        for(Task task : tasks){
            task.execute();
        }
    }

    private List<Future<?>> executeParallel(ThreadManager threadManager) {
        List<Future<?>> submittedTasks = new ArrayList<>();
        for (Task task : tasks){
            task.setLocks(threadManager.getLocks());
            submittedTasks.add(threadManager.addTask(task.createRunnable()));
        }
        return submittedTasks;
    }

    @Override
    public Collection<? extends Task> getTasks() {
        return tasks;
    }
}
