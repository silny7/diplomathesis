package unityToJava.unity.thread.tasks;

import unityToJava.unity.program.memory.MemoryCopy;
import unityToJava.unity.statements.assignments.Assignment;
import unityToJava.unity.thread.tasks.AssignmentTask;
import unityToJava.unity.thread.tasks.Task;

public abstract class TaskCreator {

    public static Task createAssignmentTask(MemoryCopy memoryCopy, Assignment assignment){
        return new AssignmentTask(memoryCopy, assignment);
    }
}
