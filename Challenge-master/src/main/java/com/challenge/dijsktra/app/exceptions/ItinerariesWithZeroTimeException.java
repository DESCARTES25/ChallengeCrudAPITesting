package com.challenge.dijsktra.app.exceptions;

import com.challenge.dijsktra.app.model.Itinerary;

public class ItinerariesWithZeroTimeException extends RuntimeException {
	//Can not exists itineraries with Zero distance to work out shortest itineraries
    public ItinerariesWithZeroTimeException(Itinerary itinerary) {

        super(String.format("Itinerary Id %d has the same departure and arrival time", itinerary.getId()));
    }
    
  
}
