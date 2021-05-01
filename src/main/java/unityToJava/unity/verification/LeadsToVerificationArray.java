package unityToJava.unity.verification;

import unityToJava.unity.exceptions.NonExistingVariableException;
import unityToJava.unity.program.UnityProgram;
import unityToJava.unity.program.UnityProgramMemory;
import unityToJava.unity.sections.Sections;

/**
 * verifies leads-to of one dimensional array
 * !sorted A -> sorted A
 */
public class LeadsToVerificationArray extends LeadsToVerification{

    String variableName;

    boolean sorted;
    boolean verify = true;

    public LeadsToVerificationArray(String varName){
        this.variableName = varName;
        setupLeadsTo();
    }

    @Override
    public void verifyLeadsTo() {
        if (verify && !sorted){
            try {
                Integer[] array = (Integer[]) UnityProgramMemory.getMemory().getVariableValue(variableName);
                if (checkArraySorted(array)) {
                    UnityProgram.programLog("LEADS-TO Verification: \nSuccessful verification of : \n" + leadsToConditionToString() + "\n", Sections.VERIFICATION);
                } else {
                    UnityProgram.programLog("LEADS-TO Verification: \nUnsuccessful verification of : \n" + leadsToConditionToString() + "\n", Sections.VERIFICATION);
                }
            } catch (NonExistingVariableException | ClassCastException ex1) {
                System.out.println("Could not setup leadsTo verification for variable " + variableName);
                verify = false;
            }
        }
        else {
            UnityProgram.programLog("LEADS-TO Verification: \nUnsuccessful verification of : \n" + leadsToConditionToString() + "\n", Sections.VERIFICATION);
        }
    }

    @Override
    protected String leadsToConditionToString() {
        return "!sorted " + variableName + " -> sorted " + variableName;
    }

    @Override
    public void setupLeadsTo() {
        try {
            Integer[] array = (Integer[]) UnityProgramMemory.getMemory().getVariableValue(variableName);
            sorted = checkArraySorted(array);
        } catch (NonExistingVariableException | ClassCastException ex1) {
            System.out.println("Could not setup leadsTo verification for variable " + variableName);
            verify = false;
        }
    }

    private boolean checkArraySorted(Integer[] array) {
        if (array.getClass().getComponentType().isArray()) {
            System.out.println("Invalid verification for multidimensonal array");
            verify = false;
            return false;
        }
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }
}
