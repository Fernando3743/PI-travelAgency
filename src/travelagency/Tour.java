package travelagency;

import java.time.LocalTime;
import java.util.Date;

/**
 * @author luisfernandolarasaldarriaga
 */
public class Tour {
    private String date;
    private String origin;
    private String destination;
    private String departureTime;
    private String arrivalTime;

    /**
     * Constructor.
     *
     * @param date
     * @param origin
     * @param destination
     * @param departureTime
     * @param arrivalTime
     */

    public Tour(String date, String origin, String destination, String departureTime, String arrivalTime) {
        this.date = date;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getDate() {
        return this.date;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getDeparture() {
        return this.departureTime;
    }

    public String getArrival() {
        return this.arrivalTime;
    }

}
