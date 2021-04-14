package unityToJava.unity.statements;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.program.UnityProgram;
import unityToJava.unity.program.UnityProgramMemory;
import unityToJava.unity.program.memory.MemoryCopy;
import unityToJava.unity.program.memory.MemoryType;
import unityToJava.unity.thread.ThreadManager;

import java.util.List;

/**
 * all assignments inside AssignmentStatement can be executed parallel
 */

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
        UnityProgramMemory memory = UnityProgram.getUnityProgram().getMemory();
        ThreadManager threadManager = UnityProgram.getUnityProgram().getThreadManager();
        if (threadManager != null) {
            executeParallel(threadManager);
        } else {
            for (Assignment assignment : assignments) {
                assignment.assign();
            }
        }

        //after all assignments, copy changed WRITE memory into READ memory
        MemoryCopy memoryCopy = memory.createMemoryCopy(MemoryType.WRITE);
        memoryCopy.setMemoryType(MemoryType.READ);
        memory.loadMemoryCopy(memoryCopy);
    }

    private void executeParallel(ThreadManager threadManager) {
        for (final Assignment assignment : assignments){
            threadManager.addTask(new Runnable() {
                @Override
                public void run() {
                    try {
                        assignment.assign();
                    } catch (ProgramRunException programRunException) {
                        programRunException.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public void evaluateQuantifiers() throws ProgramRunException {
        for (Assignment assignment : assignments) {
            assignment.evaluateQuantifiers();
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
