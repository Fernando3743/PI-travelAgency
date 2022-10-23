package travelagency;

/**
 *
 * @author luisfernandolarasaldarriaga
 */
public class Employee {
    int identification;
    String name;
    String position;
    
    public Employee(int id,String name,String position){
       this.identification = id;
       this.name = name;
       this.position = position;
    }
    
    public String getInfo() {
        return name + " ( " + identification + " ) - " + position; 
    }
}
