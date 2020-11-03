package silny7.uniba.sk.main;

import silny7.uniba.sk.gui.ProgramGUI;

public class ProgramMain {

    //singleton, reachable from everywhere
    private static ProgramGUI programGUI;

    public static void main(String[] args) {
        setupGUI();
    }

    private static void setupGUI() {
        programGUI = new ProgramGUI();
    }
}
