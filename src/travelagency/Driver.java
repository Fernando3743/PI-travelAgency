
package travelagency;

/**
 * @author luisfernandolarasaldarriaga
 */
public class Driver extends Employee{
    
    private boolean busAssigned;

    /**
     * Constructor.
     * @param id employee's identification
     * @param name employee's name
     * @param position employee's position in agency
     */
    public Driver(int id,String name,String position) {
        super(id, name, position);
        
        busAssigned = false;
    }

    /**
     * @return true if the driver has a bus assigned.
     */
    public boolean hasBusAssigned () {
        return busAssigned;
    }

    /**
     * Set busAssigned property
     * @param assigned true if the driver has a bus assigned, otherwise false.
     */
    public void setBusAssigned(boolean assigned){
        busAssigned = assigned;
    }
    
}
