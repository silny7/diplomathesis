package unityToJava.unity.thread.tasks;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.program.UnityProgram;
import unityToJava.unity.program.UnityProgramMemory;
import unityToJava.unity.program.memory.MemoryCopy;
import unityToJava.unity.statements.assignments.Assignment;
import unityToJava.unity.statements.assignments.ConditionalEnumeratedAssignment;
import unityToJava.unity.thread.locks.BoundedMemoryLock;
import unityToJava.unity.thread.locks.CondEnumAssignLock;
import unityToJava.unity.thread.locks.MyLock;

public class AssignmentTask extends Task{

    private final MemoryCopy memoryCopy;
    private final Assignment assignment;

    private BoundedMemoryLock memoryLock;
    private CondEnumAssignLock condEnumAssignLock;

    public AssignmentTask(MemoryCopy memoryCopy, Assignment assignment) {
        this.memoryCopy = memoryCopy;
        this.assignment = assignment;
    }

    @Override
    public void setLocks(MyLock[] locks){
        this.memoryLock = (BoundedMemoryLock) locks[0];
        this.condEnumAssignLock = (CondEnumAssignLock) locks[1];
    }

    @Override
    public synchronized void execute() throws ProgramRunException {
        if (memoryCopy != null) {
            memoryCopy.loadIntoProgramMemory();
        }
        assignment.executeAssignment();
    }

    @Override
    public Runnable createRunnable(){
        return () -> {
            try {
                //lockAndLoadMemory();
                addMemoryCopyToMemory();
                System.out.println("Executing assignmentTask " + assignment.toString() + " by " + Thread.currentThread().getName());
                if (assignment instanceof ConditionalEnumeratedAssignment) {
                    ((ConditionalEnumeratedAssignment) assignment).setLock(condEnumAssignLock);
                }
                assignment.executeAssignment();
                System.out.println("Done executing assignmentTask " + assignment.toString() + " by " + Thread.currentThread().getName());
                //unlockMemory();
            } catch (ProgramRunException e) {
                UnityProgram.errorLog(e);
            }
        };
    }

    private void addMemoryCopyToMemory() {
        if (memoryCopy != null) {
            UnityProgramMemory.getMemory().addBoundedMemoryForThread(Thread.currentThread().getName(), memoryCopy);
        }
    }

    private void unlockMemory() {
        if (memoryCopy != null) {
            memoryLock.unlock();
        }
    }

    private void lockAndLoadMemory() {
        if (memoryCopy != null) {
            memoryLock.lock();
            memoryCopy.loadIntoProgramMemory();
        }
    }
}
