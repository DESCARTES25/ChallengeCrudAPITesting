package com.postgresql.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.postgresql.app.exceptions.NoItinerariesFoundException;
import com.postgresql.app.model.City;
import com.postgresql.app.model.Itinerary;
import com.postgresql.app.repository.ItineraryRepository;
@Service
@Qualifier("com.postgresql.app.service.ItineraryService")
public class ItineraryService implements IItineraryService {

	@Autowired
	private ItineraryRepository itineraryRepository;


	@Override
	public List<Itinerary> findAll() {

		List<Itinerary> itineraries = (List<Itinerary>) itineraryRepository.findAll();

		if (itineraries.isEmpty()) {

			throw new NoItinerariesFoundException();
		}

		return itineraries;

	}

}
