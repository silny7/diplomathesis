package unityToJava.unity.verification;

import unityToJava.unity.exceptions.NonExistingVariableException;
import unityToJava.unity.expressions.functions.Functions;
import unityToJava.unity.program.UnityProgram;
import unityToJava.unity.program.UnityProgramMemory;
import unityToJava.unity.sections.Sections;

/**
 * provides verification for sorting algorithm of single-dimensional array
 */
public class SortVerification extends ProgramVerification{

    private final String arrayVariableName = "A";

    private Integer arrayLength;
    private Integer index1;
    private Integer index2;

    /**
     * defines whether two neighboring array values need to be sorted
     */
    private boolean sortNeeded = true;
    public SortVerification(){
        //setup
        try {
            Integer[] array = (Integer[]) UnityProgramMemory.getMemory().getVariableValue(arrayVariableName);
            setupLeadsToVerification(array);
        } catch (NonExistingVariableException e) {
            System.out.println("Unable to provide verification");
        }
    }

    private void setupLeadsToVerification(Integer[] array) {
        arrayLength = array.length;
        index1 = Functions.random(arrayLength - 1);
        index2 = index1 + 1;
        sortNeeded = !correctOrderAsc(index1, index2);
        UnityProgram.programLog("LEADS-TO Verification: \nPrepared verification of : \n" + leadsToConditionToString() + "\n", Sections.VERIFICATION);
    }

    @Override
    public void verifyLeadsTo(){
        if (sortNeeded) {
            //if two neighboring values needed to be sorted at the start, verify they are sorted now
            if (correctOrderAsc(index1, index2)) {
                UnityProgram.programLog("LEADS-TO Verification: \nSuccessful verification of : \n" + leadsToConditionToString() + "\n", Sections.VERIFICATION);
            } else {
                UnityProgram.programLog("LEADS-TO Verification: \nUnsuccessful verification of : \n" + leadsToConditionToString() + "\n", Sections.VERIFICATION);
            }
        } else {
            UnityProgram.programLog("LEADS-TO Verification: \nNo need to verify", Sections.VERIFICATION);

        }
    }

    private boolean correctOrderAsc(Integer index1, Integer index2) {
        try {
            Integer[] array = (Integer[]) UnityProgramMemory.getMemory().getVariableValue(arrayVariableName);
            return array[index1] < array[index2];
        } catch (NonExistingVariableException e) {
            System.out.println("Unable to provide verification");
            return false;
        }
    }

    private String leadsToConditionToString(){
        return arrayVariableName + "[" + index1 + "] > " + arrayVariableName + "[" + index2 + "] -> " + arrayVariableName + "[" + index1 + "] < " + arrayVariableName + "[" + index2 + "]";
    }
}
