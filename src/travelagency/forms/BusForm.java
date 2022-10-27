package travelagency.forms;

import com.sun.security.auth.module.JndiLoginModule;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
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
    private Stream<Driver> avaliableEmployeesList;
    
    private JComboBox driverSelect;
    
    
    public BusForm(TravelAgency agency,Stream<Driver> employeesList){
        this.avaliableEmployeesList = employeesList;
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
        
        licenseField.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "Enter BUS license plate."));
        passengersField.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "Enter passengers MAX capacity"));
        gallonsField.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "Enter gasoline gallons MAX capacity"));
        
       inputPanel.add(licenseField);
       
       // Init numeric panel
       
       numericPanel = new JPanel(new GridLayout(1, 2));
       
       numericPanel.add(passengersField);
       numericPanel.add(gallonsField);
       
       
       inputPanel.add(numericPanel);
       ;
       
       // Init combobox
       
       ArrayList<Driver> testList = new ArrayList<Driver>(List.of(new Driver(4444, "test2", "test position")));

       driverSelect = new JComboBox(testList.stream().map(Employee::getInfo).toArray());
       
       inputPanel.add(driverSelect);
       
       // INIT actions buttons
        
        buttonsPanel =  new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");
        
        cancelButton.addActionListener(e -> {
                this.dispose();
                myAgency.setVisible(true);
            });
        
        buttonsPanel.add(saveButton);
        buttonsPanel.add(cancelButton);
               
       this.add(inputPanel, BorderLayout.CENTER); 
       this.add(buttonsPanel, BorderLayout.SOUTH);
    }
    
    
}
