package unityToJava.unity.thread.tasks;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.thread.locks.MyLock;

public abstract class Task {

    public abstract void execute() throws ProgramRunException;
    public abstract Runnable createRunnable();
    public abstract void setLocks(MyLock[] locks);

}
