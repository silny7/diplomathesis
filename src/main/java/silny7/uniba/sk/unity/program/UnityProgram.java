package silny7.uniba.sk.unity.program;

import silny7.uniba.sk.unity.exceptions.ProgramRunException;
import silny7.uniba.sk.unity.program.logger.LogManager;
import silny7.uniba.sk.unity.sections.*;

import static silny7.uniba.sk.unity.sections.Section.*;

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
    private static LogManager logManager;
    private static Section currentSection;

    private UnityProgram(){
        memory = new UnityProgramMemory();
        currentSection = DECLARE;
    }

    public void interpret() {
        try {
            infoLog("Unity program " + (programName != null ? programName : "") + " started");
            long startMillis = System.currentTimeMillis();
            if (declareSection != null) declareSection.declareVariables(memory);
            if (initiallySection != null) {
                setCurrentSection(INITIALLY);
                initiallySection.execute();
            }
            programLog("Starting assign section: ", ASSIGN);
            while (!isFixedPoint()){
                setCurrentSection(ASSIGN);
                fixedPoint = true;
                assignSection.execute();
                //after every run of assignSection, execute alwaysSection
                if (alwaysSection != null) {
                    setCurrentSection(ALWAYS);
                    alwaysSection.execute();
                }
            }
            long programTime = System.currentTimeMillis() - startMillis;
            infoLog("Unity program " + (programName != null ? programName : "") + " finished in " + programTime + " miliseconds");
            logManager.logMemory(memory);
        } catch (ProgramRunException programRunException) {
            errorLog(programRunException);
        }
    }


    public static UnityProgram getUnityProgram(){
        if (instance == null) instance = new UnityProgram();
        return instance;
    }

    public static Section getCurrentSection(){
        return currentSection;
    }

    public static void setCurrentSection(Section section){
        currentSection = section;
    }

    public static void programLog(String message, Section section){
        switch (section){
            case DECLARE: logManager.logDeclaration(message); break;
            case INITIALLY: logManager.logInitialization(message); break;
            case ALWAYS:
            case ASSIGN:
                logManager.logAssignment(message); break;
            default: logManager.logProgramMessage(message);
        }
    }

    public static void errorLog(ProgramRunException programRunException){
        logManager.logError(programRunException);
    }

    public static void infoLog(String logText){
        logManager.logInfo(logText);
    }


    public static void discardProgram() {
        instance = null;
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

    public UnityProgramMemory getMemory() { return this.memory; }

    public boolean isFixedPoint() { return fixedPoint; }

    public void setFixedPoint(boolean fixedPoint) { this.fixedPoint = fixedPoint; }

    public void setUnityLogger(LogManager logManager) {
        UnityProgram.logManager = logManager;
    }
}
