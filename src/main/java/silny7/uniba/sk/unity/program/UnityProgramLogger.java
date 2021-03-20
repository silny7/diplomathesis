package silny7.uniba.sk.unity.program;

import javax.swing.*;

public class UnityProgramLogger {

    JTextArea programLogArea;

    public UnityProgramLogger(JTextArea textArea){
        this.programLogArea = textArea;
    }

    public void log(String logText){
        if (programLogArea == null) {
            System.out.println(logText);
        } else {
            if (!programLogArea.getText().isEmpty()) this.programLogArea.append("\n");
            this.programLogArea.append(logText);
        }
    }
}
