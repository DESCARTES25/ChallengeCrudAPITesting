package com.postgresql.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import com.postgresql.app.model.City;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CityControllerAllCitiesTest {

	private String getRootUrl() {
		return "http://localhost:8082";
	}

/*	@Test
	public void testGetAllCities() {
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getRootUrl() + "/api/cities", HttpMethod.GET,
				entity, String.class);
		assertNotNull(response.getBody());
	}

	@Test
	public void testCreateCity() {
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		City city = new City("Split");
		
		ResponseEntity<City> postResponse = testRestTemplate.postForEntity(getRootUrl() + "/api/cities", city,
				City.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}
	
	@Test
	public void testGetCityById() {
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		City city = testRestTemplate.getForObject(getRootUrl() + "/api/cities/7", City.class);
		System.out.println(city.getName());
		assertNotNull(city);
	}



	@Test
	public void testUpdateCity() {
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		int id = 7;
		City city = testRestTemplate.getForObject(getRootUrl() + "/api/cities/" + id, City.class);
		city.setName("Splity");
		testRestTemplate.put(getRootUrl() + "/api/cities/" + id, city);
		City updatedCity = testRestTemplate.getForObject(getRootUrl() + "/api/cities/" + id, City.class);
		assertNotNull(updatedCity);
	}

	@Test
	public void testDeleteCity() {
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		int id = 7;
		City city = testRestTemplate.getForObject(getRootUrl() + "/api/cities/" + id, City.class);
		assertNotNull(city);
		testRestTemplate.delete(getRootUrl() + "/api/cities/" + id);
		try {
			city = testRestTemplate.getForObject(getRootUrl() + "/api/cities/" + id, City.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

	@Test
	public void testGetAllItineraries() {
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(getRootUrl() + "/api/itineraries", HttpMethod.GET,
				entity, String.class);
		assertNotNull(response.getBody());
	}
*/
}
