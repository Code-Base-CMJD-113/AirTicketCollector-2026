package lk.ijse.cmjd113.AirTicketCollector.util;

import java.util.UUID;

public class IDGenerate {
    public static String airportId(){
        return "APT-"+ UUID.randomUUID();
    }
    public static String flightId(){
        return "FLT-"+ UUID.randomUUID();
    }
}
