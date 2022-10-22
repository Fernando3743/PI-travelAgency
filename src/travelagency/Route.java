package travelagency;

import java.util.ArrayList;

/**
 *
 * @author luisfernandolarasaldarriaga
 */
public class Route {
    String origin;
    String destination;
    ArrayList<Tour> tours;
    
    public Route(String origin,String destination){
        this.origin = origin;
        this.destination = destination;
    }
    
    
}
