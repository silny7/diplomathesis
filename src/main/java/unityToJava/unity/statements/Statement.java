package unityToJava.unity.statements;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.thread.ThreadManager;

public abstract class Statement {


    public abstract void execute() throws ProgramRunException;

    /**
     * prepares execution of the statement:
     *             - evaluates quantification if there is any
     *             - creates assignments as a single tasks
     * @throws ProgramRunException
     */
    public abstract void prepareExecution() throws ProgramRunException;

    protected void waitForTaskToFinish(ThreadManager threadManager) throws ProgramRunException {
            if (threadManager != null) {
                while (threadManager.allDone() == false) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new ProgramRunException("Unable to sleep thread: " + e.getMessage());
                    }
                }
            }
    }

    public abstract String toString();
}
