package com.postgresql.app.service;

import java.util.List;

import com.postgresql.app.model.City;
import com.postgresql.app.model.Itinerary;

public interface IItineraryService {

	
	  //Returns all itineraries in DB
	  List<Itinerary> findAll(); 
		
	
	
}
