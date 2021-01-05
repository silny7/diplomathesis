package silny7.uniba.sk.unity.statements;

public class QuantifiedAssignment extends Assignment {
    Quantification quantification;
    AssignmentStatement assignmentStatement;

    public QuantifiedAssignment(Quantification quantification, AssignmentStatement assignmentStatement) {
        this.quantification = quantification;
        this.assignmentStatement = assignmentStatement;
    }

    @Override
    public String toString() {
        return null;
    }
}
