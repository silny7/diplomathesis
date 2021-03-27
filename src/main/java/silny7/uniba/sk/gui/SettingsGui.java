package silny7.uniba.sk.gui;

import javax.swing.*;

public class SettingsGui extends JFrame {
    /**
     * calls methods to setup GUI
     */
    public SettingsGui(){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setupComponents();
        setupLayout();
        setVisible(true);
    }

    private void setupLayout() {
    }

    private void setupComponents() {
    }
}
