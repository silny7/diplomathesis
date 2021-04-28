package unityToJava.unity.sections;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.program.UnityProgram;
import unityToJava.unity.statements.Statement;

import java.util.List;

public class InitiallySection extends Section{

    public InitiallySection(List<Statement> statements) {
        super(statements);
    }

    @Override
    public void execute() throws ProgramRunException {
        for (Statement statement : statements){
            statement.prepareExecution(null);
            statement.execute();
        }
    }
}
