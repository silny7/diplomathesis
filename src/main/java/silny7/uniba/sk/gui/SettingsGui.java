package silny7.uniba.sk.gui;

import javafx.scene.control.ComboBox;
import silny7.uniba.sk.unity.program.configuration.Configuration;
import silny7.uniba.sk.unity.program.configuration.ConfigurationFields;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SettingsGui extends JFrame {

    private List<JLabel> labels;
    private List<JComboBox> comboBoxes;
    private String[] comboBoxOptionsBoolean = {"true", "false"};


    private JButton saveButton;
    private JButton loadButton;

    /**
     * calls methods to setup GUI
     */
    public SettingsGui(){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            JOptionPane.showMessageDialog(this, "Something went wrong while Settings GUI initialization!");
        }

        setupComponents();
        setupLayout();
        setVisible(true);
    }

    private void setupLayout() {
        getContentPane().setLayout(new SpringLayout());
        for (int i = 0; i < labels.size(); i++){
            add(labels.get(i));
            add(comboBoxes.get(i));
        }
        add(saveButton);
        add(loadButton);

        int rows = labels.size() + 1;
        int cols = 2;
        SpringUtilities.makeCompactGrid(getContentPane(), rows, cols, 6, 6, 6, 6);


        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("UnityToJava");

        setResizable(false);
        setSize(300, 250);

    }

    private void setupComponents() {
        labels = new ArrayList<>();
        comboBoxes = new ArrayList<>();

        saveButton = new JButton("Save configuration");
        loadButton = new JButton("Load configuration");
        for (String configurationField : ConfigurationFields.CONFIGURATION_FIELDS){
            labels.add(new JLabel(configurationField, JLabel.TRAILING));
            JComboBox comboBox = new JComboBox(comboBoxOptionsBoolean);
            comboBox.setSelectedIndex(Configuration.getProperty(configurationField).equalsIgnoreCase("true") ? 0 : 1);
            comboBoxes.add(comboBox);
        }

        createButtonListeners();
    }

    private void createButtonListeners() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < labels.size(); i++){
                    String fieldName = ConfigurationFields.CONFIGURATION_FIELDS.get(i);
                    String propertyValue = comboBoxes.get(i).getSelectedIndex() == 0 ? "true" : "false";
                    Configuration.setProperty(fieldName, propertyValue);
                }
                try {
                    Configuration.saveProperties();
                } catch (IOException err) {
                    JOptionPane.showMessageDialog(saveButton, "Something went wrong while saving configuration!");
                }
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < labels.size(); i++){
                    String fieldName = ConfigurationFields.CONFIGURATION_FIELDS.get(i);
                    comboBoxes.get(i).setSelectedIndex(Configuration.getProperty(fieldName).equalsIgnoreCase("true") ? 0 : 1);
                }
                revalidate();
            }
        });
    }
}
