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
        return quantification.toString() + " " + assignmentStatement.toString();
    }

    @Override
    public void evaluateQuantifiers() {
        quantification.initVariables();
        quantification.evaluate();

        //todo
        //check all the memoryCopies created in quantifiaction
        //load them into memory
        //evaluate statements

        quantification.destroyVariables();
    }

    @Override
    public void assign() {
        quantification.initVariables();
        quantification.evaluate();

        //todo

        quantification.destroyVariables();
    }
}
