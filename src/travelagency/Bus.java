
package travelagency;

/**
 *
 * @author luisfernandolarasaldarriaga
 */
public class Bus {
    String licensePlate;
    int passengerCapacity;
    int gallonsAmount;
    Driver driver;
    
    public Bus (String licensePlate, int passengerCapacity, int gallonsAmount, Driver driver){
        this.licensePlate = licensePlate;
        this.passengerCapacity = passengerCapacity;
        this.gallonsAmount = gallonsAmount;
        this.driver = driver;
        
    }
    
    
}
