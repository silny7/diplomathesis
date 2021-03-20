package silny7.uniba.sk.unity.statements;

import silny7.uniba.sk.unity.exceptions.ProgramRunException;
import silny7.uniba.sk.unity.program.memory.Memory;
import silny7.uniba.sk.unity.program.memory.MemoryCopy;

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
    public void evaluateQuantifiers() throws ProgramRunException {
        quantification.initVariables();
        quantification.evaluate();

        //todo
        //check all the memoryCopies created in quantifiaction
        //load them into memory
        //evaluate statements

        quantification.destroy();
    }

    @Override
    public void assign() throws ProgramRunException {
        quantification.initVariables();
        quantification.evaluate();

        if (quantification.getMemorySnapshots().isEmpty()){
            quantification.destroy();
            //there are not values for boundedVals for which boolExpr in quantification is true
        } else {
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
            quantification.destroy();
        }
    }
}
