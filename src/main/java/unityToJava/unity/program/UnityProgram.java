package unityToJava.unity.program;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.program.logger.LogManager;
import unityToJava.unity.sections.*;
import unityToJava.unity.thread.ThreadManager;

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

    private ThreadManager threadManager;

    private UnityProgram(){
        memory = new UnityProgramMemory();
        currentSection = Section.DECLARE;
    }

    public void interpret() {
        try {
            infoLog("Unity program " + (programName != null ? programName : "") + " started");
            long startMillis = System.currentTimeMillis();

            executeDeclareSection();
            executeInitiallySection();
            executeAlwaysSection();
            programLog("Starting assign section: ", Section.ASSIGN);
            int cycleCount = 0;
            while (!isFixedPoint()){
                fixedPoint = true;
                executeAssignSection();

                //after every run of assignSection, execute alwaysSection
                executeAlwaysSection();
                //logManager.logMemory(memory);
                cycleCount++;
                //if (cycleCount == 100) setFixedPoint(true);
            }
            //after program run
            logProgramTime(startMillis);
            logMemory();
            shutdownThreadManager();
        } catch (ProgramRunException programRunException) {
            errorLog(programRunException);
        }
    }

    private void logProgramTime(long startMillis) {
        long programTime = System.currentTimeMillis() - startMillis;
        infoLog("Unity program " + (programName != null ? programName : "") + " finished in " + programTime + " miliseconds");
    }

    private void executeAssignSection() throws ProgramRunException {
        setCurrentSection(Section.ASSIGN);
        assignSection.execute();
    }

    private void executeAlwaysSection() throws ProgramRunException {
        if (alwaysSection != null) {
            setCurrentSection(Section.ALWAYS);
            alwaysSection.execute();
        }
    }

    private void executeInitiallySection() throws ProgramRunException {
        if (initiallySection != null) {
            setCurrentSection(Section.INITIALLY);
            initiallySection.execute();
        }
    }

    private void executeDeclareSection() throws ProgramRunException {
        if (declareSection != null) {
            declareSection.declareVariables(memory);
        }
    }

    private void shutdownThreadManager() throws ProgramRunException {
        if (threadManager != null) {
            try {
                threadManager.shutdown();
            } catch (InterruptedException e) {
                throw new ProgramRunException("Unable to stop threadManager " + e.getMessage());
            }
        }
    }

    private void logMemory() {
        logManager.logMemory(memory);
    }


    public synchronized static UnityProgram getUnityProgram(){
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

    public void setThreadManager(ThreadManager threadManager) { this.threadManager = threadManager; }

    public ThreadManager getThreadManager() { return this.threadManager; }
}
