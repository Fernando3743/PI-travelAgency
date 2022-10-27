
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
    
    
}
