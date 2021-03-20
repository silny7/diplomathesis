package silny7.uniba.sk.unity.sections;

import silny7.uniba.sk.unity.exceptions.ProgramRunException;
import silny7.uniba.sk.unity.statements.Statement;

import java.util.List;

public class AssignSection {
    List<Statement> statements;

    public AssignSection(List<Statement> statements) {
        this.statements = statements;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void execute() throws ProgramRunException {
        for (Statement statement : statements){
            statement.evaluateQuantifiers();
            statement.execute();
        }
    }
}
