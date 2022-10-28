package travelagency.forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.border.Border;
import travelagency.*;
/**
 *
 * @author luisfernandolarasaldarriaga
 */
public class BusForm extends JFrame{
    private JPanel inputPanel;
    private JPanel buttonsPanel;
    private JPanel numericPanel;
    
    private JTextField licenseField;
    private JSpinner passengersField;
    private JSpinner gallonsField;
    
    private JButton saveButton;
    private JButton cancelButton;
    
    private TravelAgency myAgency;
    private List<Driver> availableDriversList;
    
    private JComboBox driverSelect;
    
    
    public BusForm(TravelAgency agency,List<Driver> employeesList){
        this.availableDriversList = employeesList;
        this.myAgency = agency;
        
        initGUI();
        setTitle("Bus Form");
        setSize(500,250);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
    }
    
    public void initGUI() {
        
        // INIT inputs fields
        inputPanel = new JPanel(new GridLayout(3, 1));
        
        licenseField = new JTextField();
        passengersField = new JSpinner();
        gallonsField = new JSpinner();
        
        Border grayRoundedBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true);
        
        licenseField.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "Enter BUS license plate. like AAA-123"));
        passengersField.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "Enter passengers MAX capacity"));
        gallonsField.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "Enter gasoline gallons MAX capacity"));
        
       inputPanel.add(licenseField);
       
       // Init numeric panel
       
       numericPanel = new JPanel(new GridLayout(1, 2));
       
       numericPanel.add(passengersField);
       numericPanel.add(gallonsField);
       
       
       inputPanel.add(numericPanel);
       
       // Init combobox

       driverSelect = new JComboBox(availableDriversList.stream().map(Employee::getInfo).toArray());
       
       inputPanel.add(driverSelect);
       
       // INIT actions buttons
        
        buttonsPanel =  new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        
        cancelButton.addActionListener(e -> {
                this.dispose();
                myAgency.setVisible(true);
            });

        EventManager eventManager = new EventManager(this);

        saveButton.addActionListener(eventManager);
        
        buttonsPanel.add(saveButton);
        buttonsPanel.add(cancelButton);
               
       this.add(inputPanel, BorderLayout.CENTER); 
       this.add(buttonsPanel, BorderLayout.SOUTH);
    }


    class EventManager implements ActionListener {
        BusForm activeForm;
        String licenseRegex;

        public EventManager(BusForm form){
            licenseRegex = "[A-Z]{3}-[0-9]{3}";
            activeForm = form;
        }

        private int tryCastInt(String num){
            int result = -1;
            try {
                result = Integer.parseInt(num);
            } catch (Exception ignored) {}

            return result;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == saveButton) {
                String license = licenseField.getText();
                String passengers = passengersField.getValue().toString();
                String gallons = gallonsField.getValue().toString();

                if(!Pattern.matches(licenseRegex, license)){
                    JOptionPane.showMessageDialog(myAgency, "Invalid license plate format. \nIt should be in format like AAA-123");
                    licenseField.setText("");
                    return;
                }

                if(!myAgency.checkUniqueBus(license)){
                    JOptionPane.showMessageDialog(myAgency, "A bus with license plate " + license + " already exists.");
                    licenseField.setText("");
                    return;
                }

                int passengersInt = this.tryCastInt(passengers);

                if(passengersInt <= 0){
                    JOptionPane.showMessageDialog(myAgency, "Invalid passengers capacity format. \nIt should be a numeric value higher than 0");
                    passengersField.setValue(0);
                    return;
                }

                int gallonsInt = this.tryCastInt(gallons);

                if(gallonsInt <= 0){
                    JOptionPane.showMessageDialog(myAgency, "Invalid gallons amount format. \nIt should be a numeric value higher than 0");
                    gallonsField.setValue(0);
                    return;
                }

                int driverSelectedIndex = driverSelect.getSelectedIndex();

                Driver selectedDriver = availableDriversList.get(driverSelectedIndex);

                selectedDriver.setBusAssigned(true);

                Bus bus = new Bus(license,passengersInt, gallonsInt, selectedDriver);
                myAgency.addBus(bus);

                activeForm.dispose();
                myAgency.setVisible(true);

            }
        }
    }
    
    
}
