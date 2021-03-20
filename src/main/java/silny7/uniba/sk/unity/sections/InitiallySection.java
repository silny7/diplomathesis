package silny7.uniba.sk.unity.sections;

import silny7.uniba.sk.unity.exceptions.ProgramRunException;
import silny7.uniba.sk.unity.program.UnityProgramMemory;
import silny7.uniba.sk.unity.statements.Statement;

import java.util.List;

public class InitiallySection {
    List<Statement> statements;

    public InitiallySection(List<Statement> statements) {
        this.statements = statements;
    }

    public void execute() throws ProgramRunException {
        for (Statement statement : statements){
            statement.evaluateQuantifiers();
            statement.execute();
        }
    }
}
