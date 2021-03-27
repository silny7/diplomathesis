
package silny7.uniba.sk.gui;

import silny7.uniba.sk.parser.UnityGrammarException;
import silny7.uniba.sk.unity.program.Unity;
import silny7.uniba.sk.unity.program.UnityProgram;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author boris.silny
 */
public class ProgramGUI extends JFrame {

    private Unity unityProgramHolder;


    //GUI components:

    private JTextArea errorTA;
    private JTextArea inputCodeTA;
    private JTextArea outputTA;

    private JButton loadButton;
    private JButton runButton;

    private JScrollPane scrollPaneError;
    private JScrollPane scrollPaneInput;
    private JScrollPane scrollPaneOutput;

    private JMenu settings;

    private Dimension guiScreenSize;

    /**
     * calls methods to setup GUI
     */
    public ProgramGUI(){
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

        guiScreenSize = getScreenSize();
        setupComponents();
        setupLayout();
        setVisible(true);
    }

    /**
     * setups layout for JFrame
     *
     */
    private void setupLayout() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("UnityToJava");

        setResizable(false);
        setSize(guiScreenSize);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollPaneInput, (int) (guiScreenSize.getWidth() * 0.6), (int) (guiScreenSize.getWidth() * 0.6), (int) (guiScreenSize.getWidth() * 0.6))
                                        .addComponent(scrollPaneError, (int) (guiScreenSize.getWidth() * 0.6), (int) (guiScreenSize.getWidth() * 0.6), (int) (guiScreenSize.getWidth() * 0.6)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(runButton, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(loadButton, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addComponent(scrollPaneOutput)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollPaneInput)
                                        .addComponent(scrollPaneOutput, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(scrollPaneError, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(runButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(loadButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
    }


    /**
     * creates all components
     */
    private void setupComponents() {
        inputCodeTA = new JTextArea();
        scrollPaneInput = new JScrollPane(inputCodeTA);

        outputTA = new JTextArea();
        scrollPaneOutput = new JScrollPane(outputTA);

        errorTA = new JTextArea();
        scrollPaneError = new JScrollPane(errorTA);

        runButton = new JButton();
        loadButton = new JButton();

        scrollPaneInput.setViewportBorder(BorderFactory.createTitledBorder("Input"));
        inputCodeTA.setColumns(20);
        inputCodeTA.setLineWrap(true);
        inputCodeTA.setRows(5);
        inputCodeTA.setFont(inputCodeTA.getFont().deriveFont(20f));


        scrollPaneOutput.setViewportBorder(BorderFactory.createTitledBorder("Output"));
        outputTA.setEditable(false);
        outputTA.setColumns(20);
        outputTA.setLineWrap(true);
        outputTA.setRows(5);


        scrollPaneError.setViewportBorder(BorderFactory.createTitledBorder("Error log:"));
        errorTA.setEditable(false);
        errorTA.setBackground(new Color(153, 153, 153));
        errorTA.setLineWrap(true);
        errorTA.setColumns(20);
        errorTA.setRows(8);
        //errorTA.setText();

        runButton.setText("Run");
        loadButton.setText("Load");

        createRunButtonListener();
        createLoadButtonListener();

        createMenu();
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        settings = new JMenu("Settings");
        menuBar.add(settings);
        this.setJMenuBar(menuBar);

        createSettingsListener();
    }

    /**
     * returns screenSize as a dimension
     * width = 75% of screen size
     * height = 75% of screen size
     * handles multi-monitor configuration
     * @return
     */
    private Dimension getScreenSize() {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = (int) (gd.getDisplayMode().getWidth() * 0.75);
        int height = (int) (gd.getDisplayMode().getHeight() * 0.75);
        return new Dimension(width, height);
    }


    private void createRunButtonListener(){
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (unityProgramHolder == null) {
                    //load the program
                    loadUnityProgram();
                }
                unityProgramHolder.startProgram();
            }
        });
    }

    private void createLoadButtonListener() {
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadUnityProgram();
            }
        });
    }

    private void createSettingsListener() {
        settings.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                new SettingsGui();
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
    }

    private UnityProgram loadUnityProgram(){
        String programToParse = inputCodeTA.getText();
        try {
            eraseTextArea(errorTA);
            eraseTextArea(outputTA);
            unityProgramHolder = new Unity(errorTA, outputTA);
            unityProgramHolder.createProgramFromString(programToParse);
            unityProgramHolder.getErrorLogger().log("Unity program loaded successfully");
        } catch (UnityGrammarException unityGrammarException) {
            unityProgramHolder.getErrorLogger().log(unityGrammarException);
        }
        return unityProgramHolder.getUnityProgram();
    }

    private void eraseTextArea(JTextArea textArea){
        textArea.selectAll();
        textArea.replaceSelection("");
    }

}
