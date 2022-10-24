/*
 * Developers:
 * Luis Fernando Lara Saldarriaga - 202024730 - 3743
 * 
 */
package travelagency;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import travelagency.forms.EmployeeForm;

/**
 * Main project JAVA class, which contains the main method.
 * Manages project execution and event handling.
 */
public class TravelAgency extends JFrame{
    JPanel actionsPanel;
    JPanel addPanel;
    JPanel listPanel;
    JPanel filterPanel;
    
    JButton newEmployeeButton;
    JButton newBusButton;
    JButton newRouteButton;
    
    JButton listEmployeeButton;
    
    JTextArea mainTextArea;
    
    ArrayList<Employee> employeesList;
    
    public TravelAgency(){
        employeesList = new ArrayList<>();
        mainTextArea = new JTextArea();
        mainTextArea.setEditable(false);
        
        initGUI();
        setTitle("Traveling Agency");
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }
    
    public void initGUI(){
        Border grayRoundedBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true);
        
        mainTextArea.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "Output"));
        JScrollPane scrollable = new JScrollPane(mainTextArea);
        this.add(scrollable, BorderLayout.CENTER);
        actionsPanel = new JPanel(new GridLayout(3, 1));
        
        
        
        // Setting up actions panel
        addPanel = new JPanel(new GridLayout(1, 3));
        newEmployeeButton = new JButton("Employee");
        newBusButton = new JButton("Bus");
        newRouteButton = new JButton("Route");
        
        newEmployeeButton.addActionListener(e -> {
            this.setVisible(false);
            new EmployeeForm(this);
        });
        
        addPanel.add(newEmployeeButton);
        addPanel.add(newBusButton);
        addPanel.add(newRouteButton);
        
        addPanel.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "ADD"));
        actionsPanel.add(addPanel);
        
        
        //Setting up listing panel
        
        listPanel = new JPanel(new GridLayout(1, 3));
        listEmployeeButton = new JButton("Employee");
        
        listEmployeeButton.addActionListener(e -> this.listEmployees());
        
        listPanel.add(listEmployeeButton);
        
        listPanel.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "List"));
        
        actionsPanel.add(listPanel);
        
        
        this.add(actionsPanel, BorderLayout.WEST);
    }
    
    public void displayText(String text) {
        String currentText = mainTextArea.getText();
        
        mainTextArea.setText(currentText + "\n" + text);
    }
    
    public void listEmployees() {
        String reducedEmployeesInfo = employeesList
                .stream()
                .map(e -> e.getInfo())
                .reduce("Active employees: \n", (acc, e) -> acc + e + "\n");
        
        this.displayText(reducedEmployeesInfo);
           
    }
    
    public boolean checkUniqueEmployee(int id){
        return employeesList
                .stream()
                .filter(e -> e.getID() == id)
                .findAny()
                .isEmpty();
    }
    
    public void addEmployee(Employee newEmployee){
        employeesList.add(newEmployee);
    }
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        TravelAgency myAgency = new TravelAgency();
        
    }
    
}
