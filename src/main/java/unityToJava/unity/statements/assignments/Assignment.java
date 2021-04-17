package unityToJava.unity.statements.assignments;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.program.UnityProgram;
import unityToJava.unity.program.memory.MemoryCopy;
import unityToJava.unity.thread.tasks.Task;

import java.util.Collection;
import java.util.List;

public abstract class Assignment {

    public abstract String toString();

    public abstract void prepareExecution(List<MemoryCopy> memorySnapshots) throws ProgramRunException;

    public abstract void executeAssignment(MemoryCopy boundedMemoryToInject) throws ProgramRunException;

    public void log(String logMessage){
        UnityProgram.programLog(logMessage, UnityProgram.getCurrentSection());
    }

    public abstract Collection<? extends Task> getTasks();
}
