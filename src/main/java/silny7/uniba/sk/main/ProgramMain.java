package silny7.uniba.sk.main;

import silny7.uniba.sk.gui.ProgramGUI;
import silny7.uniba.sk.unity.program.configuration.Configuration;

import java.io.IOException;

public class ProgramMain {

    //singleton, reachable from everywhere
    private static ProgramGUI programGUI;

    public static void main(String[] args) {
        setupGUI();
    }

    private static void setupGUI() {
        try {
            Configuration.loadConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        programGUI = new ProgramGUI();
    }
}
