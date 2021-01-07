package silny7.uniba.sk.unity.program;

import silny7.uniba.sk.parser.UnityGrammarException;

import javax.swing.*;

public class UnityLogger {

    JTextArea logTextArea;

    public UnityLogger(JTextArea loggerArea){
        this.logTextArea = loggerArea;
    }

    public void log(String logText){
        if (!logTextArea.getText().isEmpty()) this.logTextArea.append("\n");
        this.logTextArea.append(logText);
    }

    public void log(UnityGrammarException unityGrammarException) {
        log(unityGrammarException.getErrorMessages());
    }

    private void deleteLogs(){
        this.logTextArea.setText("");
    }

}
