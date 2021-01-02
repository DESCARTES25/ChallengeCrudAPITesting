package com.postgresql.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postgresql.app.exceptions.ResourceNotFoundException;
import com.postgresql.app.model.City;
import com.postgresql.app.model.Itinerary;
import com.postgresql.app.repository.CityRepository;
import com.postgresql.app.service.ICityService;
import com.postgresql.app.service.IItineraryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class CityAPIController {

	@Autowired
	private ICityService cityService;

	@Autowired
	private IItineraryService itineraryService;

	@GetMapping("/cities")
	public List<City> findCities(Model model) {

		return (List<City>) cityService.findAll();
	}

	@GetMapping("/cities/{id}")
	public ResponseEntity<City> getCityById(@PathVariable(value = "id") Long CityId) throws ResourceNotFoundException {
		City city = cityService.findById(CityId);

		if (city == null) {
			throw new ResourceNotFoundException("City not found for this id: " + CityId);
		}

		return ResponseEntity.ok().body(city);
	}

	@PostMapping("/cities")
	public City createCity(@Valid @RequestBody City city) {
		return cityService.save(city);
	}

	@PutMapping("/cities/{id}")
	public ResponseEntity<City> updateCity(@PathVariable(value = "id") Long cityId,

			@Valid @RequestBody City cityDetails) throws ResourceNotFoundException {
		
		City city = cityService.findById(cityId);
		
		if (city == null) {
			throw new ResourceNotFoundException("City not found for this id: " + cityId);
		}		
		
		city.setId(cityDetails.getId());
		city.setName(cityDetails.getName());
		final City updatedCity = cityService.save(city);
		return ResponseEntity.ok(updatedCity);
	}

	@DeleteMapping("/cities/{id}")
	public Map<String, Boolean> deleteCity(@PathVariable(value = "id") Long cityId) throws ResourceNotFoundException {
		City city = cityService.findById(cityId);
				
		if (city == null) {
			throw new ResourceNotFoundException("City not found for this id: " + cityId);
		}		
	
		cityService.delete(city);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@GetMapping("/itineraries")
	public List<Itinerary> findItineraries(Model model) {

		return (List<Itinerary>) itineraryService.findAll();
	}

}