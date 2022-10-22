/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travelagency;

import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author luisfernandolarasaldarriaga
 */
public class Tour {
    Date date;
    String origin;
    String destination;
    LocalTime departureTime;
    LocalTime arrivalTime;
    
    public Tour(Date date,String origin,String destination,LocalTime departureTime,LocalTime arrivalTime){
        this.date = date;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        
    }
    
    
}
