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

    /**
     * @return tours's date
     */
    public String getDate() {
        return this.date;
    }

    /**
     * @return tours's origin
     */
    public String getOrigin() {
        return this.origin;
    }

    /**
     * @return tours's destination
     */
    public String getDestination() {
        return this.destination;
    }

    /**
     * @return tours's departure time
     */
    public String getDeparture() {
        return this.departureTime;
    }

    /**
     * @return tours's arrival time
     */
    public String getArrival() {
        return this.arrivalTime;
    }

}
