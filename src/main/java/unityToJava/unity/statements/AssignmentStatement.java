package unityToJava.unity.statements;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.program.UnityProgram;
import unityToJava.unity.program.UnityProgramMemory;
import unityToJava.unity.program.memory.MemoryCopy;
import unityToJava.unity.statements.assignments.Assignment;
import unityToJava.unity.statements.assignments.QuantifiedAssignment;
import unityToJava.unity.thread.ThreadManager;
import unityToJava.unity.thread.tasks.Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;

public class AssignmentStatement extends Statement {

    List<Task> tasks;
    List<Assignment> assignments;
    public AssignmentStatement(List<Assignment> assignments) {
        this.assignments = assignments;
        this.tasks = new ArrayList<>();
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    @Override
    public void execute() throws ProgramRunException {
        ThreadManager threadManager = UnityProgram.getUnityProgram().getThreadManager();
        if (runParallel() && threadManager != null && tasks.size() > 1) {
            List<Future<?>> runningTasks = executeParallel(threadManager);
            waitForTaskToFinish(threadManager, runningTasks);
        } else {
            executeSingleThread();
        }
    }

    /**
     * execute parallel only if:
     * assignments > 1 or assignments == 1 && assignment instaceof QuantifiedAssignment
     * @return
     */
    private boolean runParallel() {
        return (assignments.size() > 1 || (assignments.get(0) instanceof QuantifiedAssignment));
    }

    private void executeSingleThread() throws ProgramRunException {
        for (Task task : tasks) {
            task.execute();
        }
    }

    private List<Future<?>> executeParallel(ThreadManager threadManager) {
        List<Future<?>> submittedTasks = new ArrayList<>();
        for (Task task : tasks){
            task.setLocks(threadManager.getLocks());
            Runnable runnableTask = task.createRunnable();
            Future<?> futureTask = threadManager.addTask(runnableTask);
            submittedTasks.add(futureTask);
        }
        return submittedTasks;
    }

    @Override
    public void prepareExecution(List<MemoryCopy> memorySnapshots) throws ProgramRunException {
        tasks = new ArrayList<>();
        for (Assignment assignment : assignments) {
            assignment.prepareExecution(memorySnapshots);
            tasks.addAll(assignment.getTasks());
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Assignment assignment : assignments){
            string.append(assignment.toString()).append(" \n");
        }
        return string.toString();
    }

    @Override
    protected Collection<? extends Task> getTasks() {
        return tasks;
    }
}
