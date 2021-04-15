package unityToJava.unity.thread.tasks;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.program.UnityProgram;
import unityToJava.unity.sections.Section;
import unityToJava.unity.statements.assignments.Assignment;

public class AssignmentTask implements Runnable {

    private final Assignment assignment;

    public AssignmentTask(Assignment assignment) {
        this.assignment = assignment;
    }

    @Override
    public void run() {
        try {
            UnityProgram.programLog("Executing assignmentTask " + assignment.toString(), Section.ASSIGN);
            assignment.assign();
            UnityProgram.programLog("Done executing assignmentTask " + assignment.toString(), Section.ASSIGN);

        } catch (ProgramRunException e) {
            UnityProgram.errorLog(e);
        }
    }
}
