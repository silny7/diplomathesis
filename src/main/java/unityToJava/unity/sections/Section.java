package unityToJava.unity.sections;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.statements.Statement;
import unityToJava.unity.utils.Randomizer;

import java.util.List;

public abstract class Section {
    List<Statement> statements;

    public Section(List<Statement> statements) {
        this.statements = statements;
    }

    public void execute() throws ProgramRunException {
        Randomizer.shuffleList(statements);
        for (Statement statement : statements){
            statement.prepareExecution(null);
            statement.execute();
        }
    }

    public List<Statement> getStatements() {
        return statements;
    }
}
