package silny7.uniba.sk.unity.program;

import silny7.uniba.sk.parser.UnityGrammarException;
import silny7.uniba.sk.unity.exceptions.ProgramRunException;

import javax.swing.*;

public class UnityErrorLogger {

    JTextArea logTextArea;

    public UnityErrorLogger(JTextArea loggerArea){
        this.logTextArea = loggerArea;
    }

    public void log(String logText){
        if (!logTextArea.getText().isEmpty()) this.logTextArea.append("\n");
        this.logTextArea.append(logText);
    }

    public void log(UnityGrammarException unityGrammarException) {
        log(unityGrammarException.getErrorMessages());
    }

    public void log(ProgramRunException programRunException) { log(programRunException.getMessage()); }

    private void deleteLogs(){
        this.logTextArea.setText("");
    }


}
