package travelagency;

import java.util.ArrayList;

/**
 * @author luisfernandolarasaldarriaga
 * @author camilo murillo gómez 1931058-2711
 */

public class Route {
    private String origin;
    private String destination;
    private ArrayList<Tour> tours;

    /**
     *
     * @param origin      route's origin city name
     * @param destination route's destination city name
     */
    public Route(String origin, String destination, ArrayList<Tour> tour) {
        this.origin = origin;
        this.destination = destination;
        this.tours = tour;
    }

    /**
     * @return routes's origin
     */
    public String getOrigin() {
        return this.origin;
    }

    /**
     * @return routes's destination
     */
    public String getDestination() {
        return this.destination;
    }

    @Override
    public String toString() {
        return this.origin + " - " + this.destination;
    }

    /**
     * @return full trip information (all tours info appended)
     */
    public String getTripInfo() {
        
        String tourStr = "";

        for (Tour tour : this.tours) {
            tourStr += tour.getOrigin() + " - "
                    + tour.getDestination() + " ("
                    + tour.getDate() + ", " +
                    tour.getDeparture() + " - "
                    + tour.getArrival() + ") \n";
        }

        return tourStr + "\n";
    }

    /**
     * @return routes's tours list
     */
    public ArrayList<Tour> getTour() {
        return this.tours;
    }

}
