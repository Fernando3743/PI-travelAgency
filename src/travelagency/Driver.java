
package travelagency;

/**
 *
 * @author luisfernandolarasaldarriaga
 */
public class Driver extends Employee{
    
    private boolean busAssigned;
    
    public Driver(int id,String name,String position) {
        super(id, name, position);
        
        busAssigned = false;
    }
    
    public boolean hasBusAssigned () {
        return busAssigned;
    }
    
    public void setBusAssigned(boolean assigned){
        busAssigned = assigned;
    }
    
}
