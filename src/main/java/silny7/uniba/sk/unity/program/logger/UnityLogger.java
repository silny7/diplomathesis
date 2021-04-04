package silny7.uniba.sk.unity.program.logger;

import silny7.uniba.sk.parser.UnityGrammarException;
import silny7.uniba.sk.unity.exceptions.ProgramRunException;
import silny7.uniba.sk.unity.program.UnityProgramMemory;
import silny7.uniba.sk.unity.program.configuration.Configuration;

import javax.swing.*;

public class UnityLogger {

    JTextArea programLogArea;
    JTextArea errorLogArea;

    public UnityLogger(JTextArea programLogArea, JTextArea errorLogArea) {
        this.programLogArea = programLogArea;
        this.errorLogArea = errorLogArea;
    }

    //region GUI output window
    private void logProgram(final String logText){
        if (programLogArea == null) {
            System.out.println(logText);
        } else {
            if (!programLogArea.getText().isEmpty()) programLogArea.append("\n");
            programLogArea.append(logText);
        }
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

    //region GUI error window
    private void log(MessageType messageType, String logText){
        if (errorLogArea == null) {
            System.out.println(createLogMessage(messageType, logText));
        } else {
            if (!errorLogArea.getText().isEmpty()) this.errorLogArea.append("\n");
            this.errorLogArea.append(createLogMessage(messageType, logText));
            this.errorLogArea.update(this.errorLogArea.getGraphics());
        }
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

    private void deleteProgramLogs() {
        this.programLogArea.setText("");
    }

    private void deleteErrorLogs() {
        this.errorLogArea.setText("");
    }

    private void deleteLogs(){
        deleteErrorLogs();
        deleteProgramLogs();
    }



}
