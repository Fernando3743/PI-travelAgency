package travelagency;

import java.time.LocalTime;
import java.util.Date;

/**
 * @author luisfernandolarasaldarriaga
 */
public class Tour {
    private Date date;
    private String origin;
    private String destination;
    private LocalTime departureTime;
    private LocalTime arrivalTime;

    /**
     * Constructor.
     * @param date
     * @param origin
     * @param destination
     * @param departureTime
     * @param arrivalTime
     */
    public Tour(Date date,String origin,String destination,LocalTime departureTime,LocalTime arrivalTime){
        this.date = date;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        
    }
    
    
}
