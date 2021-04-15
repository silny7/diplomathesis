package unityToJava.unity.thread;

import unityToJava.unity.statements.assignments.Assignment;
import unityToJava.unity.thread.tasks.AssignmentTask;

public abstract class TaskCreator {

    public static AssignmentTask createAssignmentTask(Assignment assignment){
        return new AssignmentTask(assignment);
    }
}
