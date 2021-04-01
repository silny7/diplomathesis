package silny7.uniba.sk.unity.sections;

import silny7.uniba.sk.unity.exceptions.ProgramRunException;
import silny7.uniba.sk.unity.program.UnityProgram;
import silny7.uniba.sk.unity.statements.Statement;
import silny7.uniba.sk.unity.utils.Randomizer;

import java.util.List;

import static silny7.uniba.sk.unity.utils.Randomizer.*;

public class AssignSection {
    List<Statement> statements;

    public AssignSection(List<Statement> statements) {
        this.statements = statements;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void execute() throws ProgramRunException {
        shuffleList(statements);
        for (Statement statement : statements){
            statement.evaluateQuantifiers();
            statement.execute();
        }
    }
}
