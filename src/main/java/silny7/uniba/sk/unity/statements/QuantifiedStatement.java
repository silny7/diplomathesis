package silny7.uniba.sk.unity.statements;

import java.util.List;

public class QuantifiedStatement extends Statement {

    List<Statement> statements;
    Quantification quantification;


    public QuantifiedStatement(Quantification quantification, List<Statement> statements) {
        this.quantification = quantification;
        this.statements = statements;
    }

    @Override
    public void execute() {

    }
}
