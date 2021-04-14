package unityToJava.unity.sections;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.statements.Statement;
import unityToJava.unity.utils.Randomizer;

import java.util.List;

public class AlwaysSection {
    List<Statement> statements;

    public AlwaysSection(List<Statement> statements) {
        this.statements = statements;
    }

    public void execute() throws ProgramRunException {
        Randomizer.shuffleList(statements);
        for (Statement statement : statements){
            statement.evaluateQuantifiers();
            statement.execute();
        }
    }
}
