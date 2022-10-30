package travelagency;

import java.util.ArrayList;

/**
 * @author luisfernandolarasaldarriaga
 */
public class Route {
    private String origin;
    private String destination;
    private ArrayList<Tour> tours;

    /**
     *
     * @param origin route's origin city name
     * @param destination route's destination city name
     */
    public Route(String origin,String destination){
        this.origin = origin;
        this.destination = destination;
    }
    
    
}
