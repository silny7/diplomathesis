package silny7.uniba.sk.gui;

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
    private List<JComponent> components;
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
            add(components.get(i));
        }
        add(saveButton);
        add(loadButton);

        int rows = labels.size() + 1;
        int cols = 2;
        SpringUtilities.makeCompactGrid(getContentPane(), rows, cols, 6, 6, 6, 6);


        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("UnityToJava");

        setResizable(false);
        setSize(300, 350);

    }


    private void setupComponents() {
        labels = new ArrayList<>();
        components = new ArrayList<>();

        saveButton = new JButton("Save configuration");
        loadButton = new JButton("Load configuration");
        for (String configurationField : ConfigurationFields.ALL_FIELDS){
            labels.add(new JLabel(configurationField, JLabel.TRAILING));
            if (ConfigurationFields.BOOLEAN_FIELDS.contains(configurationField)) {
                createComboBox(configurationField);
            } else {
                createSpinner(configurationField);
            }
        }

        createButtonListeners();
    }

    private void createSpinner(String configurationField) {
        int value = Integer.parseInt(Configuration.getProperty(configurationField));
        SpinnerModel model = new SpinnerNumberModel(value, value - 1000, value + 1000, 1);
        components.add(new JSpinner(model));
    }

    private void createComboBox(String configurationField) {
        JComboBox comboBox = new JComboBox(comboBoxOptionsBoolean);
        comboBox.setSelectedIndex(Configuration.getProperty(configurationField).equalsIgnoreCase("true") ? 0 : 1);
        components.add(comboBox);
    }

    private void createButtonListeners() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < labels.size(); i++){
                    String fieldName = ConfigurationFields.ALL_FIELDS.get(i);
                    String propertyValue;
                    if (ConfigurationFields.BOOLEAN_FIELDS.contains(fieldName)) {
                        propertyValue = ((JComboBox) components.get(i)).getSelectedIndex() == 0 ? "true" : "false";
                    } else {
                        propertyValue = String.valueOf(((JSpinner) components.get(i)).getValue());
                    }
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
                    String fieldName = ConfigurationFields.ALL_FIELDS.get(i);
                    if (ConfigurationFields.BOOLEAN_FIELDS.contains(fieldName)) {
                        ((JComboBox) components.get(i)).setSelectedIndex(Configuration.getProperty(fieldName).equalsIgnoreCase("true") ? 0 : 1);
                    } else {
                        ((JSpinner) components.get(i)).setValue(Integer.parseInt(Configuration.getProperty(fieldName)));
                    }
                }
                revalidate();
            }
        });
    }
}
