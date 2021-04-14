package unityToJava.unity.sections;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.program.UnityProgram;
import unityToJava.unity.statements.Statement;

import java.util.List;

public class InitiallySection {
    List<Statement> statements;

    public InitiallySection(List<Statement> statements) {
        this.statements = statements;
    }

    public void execute() throws ProgramRunException {
        UnityProgram.programLog("Starting initially section: ", Section.INITIALLY);
        for (Statement statement : statements){
            statement.evaluateQuantifiers();
            statement.execute();
        } 
    }
}
