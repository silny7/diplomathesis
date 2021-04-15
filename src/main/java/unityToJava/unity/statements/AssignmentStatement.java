package unityToJava.unity.statements;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.program.UnityProgram;
import unityToJava.unity.program.UnityProgramMemory;
import unityToJava.unity.statements.assignments.Assignment;
import unityToJava.unity.thread.TaskCreator;
import unityToJava.unity.thread.ThreadManager;

import java.util.List;

public class AssignmentStatement extends Statement {

    List<Assignment> assignments;
    public AssignmentStatement(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    @Override
    public void execute() throws ProgramRunException {
        ThreadManager threadManager = UnityProgram.getUnityProgram().getThreadManager();
        if (threadManager != null && assignments.size() > 1) {
            executeParallel(threadManager);
        } else {
            executeSingleThread();
        }

        waitForTaskToFinish(threadManager);

        //after all assignments, copy changed WRITE memory into READ memory
        UnityProgramMemory.getMemory().loadWriteToRead();
    }

    private void executeSingleThread() throws ProgramRunException {
        for (Assignment assignment : assignments) {
            assignment.assign();
        }
    }

    private void executeParallel(ThreadManager threadManager) {
        for (Assignment assignment : assignments){
            threadManager.addTask(TaskCreator.createAssignmentTask(assignment));
        }
    }

    @Override
    public void prepareExecution() throws ProgramRunException {
        for (Assignment assignment : assignments) {
            assignment.prepareExecution();
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
}
