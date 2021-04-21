package unityToJava.unity.program;

import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.program.configuration.Configuration;
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

    private static UnityProgram instance = null;
    private static LogManager logManager;
    private static Section currentSection;

    private ThreadManager threadManager;

    private UnityProgram(){
        currentSection = Section.DECLARE;
    }

    public void interpret() {
        try {
            infoLog("Unity program " + (programName != null ? programName : "") + " started");
            long startMillis = System.currentTimeMillis();

            initializeThreadManager();
            executeDeclareSection();
            executeInitiallySection();
            executeAlwaysSection();
            programLog("Starting assign section: ", Section.ASSIGN);
            int cycles = 0;
            while (!isFixedPoint()){
                fixedPoint = true;
                executeAssignSection();

                //after every run of assignSection, execute alwaysSection
                executeAlwaysSection();
                cycles++;
            }
            //after program run
            logProgramTime(startMillis);
            logNumberOfCycles(cycles);
            logMemory();
            //shutdownThreadManager();
            discardProgramMemory();
        } catch (ProgramRunException programRunException) {
            errorLog(programRunException);
        }
    }

    private void logNumberOfCycles(int cycles) {
        infoLog("Unity program finished in " + cycles + " runs of assign section");
    }

    //todo make ThreadManager Singleton class
    private void initializeThreadManager() {
        if (Configuration.isMultithreading() && threadManager == null) {
            threadManager = ThreadManager.getInstance();
        }
    }

    private void logProgramTime(long startMillis) {
        long programTime = System.currentTimeMillis() - startMillis;
        infoLog("Unity program " + (programName != null ? programName : "") + " finished in " + programTime + " miliseconds");
    }

    private void executeAssignSection() throws ProgramRunException {
        setCurrentSection(Section.ASSIGN);
        assignSection.execute();

        //checkSectionCompleted();
    }

    private void executeAlwaysSection() throws ProgramRunException {
        if (alwaysSection != null) {
            setCurrentSection(Section.ALWAYS);
            alwaysSection.execute();
        }

        //checkSectionCompleted();
    }

    private void executeInitiallySection() throws ProgramRunException {
        if (initiallySection != null) {
            setCurrentSection(Section.INITIALLY);
            initiallySection.execute();
        }
        programLog("Memory after Initially section", Section.INITIALLY);
        programLog(UnityProgramMemory.getMemory().print(), Section.INITIALLY);
    }

    //Todo this has to be done after also writing to memory was done
    private void checkSectionCompleted() {
        if (threadManager != null && Configuration.isMultithreading()){
            while (!threadManager.allDone()) {
                //do nothing, just wait
            }
        }
    }

    private void executeDeclareSection() throws ProgramRunException {
        if (declareSection != null) {
            declareSection.declareVariables();
        }
        programLog("Memory after Declare section", Section.DECLARE);
        programLog(UnityProgramMemory.getMemory().print(), Section.DECLARE);
    }

    public void shutdownThreadManager() throws ProgramRunException {
        if (threadManager != null) {
            try {
                threadManager.shutdown();
            } catch (InterruptedException e) {
                throw new ProgramRunException("Unable to stop threadManager " + e.getMessage());
            }
        }
    }

    private void logMemory() {
        logManager.logMemory(UnityProgramMemory.getMemory());
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
        discardProgramMemory();
    }

    private static void discardProgramMemory() {
        UnityProgramMemory.discard();
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

    public boolean isFixedPoint() { return fixedPoint; }

    public void setFixedPoint(boolean fixedPoint) { this.fixedPoint = fixedPoint; }

    public void setUnityLogger(LogManager logManager) {
        UnityProgram.logManager = logManager;
    }

    public void setThreadManager(ThreadManager threadManager) { this.threadManager = threadManager; }

    public ThreadManager getThreadManager() { return this.threadManager; }
}
