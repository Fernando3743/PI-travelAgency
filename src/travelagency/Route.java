package travelagency;

import java.util.ArrayList;

/**
 *
 * @author luisfernandolarasaldarriaga
 */
public class Route {
    private String origin;
    private String destination;
    private ArrayList<Tour> tours;
    
    public Route(String origin,String destination){
        this.origin = origin;
        this.destination = destination;
    }
    
    
}
