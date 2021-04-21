package unityToJava.unity.statements;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.program.memory.MemoryCopy;
import unityToJava.unity.thread.ThreadManager;
import unityToJava.unity.thread.tasks.Task;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;

public abstract class Statement {


    public abstract void execute() throws ProgramRunException;

    /**
     * prepares execution of the statement:
     *             - evaluates quantification if there is any
     *             - creates assignments as a single tasks
     * @throws ProgramRunException
     * @param memorySnapshots
     */
    public abstract void prepareExecution(List<MemoryCopy> memorySnapshots) throws ProgramRunException;

    protected void waitForTaskToFinish(ThreadManager threadManager, List<Future<?>> tasks) {
        while (threadManager.allDone(tasks) == false){
            //wait until all tasks are finished
        }
    }

    public abstract String toString();

    protected abstract Collection<? extends Task> getTasks();
}
