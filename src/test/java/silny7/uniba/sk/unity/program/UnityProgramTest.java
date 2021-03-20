package silny7.uniba.sk.unity.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import silny7.uniba.sk.parser.UnityGrammarException;
import silny7.uniba.sk.unity.exceptions.NonExistingVariableException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UnityProgramTest {


    @Test
    public void sort1_unityProgram_test() throws UnityGrammarException, NonExistingVariableException {
        String program = "Program Sort1 \n \n declare N:integer; \n A: array[0..9] of integer; B: array[0..10] of boolean; \n " +
                "initially N:= 10 [] <<|| i : 0<=i<N :: A[i]:= rand(0,20)>> \n " +
                "assign << [] i : 0 <=i<N-1 :: A[i],A[i+1] := A[i+1], A[i] if A[i] > A[i+1] >> \n " +
                "END";

        Unity unity = new Unity(null, null);
        unity.createProgramFromString(program);
        assertNotNull(unity.getUnityProgram());
        unity.startProgram();
        UnityProgramMemory finalMemory = unity.getUnityProgram().getMemory();
        Integer[] sortedArray = (Integer[]) finalMemory.getVariableValue("A");
        for (int i = 0; i < sortedArray.length - 1; i++){
            Assertions.assertTrue(sortedArray[i] <= sortedArray[i+1]);
        }
        UnityProgram.discardProgram();
    }

    @Test
    public void bubbleSort_unityProgram_test() throws UnityGrammarException {
        String program = "Program bubblesort\n" +
                "declare\n" +
                "    n: integer;\n" +
                "    A: array [0..19] of integer\n" +
                "initially\n" +
                "    n = 20 []\n" +
                "    <<|| i : 0 <= i < n :: A[i] = rand() % 100 >>\n" +
                "assign\n" +
                "    <<[] k : 0 <= k < 2 :: <<|| i : (i % 2 = k) and (0 <= i < n - 1) :: A[i], A[i+1] := A[i+1], A[i] if A[i] > A[i+1] >> >>\n" +
                "end";
        Unity unity = new Unity(null, null);
        unity.createProgramFromString(program);
        assertNotNull(unity.getUnityProgram());
        unity.startProgram();
        UnityProgram.discardProgram();
    }

    @Test
    public void binomical_unityProgram_test() throws UnityGrammarException {
        String program = "Program binomical \n" +
                "declare \n" +
                "    N:integer; \n" +
                "    c: array[0..9] of array[0..9] of integer; \n" +
                "initially \n" +
                "    N := 10 \n" +
                "assign \n" +
                "    << [] n : 0<=n<N :: c[n,0]  := 1 ||  c[n,n] := 1 [] <<|| k: 0<k<n :: c[n,k] := c[n-1,k-1]+c[n-1,k] >> >> \n" +
                "END";
        Unity unity = new Unity(null, null);
        unity.createProgramFromString(program);
        assertNotNull(unity.getUnityProgram());
        unity.startProgram();
        UnityProgram.discardProgram();
    }

    @Test
    public void shortestPath_unityProgram_test() throws UnityGrammarException {
        String program = "Program shortestpath\n" +
                            "declare\n" +
                            "    n,k: integer;\n" +
                            "    D: array [0..9, 0..9] of integer\n" +
                            "initially\n" +
                            "    n := 10[]\n" +
                            "    k := 0 []\n" +
                            "    <<|| i,j : (0<=i<n) and (0<=j<n) :: D[i,j] := rand(0,20) >>\n" +
                            "assign\n" +
                            "   <<|| i,j : (0<=i<n) and (0<=j<n) ::\n" +
                            "        D[i,j] := min(D[i,j], D[i,k] + D[k,j]) \n" +
                            "    >> \n" +
                            "   ||  k := k + 1 if k < n - 1\n" +
                         "end ";
        Unity unity = new Unity(null, null);
        unity.createProgramFromString(program);
        assertNotNull(unity.getUnityProgram());
        unity.startProgram();
        UnityProgram.discardProgram();
    }
}
