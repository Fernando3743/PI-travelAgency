
package travelagency;

/**
 *
 * @author luisfernandolarasaldarriaga
 */
public class Bus {
    private String licensePlate;
    private int passengerCapacity;
    private int gallonsAmount;
    private Driver driver;
    private Route route;
    
    public Bus (String licensePlate, int passengerCapacity, int gallonsAmount, Driver driver){
        this.licensePlate = licensePlate;
        this.passengerCapacity = passengerCapacity;
        this.gallonsAmount = gallonsAmount;
        this.driver = driver;
        
    }

    public String getLicensePlate(){
        return  licensePlate;
    }

    public String getInfo() {

        return String.format("  license: %s \n  passengers capacity: %s \n  gallons amount: %s  \n", licensePlate, passengerCapacity, gallonsAmount);

    }
    
    
}
