package unityToJava.unity.thread.tasks;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.thread.BoundedMemoryLock;

public abstract class Task {

    public abstract void execute() throws ProgramRunException;
    public abstract Runnable executeParallel();
    public abstract void setLock(BoundedMemoryLock memoryLock);

}
