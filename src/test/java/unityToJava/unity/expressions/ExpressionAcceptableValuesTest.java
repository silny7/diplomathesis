package unityToJava.unity.expressions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.expressions.operators.BinaryOperator;
import unityToJava.unity.expressions.variables.SimpleVariable;
import unityToJava.unity.program.UnityProgram;
import unityToJava.unity.program.UnityProgramMemory;

import static org.junit.jupiter.api.Assertions.*;

/**
 * testing class focuses on expression.lowestAcceptableValue, expression.highestAcceptableValue methods
 */
public class ExpressionAcceptableValuesTest {

    static Constant testConstant;
    static SimpleVariable testSimpleVariable; // N
    static SimpleVariable testBoundedVariable; // i
    // 0 <= i
    static BinaryExpression testBinaryExpression01;
    // i <= N
    static BinaryExpression testBinaryExpression02;
    //0 <= i <= N
    static BinaryExpression testBinaryExpressionComplex;

    static UnityProgram program;
    static UnityProgramMemory memory;

    @BeforeAll
    public static void setupExpressions() throws ProgramRunException {
        UnityProgram program = UnityProgram.getUnityProgram();
        memory = UnityProgramMemory.getMemory();

        testSimpleVariable = new SimpleVariable("N");
        testBoundedVariable = new SimpleVariable("i");
        memory.initGlobalVariable("N", 10);
        memory.initBoundedVariable("i", 5);
        testConstant = new Constant(0);

        testBinaryExpression01 = new BinaryExpression(BinaryOperator.LESS_OR_EQUAL, testConstant, testBoundedVariable);
        testBinaryExpression02 = new BinaryExpression(BinaryOperator.LESS_OR_EQUAL, testBoundedVariable, testSimpleVariable);
        testBinaryExpressionComplex = new BinaryExpression(BinaryOperator.AND, testBinaryExpression01, testBinaryExpression02);
    }

    @Test
    public void getAcceptableValues() throws ProgramRunException {
        assertEquals(testBinaryExpression01.lowestAcceptableValue(), 0);
        assertEquals(testBinaryExpression01.highestAcceptableValue(), 5);

        assertEquals(testBinaryExpression02.lowestAcceptableValue(), 5);
        assertEquals(testBinaryExpression02.highestAcceptableValue(), 10);

        assertEquals(testBinaryExpressionComplex.lowestAcceptableValue(), 0);
        assertEquals(testBinaryExpressionComplex.highestAcceptableValue(), 10);
    }



}
