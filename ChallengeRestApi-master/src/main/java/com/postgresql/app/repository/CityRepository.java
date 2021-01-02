package com.postgresql.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.postgresql.app.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

	
  //Counting Cities in the DB
  long count();		
  
  //Finding City by Name
  City findByName(String name);

  //Finding City by Id
  City findById(long id);
  
  //Returns a list with all the cities in
  List<City> findAll();
  
  //Checks if exists a city with a name
  boolean existsByName(String name);
}