package silny7.uniba.sk.unity.program;

import silny7.uniba.sk.unity.exceptions.ProgramRunException;
import silny7.uniba.sk.unity.sections.AlwaysSection;
import silny7.uniba.sk.unity.sections.AssignSection;
import silny7.uniba.sk.unity.sections.DeclareSection;
import silny7.uniba.sk.unity.sections.InitiallySection;

/**
 * singleton class
 */
public class UnityProgram {

    //program structure
    private String programName;
    private DeclareSection declareSection;
    private AlwaysSection alwaysSection;
    private InitiallySection initiallySection;
    private AssignSection assignSection;

    //flags
    private boolean fixedPoint = false;

    //program memory
    private static UnityProgramMemory memory;

    private static UnityProgram instance = null;
    private static UnityProgramLogger unityProgramLogger;
    private static UnityErrorLogger unityErrorLogger;

    private UnityProgram(){
    }

    public void interpret(){
        if (memory == null) memory = new UnityProgramMemory();

        try {
            if (declareSection != null) declareSection.declareVariables(memory);
            if (alwaysSection != null) alwaysSection.execute();
            if (initiallySection != null) initiallySection.execute();
            assignSection.execute();
        } catch (ProgramRunException programRunException) {
            errorLog(programRunException);
        }
    }

    public static UnityProgram getUnityProgram(){
        if (instance == null) instance = new UnityProgram();
        return instance;
    }

    public static void programLog(String message){
        unityProgramLogger.log(message);
    }

    private static void errorLog(ProgramRunException programRunException){
        unityErrorLogger.log(programRunException);
    }




    //GETTER, SETTER region
    public void setProgramName(String programName) { this.programName = programName; }
    public String getProgramName() { return this.programName; }
    public void setDeclareSection(DeclareSection declareSection) { this.declareSection = declareSection; }
    public DeclareSection getDeclareSection() { return declareSection; }
    public AlwaysSection getAlwaysSection() { return alwaysSection; }
    public void setAlwaysSection(AlwaysSection alwaysSection) { this.alwaysSection = alwaysSection; }
    public InitiallySection getInitiallySection() { return initiallySection; }
    public void setInitiallySection(InitiallySection initiallySection) { this.initiallySection = initiallySection; }
    public AssignSection getAssignSection() { return assignSection; }
    public void setAssignSection(AssignSection assignSection) { this.assignSection = assignSection; }

    public void setUnityProgramLogger(UnityProgramLogger programLogger) { this.unityProgramLogger = programLogger; }
    public void setUnityErrorLogger(UnityErrorLogger errorLogger) { this.unityErrorLogger = errorLogger; }

    public UnityProgramMemory getMemory() { return this.memory; }

    public boolean isFixedPoint() { return fixedPoint; }

    public void setFixedPoint(boolean fixedPoint) { this.fixedPoint = fixedPoint; }
}
