package com.challenge.dijsktra.app.exceptions;

import com.challenge.dijsktra.app.model.Itinerary;

public class ItinerariesWithNegativeTimeException extends RuntimeException {
	//Can not exists itineraries with negative distance to work out shortest itineraries
    public ItinerariesWithNegativeTimeException(Itinerary itinerary) {

        super(String.format("Itinerary Id %d has the an arrival time earlier thab departure time", itinerary.getId()));
    }
    
  
}
