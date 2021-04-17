package unityToJava.unity.thread.tasks;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.program.UnityProgram;
import unityToJava.unity.program.memory.MemoryCopy;
import unityToJava.unity.statements.assignments.Assignment;
import unityToJava.unity.thread.BoundedMemoryLock;

public class AssignmentTask extends Task{

    private final MemoryCopy memoryCopy;
    private final Assignment assignment;

    private BoundedMemoryLock memoryLock;

    public AssignmentTask(MemoryCopy memoryCopy, Assignment assignment) {
        this.memoryCopy = memoryCopy;
        this.assignment = assignment;
    }

    public void setLock(BoundedMemoryLock lock){
        this.memoryLock = lock;
    }


    public synchronized void execute() throws ProgramRunException {
        if (memoryCopy != null) {
            memoryCopy.loadIntoProgramMemory();
        }
        assignment.executeAssignment(memoryCopy);
    }

    public Runnable executeParallel(){
        return () -> {
            try {
                lockAndLoadMemory();
                System.out.println("Executing assignmentTask " + assignment.toString() + " by " + Thread.currentThread().getName());
                assignment.executeAssignment(memoryCopy);
                System.out.println("Done executing assignmentTask " + assignment.toString() + " by " + Thread.currentThread().getName());
                unlockMemory();
            } catch (ProgramRunException e) {
                UnityProgram.errorLog(e);
            }
        };
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
