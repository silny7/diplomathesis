package unityToJava.unity.program.memory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import unityToJava.unity.exceptions.NonExistingVariableException;
import unityToJava.unity.program.UnityProgram;
import unityToJava.unity.program.UnityProgramMemory;

import static org.junit.jupiter.api.Assertions.*;


/**
 * this testing class focuses on testing memory -> reading, writing, copying from WRITE to READ
 */
public class UnityProgramMemoryTest {

    static UnityProgram program;
    static UnityProgramMemory memory;

    private final String VARIABLE_NAME = "testingVariable";

    @BeforeAll
    public static void setup_test_vars(){
        program = UnityProgram.getUnityProgram();
        memory = program.getMemory();
    }

    @Test
    public void addVariableToWriteMemoryAndLoadToRead() throws NonExistingVariableException {
        memory.initGlobalVariable(VARIABLE_NAME, 0);
        assertEquals((Integer) memory.getVariableValue(VARIABLE_NAME), 0);

        memory.setVariable(VARIABLE_NAME, 10);
        MemoryCopy copy = memory.createMemoryCopy(MemoryType.WRITE);
        copy.setMemoryType(MemoryType.READ);
        copy.loadIntoProgramMemory();
        assertEquals((Integer) memory.getVariableValue(VARIABLE_NAME), 10);
    }
}
