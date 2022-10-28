/*
 * Developers:
 * Luis Fernando Lara Saldarriaga - 202024730 - 3743
 * 
 */
package travelagency;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.Border;
import travelagency.forms.BusForm;
import travelagency.forms.EmployeeForm;

/**
 * Main project JAVA class, which contains the main method.
 * Manages project execution and event handling.
 */
public class TravelAgency extends JFrame{
    private JPanel actionsPanel;
    private JPanel addPanel;
    private JPanel listPanel;
    private JPanel filterPanel;
    
    private JButton newEmployeeButton;
    private JButton newBusButton;
    private JButton newRouteButton;
    
    private JButton listEmployeeButton;
    private JButton listRoutesButton;
    private JButton listBusesButton;
    
    private JTextArea mainTextArea;
    
    private ArrayList<Driver> driversList;
    private ArrayList<Bus> busesList;
    
    public TravelAgency(){
        driversList = new ArrayList<>();
        busesList = new ArrayList<>();
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
    
    private List<Driver> getAvaliableDrivers(){
        return driversList.stream().filter(e -> !e.hasBusAssigned()).toList();
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

        EventManager eventManager = new EventManager(this);
        
        newEmployeeButton.addActionListener(e -> {
            this.setVisible(false);
            new EmployeeForm(this);
        });
        
        newBusButton.addActionListener(eventManager);
        
        addPanel.add(newEmployeeButton);
        addPanel.add(newRouteButton);
        addPanel.add(newBusButton);
        
        addPanel.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "Click an option to ADD"));
        actionsPanel.add(addPanel);
        
        
        //Setting up listing panel
        
        listPanel = new JPanel(new GridLayout(1, 3));
        listEmployeeButton = new JButton("Employee");
        listRoutesButton = new JButton("Routes");
        listBusesButton = new JButton("Buses");
        
        listEmployeeButton.addActionListener(e -> this.listEmployees());
        listBusesButton.addActionListener(e -> this.listBuses());
        
        listPanel.add(listEmployeeButton);
        listPanel.add(listRoutesButton);
        listPanel.add(listBusesButton);
        
        listPanel.setBorder(BorderFactory.createTitledBorder(grayRoundedBorder, "Click an option to LIST"));
        
        actionsPanel.add(listPanel);
        
        
        this.add(actionsPanel, BorderLayout.WEST);
    }
    
    public void displayText(String text) {
        String currentText = mainTextArea.getText();
        
        mainTextArea.setText(currentText + "\n" + text);
    }
    
    public void listEmployees() {
        String reducedEmployeesInfo = driversList
                .stream()
                .map(Employee::getInfo)
                .reduce("Active employees: \n", (acc, e) -> acc + e + "\n");
        
        this.displayText(reducedEmployeesInfo);
           
    }
    
    public boolean checkUniqueEmployee(int id){
        return driversList
                .stream()
                .filter(e -> e.getID() == id)
                .findAny()
                .isEmpty();
    }
    
    public void addEmployee(Driver newDriver){
        driversList.add(newDriver);
    }

    public void listBuses() {
        String reduceBuses = busesList
                .stream()
                .map(Bus::getInfo)
                .reduce("Active buses: \n", (acc, e) -> acc + e + "\n");

        this.displayText(reduceBuses);
    }

    public boolean checkUniqueBus(String licensePlate){
        return busesList
                .stream()
                .filter(e -> e.getLicensePlate().equals(licensePlate))
                .findAny()
                .isEmpty();
    }

    public void addBus (Bus bus) { busesList.add(bus) ;}
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        TravelAgency myAgency = new TravelAgency();
        
    }

    class EventManager implements ActionListener{

        TravelAgency myAgency;

        public  EventManager (TravelAgency agency){
            myAgency = agency;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == newBusButton){
                List<Driver> availableDrivers = getAvaliableDrivers();
                if (availableDrivers.size() > 0){
                    myAgency.setVisible(false);
                    new BusForm(myAgency, getAvaliableDrivers());
                    return;
                }

                JOptionPane.showMessageDialog(myAgency, "There aren't available Drivers, create a new one.");

            }
        }
    }
    
}
