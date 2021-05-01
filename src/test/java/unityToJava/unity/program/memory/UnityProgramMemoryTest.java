package unityToJava.unity.program.memory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import unityToJava.unity.exceptions.NonExistingVariableException;
import unityToJava.unity.program.UnityProgram;
import unityToJava.unity.program.UnityProgramMemory;

import static org.junit.jupiter.api.Assertions.*;


/**
 * this testing class focuses on testing memory -> reading, writing
 */
public class UnityProgramMemoryTest {

    static UnityProgram program;
    static UnityProgramMemory memory;

    private final String VARIABLE_NAME = "testingVariable";

    @BeforeAll
    public static void setup_test_vars(){
        program = UnityProgram.getUnityProgram();
        memory = UnityProgramMemory.getMemory();
    }

    @Test
    public void addedVariableExistsInMemory() throws NonExistingVariableException {
        memory.initGlobalVariable(VARIABLE_NAME, 0);
        assertEquals(0, (Integer) memory.getVariableValue(VARIABLE_NAME));

        memory.setVariable(VARIABLE_NAME, 10);
        assertEquals(10, (Integer) memory.getVariableValue(VARIABLE_NAME));
    }
}
