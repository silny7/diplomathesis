package unityToJava.unity.sections;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.statements.Statement;
import unityToJava.unity.utils.Randomizer;

import java.util.List;

public class AssignSection extends Section{

    public AssignSection(List<Statement> statements) {
        super(statements);
    }
}
