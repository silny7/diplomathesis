package unityToJava.main;

import unityToJava.gui.ProgramGUI;
import unityToJava.unity.program.configuration.Configuration;

import java.io.IOException;

public class ProgramMain {

    public static void main(String[] args) {
        setupGUI();
    }

    private static void setupGUI() {
        try {
            Configuration.loadConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //singleton, reachable from everywhere
        ProgramGUI programGUI = new ProgramGUI();
    }
}
