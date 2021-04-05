package silny7.uniba.sk.unity.sections;

import silny7.uniba.sk.unity.exceptions.ProgramRunException;
import silny7.uniba.sk.unity.program.UnityProgramMemory;
import silny7.uniba.sk.unity.statements.Statement;
import silny7.uniba.sk.unity.utils.Randomizer;

import java.util.Collections;
import java.util.List;

import static silny7.uniba.sk.unity.utils.Randomizer.*;

public class AlwaysSection {
    List<Statement> statements;

    public AlwaysSection(List<Statement> statements) {
        this.statements = statements;
    }

    public void execute() throws ProgramRunException {
        shuffleList(statements);
        for (Statement statement : statements){
            statement.evaluateQuantifiers();
            statement.execute();
        }
    }
}
