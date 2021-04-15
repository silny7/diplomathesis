package unityToJava.unity.statements.assignments;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.program.memory.MemoryCopy;
import unityToJava.unity.statements.AssignmentStatement;
import unityToJava.unity.statements.Quantification;

public class QuantifiedAssignment extends Assignment {
    Quantification quantification;
    AssignmentStatement assignmentStatement;

    public QuantifiedAssignment(Quantification quantification, AssignmentStatement assignmentStatement) {
        this.quantification = quantification;
        this.assignmentStatement = assignmentStatement;
    }

    @Override
    public String toString() {
        return quantification.toString() + " " + assignmentStatement.toString();
    }

    @Override
    public void prepareExecution() throws ProgramRunException {
        //evaluateQuantification();
        quantification.initVariables();
        quantification.evaluate();
        for (MemoryCopy memoryCopy : quantification.getMemorySnapshots()){
            memoryCopy.loadIntoProgramMemory();
            for (Assignment assignment : assignmentStatement.getAssignments()){
                assignment.prepareExecution();
            }
        }
        quantification.destroyVariables();
    }

    private void evaluateQuantification() throws ProgramRunException {
        quantification.initVariables();
        quantification.evaluate();
        for (MemoryCopy memoryCopy : quantification.getMemorySnapshots()){
            memoryCopy.loadIntoProgramMemory();
            for (Assignment assignment : assignmentStatement.getAssignments()){
                assignment.prepareExecution();
            }
        }
        quantification.destroyVariables();
    }

    @Override
    public void assign() throws ProgramRunException {
        quantification.initVariables();
        if (!quantification.isEvaluated()) {
            quantification.evaluate();
        }

        if (!quantification.getMemorySnapshots().isEmpty()){
            for (MemoryCopy memCopy : quantification.getMemorySnapshots()){
                memCopy.loadIntoProgramMemory();
                for (Assignment assignment : assignmentStatement.getAssignments()){
                    if (!(assignment instanceof QuantifiedAssignment)){
                        assignment.assign();
                    }
                }
            }
            for (Assignment assignment : assignmentStatement.getAssignments()){
                if (assignment instanceof QuantifiedAssignment){
                    assignment.assign();
                }
            }
        }
        quantification.destroy();
    }
}
