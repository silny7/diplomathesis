package unityToJava.unity.sections;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.statements.Statement;
import unityToJava.unity.utils.Randomizer;

import java.util.List;

public class AlwaysSection extends Section {

    public AlwaysSection(List<Statement> statements) {
        super(statements);
    }
}
