package travelagency;

/**
 *
 * @author luisfernandolarasaldarriaga
 */
public class Employee {   
    private int identification;
    private String name;
    private String position;
    
    public Employee(int id,String name,String position){
       this.identification = id;
       this.name = name;
       this.position = position;
    }
    
    public int getID() {
        return this.identification;
    }
    
    public String getInfo() {
        return name + " ( " + identification + " ) - " + position; 
    }
}
