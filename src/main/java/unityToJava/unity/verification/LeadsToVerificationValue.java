package unityToJava.unity.verification;

import unityToJava.unity.exceptions.NonExistingVariableException;
import unityToJava.unity.program.UnityProgram;
import unityToJava.unity.program.UnityProgramMemory;
import unityToJava.unity.sections.Sections;

/**
 * verifies leads-to verification for value used in cycles, eg. i, n, etc...
 * i = 0 leads-to i != 0
 */
public class LeadsToVerificationValue extends LeadsToVerification{

    String variableName;
    boolean wasZero = false;
    boolean verify = true;

    public LeadsToVerificationValue(String varName){
        this.variableName = varName;
        setupLeadsTo();
    }

    @Override
    public void verifyLeadsTo() {
        if (verify && wasZero) {
            if (getVariableValue() != 0) {
                UnityProgram.programLog("LEADS-TO Verification: \nSuccessful verification of : \n" + leadsToConditionToString() + "\n", Sections.VERIFICATION);
            }
        } else {
            UnityProgram.programLog("LEADS-TO Verification: \nUnuccessful verification of : \n" + leadsToConditionToString() + "\n", Sections.VERIFICATION);
        }
    }

    @Override
    protected String leadsToConditionToString() {
        return variableName + " == 0 -> " + variableName + " != 0";
    }

    @Override
    public void setupLeadsTo() {
        try {
            Integer value = (Integer) UnityProgramMemory.getMemory().getVariableValue(variableName);
            wasZero = value == 0;
        } catch (NonExistingVariableException | ClassCastException ex1) {
            System.out.println("Could not setup leadsTo verification for variable " + variableName);
            verify = false;
        }
    }

    private Integer getVariableValue(){
        try {
            return (Integer) UnityProgramMemory.getMemory().getVariableValue(variableName);
        } catch (NonExistingVariableException | ClassCastException ex1) {
            System.out.println("Could not setup leadsTo verification for variable " + variableName);
            verify = false;
            return null;
        }
    }
}
