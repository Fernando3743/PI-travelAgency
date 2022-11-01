
package travelagency;

/**
 * @author luisfernandolarasaldarriaga
 */
public class Bus {
    private String licensePlate;
    private int passengerCapacity;
    private int gallonsAmount;
    private Driver driver;
    private Route route;

    /**
     * Constructor.
     * @param licensePlate bus's license plate
     * @param passengerCapacity bus's passengers capacity
     * @param gallonsAmount bus's gallons amount
     * @param driver bus's driver
     */
    public Bus (String licensePlate, int passengerCapacity, int gallonsAmount, Driver driver, Route route){
        this.licensePlate = licensePlate;
        this.passengerCapacity = passengerCapacity;
        this.gallonsAmount = gallonsAmount;
        this.driver = driver;
        this.route = route;
        
    }

    /**
     * @return bus's license plate
     */
    public String getLicensePlate(){
        return  licensePlate;
    }

    /**
     * @return bus's license + passengers capacity + gallons amount
     */
    public String getInfo() {

        return String.format("  license: %s \n  passengers capacity: %s \n  gallons amount: %s  \n", licensePlate, passengerCapacity, gallonsAmount);

    }
    
    
}
