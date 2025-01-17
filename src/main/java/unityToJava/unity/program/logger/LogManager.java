package unityToJava.unity.program.logger;

import unityToJava.parser.UnityGrammarException;
import unityToJava.unity.exceptions.ProgramRunException;
import unityToJava.unity.program.UnityProgramMemory;
import unityToJava.unity.program.configuration.Configuration;

import javax.swing.*;

public class LogManager {

    Logger programLogger;
    Logger errorLogger;

    Thread programLoggerThread;
    Thread errorLoggerThread;

    private final Integer PROGRAM_LOG_QUEUE_CAP = 10000;
    private final Integer ERROR_LOG_QUEUE_CAP = 100;

    public LogManager(JTextArea programLog, JTextArea errorLog){
        programLogger = new Logger(programLog, PROGRAM_LOG_QUEUE_CAP, 2);
        errorLogger = new Logger(errorLog, ERROR_LOG_QUEUE_CAP, 0);

        programLoggerThread = new Thread(programLogger);
        errorLoggerThread = new Thread(errorLogger);
    }

    public void startLogging(){
        startProgramLogging();
        startErrorLogging();
    }

    public void startProgramLogging() {
        if (!programLoggerThread.isAlive()) programLoggerThread.start();
    }

    public void startErrorLogging() {
        if (!errorLoggerThread.isAlive()) errorLoggerThread.start();
    }

    //REGION PROGRAM LOGGING:
    private void logProgram(final String logText){
        programLogger.queueLog(logText);
    }
    public void logMemory(UnityProgramMemory memory) {
        //todo prettyPrint
        logProgram(memory.print());
    }
    public void logDeclaration(String declarationLog){
        if (Configuration.isLogAll() || Configuration.isLogDeclarations()){
            logProgram(declarationLog);
        }
    }
    public void logInitialization(String initializationLog) {
        if (Configuration.isLogAll() || Configuration.isLogInitializations()){
            logProgram(initializationLog);
        }
    }
    public void logAssignment(String assignmentLog){
        if (Configuration.isLogAll() || Configuration.isLogAssignments()){
            logProgram(assignmentLog);
        }
    }
    public void logProgramMessage(String logText){
        logProgram(logText);
    }

    public void logVerification(String message) {
        logProgram(message);
    }


    //REGION ERROR LOGGING
    private void log(MessageType messageType, String logText){
        errorLogger.queueLog(createLogMessage(messageType, logText));
    }

    public void logInfo(String logText) {
        log(MessageType.INFO, logText);
    }

    public void logError(String logText){
        log(MessageType.ERROR, logText);
    }

    public void logError(UnityGrammarException unityGrammarException) {
        logError(unityGrammarException.getErrorMessages());
    }

    public void logError(ProgramRunException programRunException) {
        logError(programRunException.getMessage());
    }

    public void logWarn(String logText){
        log(MessageType.WARN, logText);
    }

    private String createLogMessage(MessageType messageType, String logText) {
        return "[" + messageType + "] " + logText;
    }

    public void stopLogging() {
        errorLogger.stop();
        programLogger.stop();
    }

}
