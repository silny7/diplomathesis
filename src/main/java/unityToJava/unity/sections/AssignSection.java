package unityToJava.unity.sections;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.statements.Statement;
import unityToJava.unity.utils.Randomizer;

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
        Randomizer.shuffleList(statements);

        for (Statement statement : statements){
            statement.prepareExecution();
            statement.execute();
        }
    }
}
