package unityToJava.unity.verification;

import unityToJava.unity.exceptions.NonExistingVariableException;
import unityToJava.unity.program.UnityProgram;
import unityToJava.unity.program.UnityProgramMemory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Verificator {

    ProgramVerification programVerification;

    List<LeadsToVerification> verificationList;

    boolean verify = true;

    public Verificator(String programName){
        //programVerification = getVerificationForProgram(programName);
        verificationList = new ArrayList<>();
        setupVerifications();
    }

    private void setupVerifications() {
        for (String varName : UnityProgramMemory.getMemory().getVariableNames()){
            try {
                Object variable = UnityProgramMemory.getMemory().getVariableValue(varName);
                if (variable instanceof Integer){
                    verificationList.add(new LeadsToVerificationValue(varName));
                } else if (variable instanceof Integer[]) {
                    verificationList.add(new LeadsToVerificationArray(varName));
                } else {
                    System.out.println("No verificator for variable" + varName + " of type " + variable.getClass());
                }
            } catch (NonExistingVariableException e) {
                System.out.println("Unsuccessfull verification setup");
                verify = false;
            }
        }
    }

    private ProgramVerification getVerificationForProgram(String programName) {
        if (programName.contains("Sort") || programName.contains("sort")) return new SortVerification();
        else {
            System.out.println("No verification for program " + programName);
        }
        return null;
    }

    public void verifyLeadsTo(){
        if (verify) {
            for (LeadsToVerification verification : verificationList) {
                verification.verifyLeadsTo();
            }
        }
    }


}
