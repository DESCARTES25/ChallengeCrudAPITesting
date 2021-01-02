package com.postgresql.app.service;

import java.util.List;
import java.util.Optional;

import com.postgresql.app.model.City;

public interface ICityService {
	
	  //Creates a new city	
	  City save(City city);
	  
	  //Return all the cities in DB
	  List<City> findAll();
	  
	  //Finding City by Id
	  City findById(long id);
	  
	//Creates a new city	
	  void delete(City city);
}
