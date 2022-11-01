/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travelagency.forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.Border;
import travelagency.*;

/**
 * @author luisfernandolarasaldarriaga
 *         JFrame employee form, manages the entire employee form in an
 *         independent window, contains a pointer to the main frame "Travel
 *         Agency",
 *         so all data typed and validated here is saved in the main frame.
 */
public class EmployeeForm extends JFrame {
    JTextField identificationField;
    JTextField nameField;
    JComboBox positionField;
    JButton saveButton;
    JButton cancelButton;
    JPanel fieldsPanel;
    JPanel buttonsPanel;
    travelagency.TravelAgency myAgency;

    /**
     * Construtor.
     * 
     * @param agency pointer to the main frame.
     */
    public EmployeeForm(travelagency.TravelAgency agency) {
        this.myAgency = agency;

        initGUI();
        setTitle("Employee Form");
        setSize(500, 250);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Initializes GUI, (all Java Swing components like JButtons, JTextFields, etc).
     */
    public void initGUI() {

        // Init fields panel
        fieldsPanel = new JPanel(new GridLayout(3, 1));

        identificationField = new JTextField();
        nameField = new JTextField();
        positionField = new JComboBox(EmployeePositions.values());

        // Setting up borders

        Border grayRoundedBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true);

        identificationField.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder,
                "Employee's identification number (only numeric digits allowed)"));
        nameField.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "Employee's full name"));
        positionField.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "Employee's company position/rol"));

        fieldsPanel.add(identificationField);
        fieldsPanel.add(nameField);
        fieldsPanel.add(positionField);

        this.add(fieldsPanel, BorderLayout.CENTER);

        // Init buttons panel

        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");

        // Event handling

        EventManager eventManager = new EventManager(this);

        saveButton.addActionListener(eventManager);

        cancelButton.addActionListener(e -> {
            this.dispose();
            myAgency.setVisible(true);
        });

        buttonsPanel.add(saveButton);
        buttonsPanel.add(cancelButton);

        this.add(buttonsPanel, BorderLayout.SOUTH);
    }

    /**
     * Manages, listen and handles the frame application events.
     */
    class EventManager implements ActionListener {
        EmployeeForm currentForm;
        String employeeIdRegex;
        String alphaRegex;

        /**
         * Constructor.
         * 
         * @param form pointer to the active form.
         */
        public EventManager(EmployeeForm form) {
            currentForm = form;
            employeeIdRegex = "[0-9]+";
            alphaRegex = "[a-z A-Z]+";
        }

        /**
         * Handles action events.
         * 
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == saveButton) {
                String id = identificationField.getText();
                String name = nameField.getText();
                String position = positionField.getSelectedItem().toString();

                if (!Pattern.matches(employeeIdRegex, id)) {
                    JOptionPane.showMessageDialog(myAgency,
                            "Invalid employee identification. \nIt should contains only numbers and not be empty.");
                    identificationField.setText("");
                    return;
                }

                if (!Pattern.matches(alphaRegex, name)) {
                    JOptionPane.showMessageDialog(null,
                            "Invalid employee name. \nIt should contains only alphabetic chars and not be empty.");
                    nameField.setText("");
                    return;
                }

                int parsedID = Integer.parseInt(id);

                if (!myAgency.checkUniqueEmployee(parsedID)) {
                    JOptionPane.showMessageDialog(null, "An employee with ID " + id + " already exist.");
                    identificationField.setText("");
                    return;
                }

                Driver newEmployee = new Driver(parsedID, name, position);

                myAgency.addEmployee(newEmployee);

                myAgency.displayText("Employee " + newEmployee.getInfo() + " added successfully! \n");

                myAgency.setVisible(true);
                currentForm.dispose();

            }

        }
    }

}
