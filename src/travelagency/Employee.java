package travelagency;

/**
 * @author luisfernandolarasaldarriaga
 */
public class Employee {   
    private int identification;
    private String name;
    private String position;

    /**
     * Constructor.
     * @param id employee's identification
     * @param name employee's name
     * @param position employee's position in agency
     */
    public Employee(int id,String name,String position){
       this.identification = id;
       this.name = name;
       this.position = position;
    }
    
    public int getID() {
        return this.identification;
    }

    /**
     * @return employee's name
     */
    public String getName () { return this.name; }

    /**
     * @return employee's full information.
     */
    public String getInfo() {
        return name + " ( " + identification + " ) - " + position; 
    }
}
