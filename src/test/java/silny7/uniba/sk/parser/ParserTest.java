package silny7.uniba.sk.parser;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import silny7.uniba.sk.unity.Unity;
import silny7.uniba.sk.unity.UnityProgram;
import silny7.uniba.sk.unity.expressions.SimpleVariable;
import silny7.uniba.sk.unity.sections.AssignSection;
import silny7.uniba.sk.unity.sections.DeclareSection;
import silny7.uniba.sk.unity.statements.AssignmentStatement;
import silny7.uniba.sk.unity.statements.EnumeratedAssignment;
import silny7.uniba.sk.unity.statements.VariableDeclaration;
import silny7.uniba.sk.unity.variables.BaseType;
import silny7.uniba.sk.unity.variables.SimpleType;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {


    @Test
    public void simpleInputTest() throws UnityGrammarException {
        Unity unity = new Unity();
        String program = "Program testProgram \n declare A:integer; \n assign A = 5 + 5 \n END";
        unity.createProgramFromString(program);
        assertNotNull(unity.getUnityProgram());
        UnityProgram unityProgram = unity.getUnityProgram();
        DeclareSection declareSection = unityProgram.getDeclareSection();
        AssignSection assignSection = unityProgram.getAssignSection();
        assertNotNull(declareSection);
        assertNotNull(assignSection);

        //declare section test
        assertEquals(declareSection.getDeclarations().size(), 1);
        VariableDeclaration variableDeclaration = declareSection.getDeclarations().get(0);
        assertEquals(variableDeclaration.getVariables().size(), 1);
        assertEquals(variableDeclaration.getVariables().get(0).getVarName(), "A");
        SimpleType simpleType = (SimpleType) variableDeclaration.getType();
        assertEquals(simpleType.getType(), SimpleType.Type.Integer);


        //assign section test
        assertEquals(assignSection.getStatements().size(), 1);
        AssignmentStatement assignmentStatement = (AssignmentStatement) assignSection.getStatements().get(0);
        assertEquals(assignmentStatement.getAssignments().size(), 1);
        EnumeratedAssignment enumeratedAssignment = (EnumeratedAssignment) assignmentStatement.getAssignments().get(0);
        assertEquals(enumeratedAssignment.getVars().size(), 1);
        SimpleVariable variable = (SimpleVariable) enumeratedAssignment.getVars().get(0);
        assertEquals(variable.getVariableName(), "A");
    }

    @Test
    public void sort1UnityTest() throws UnityGrammarException {
        String program = "Program Sort1 \n \n declare N:integer; \n A: array[0..10] of integer; \n " +
                         "initially N:= 10 [] <<|| i : 0<=i<=N :: A[i]:= Random(0,20)>> \n " +
                         "assign << [] i : 0 <=i<N :: A[i],A[i+1] := A[i+1], A[i] if A[i] > A[i+1] >> \n " +
                         "END";

        Unity unity = new Unity();
        unity.createProgramFromString(program);
        assertNotNull(unity.getUnityProgram());
    }

    @Disabled("Disabled until error fixed")
    @Test
    public void binomicalUnityTest() throws UnityGrammarException {
        String program = "Program binomical \n \n declare N:integer; c: array[0..10] of array[0..10] of integer; \n " +
                         "initially N := 10 \n " +
                         "assign << [] n : 0<=n<N :: c[n,0]  := 1 ||  c[n,n] := 1 [] <<|| k: 0<k<n :: c[n,k] := c[n-1,k-1]+c[n-1,k] >> >> \n " +
                         "END";

        Unity unity = new Unity();
        unity.createProgramFromString(program);
        assertNotNull(unity.getUnityProgram());
    }
}
