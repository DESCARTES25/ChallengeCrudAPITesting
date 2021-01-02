# Spring Boot Microservice to Get Shortest Time and Connections between Cities

This project is based on two microservices developed using Spring Boot, Postgres and Docker. One Microservice provides data about Cities and Itineraries from a Postgres Database through a Rest Api. The other microservice consume the Rest Api and calculares Shortest time and connections paths between two cities using Dijkstra Algorithm. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

1) [Java 1.8](https://www.java.com) - Java Version to compile and build the Microservices
2) [Maven](https://maven.apache.org/) - Maven to Build the Jars 
3) [Docker](https://www.docker.com/) - Deploy the containers for Postgres and Spring Boot

### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be


1. Download the repository (https://github.com/DESCARTES25/ChallengeCompleteDocker)

2. Unzip the content in your local machine

3. Open a Console or Terminal (In my case Powershell)

	![alt text](https://github.com/DESCARTES25/ChallengeCompleteDocker/blob/master/powershell.png)

4. Build the Jar File for the Api Rest Microservice (Enter in **ChallengeRestApi-master** directory and launch **./mvnw clean install** )

	![alt text](https://github.com/DESCARTES25/ChallengeCompleteDocker/blob/master/ChallengeRestApi-master.png)

5. Build the Jar File for the Dijkstra Shortest City Path Rest Microservice (Enter in **Challenge-master** directory and launch **./mvnw clean install** ) 

	![alt text](https://github.com/DESCARTES25/ChallengeCompleteDocker/blob/master/Challenge-master.png)

6. Return to the Main directory **ChallengeCompleteDocker-master** and execute **docker-compose build** 

7. Return to the Main directory **ChallengeCompleteDocker-master** and execute **docker-compose up** 

## Testing the Services

Once the containers are running, the Postgres Database is filled with cities and itineraries, so we can test the service using these commands:

First, we can test the **Rest Api + Postgres** which is published in **localhost:8082**. (Using Postman)

![alt text](https://github.com/DESCARTES25/ChallengeCompleteDocker/blob/master/postman_get_cities.png)


	'''
	[
	    {
		"id": 1,
		"name": "Madrid"
	    },
	    {
		"id": 2,
		"name": "London"
	    },
	    {
		"id": 3,
		"name": "Berlin"
	    },
	    {
		"id": 4,
		"name": "Tokyo"
	    },
	    {
		"id": 5,
		"name": "Paris"
	    },
	    {
		"id": 6,
		"name": "New York"
	    }
	]

	'''

![alt text](https://github.com/DESCARTES25/ChallengeCompleteDocker/blob/master/postman_get_itineraries.png) 

	'''
	[
	    {
		"id": 1,
		"origin": {
		    "id": 1,
		    "name": "Madrid"
		},
		"destination": {
		    "id": 3,
		    "name": "Berlin"
		},
		"departure": "00:00:00",
		"arrival": "02:00:00"
	    },
	    {
		"id": 2,
		"origin": {
		    "id": 1,
		    "name": "Madrid"
		},
		"destination": {
		    "id": 5,
		    "name": "Paris"
		},
		"departure": "00:00:00",
		"arrival": "01:00:00"
	    },
	    {
		"id": 3,
		"origin": {
		    "id": 5,
		    "name": "Paris"
		},
		"destination": {
		    "id": 2,
		    "name": "London"
		},
		"departure": "01:00:00",
		"arrival": "04:00:00"
	    },
	    {
		"id": 4,
		"origin": {
		    "id": 5,
		    "name": "Paris"
		},
		"destination": {
		    "id": 6,
		    "name": "New York"
		},
		"departure": "01:00:00",
		"arrival": "08:00:00"
	    },
	    {
		"id": 5,
		"origin": {
		    "id": 3,
		    "name": "Berlin"
		},
		"destination": {
		    "id": 4,
		    "name": "Tokyo"
		},
		"departure": "02:00:00",
		"arrival": "12:00:00"
	    },
	    {
		"id": 6,
		"origin": {
		    "id": 2,
		    "name": "London"
		},
		"destination": {
		    "id": 4,
		    "name": "Tokyo"
		},
		"departure": "04:00:00",
		"arrival": "14:00:00"
	    },
	    {
		"id": 7,
		"origin": {
		    "id": 6,
		    "name": "New York"
		},
		"destination": {
		    "id": 4,
		    "name": "Tokyo"
		},
		"departure": "08:00:00",
		"arrival": "16:00:00"
	    }
	]

	'''

Later, we can test the **Shortest Path Rest Service** which is published in **localhost:8080**. 

*Shortest Time between Madrid and Paris:*

![alt text](https://github.com/DESCARTES25/ChallengeCompleteDocker/blob/master/postman_get_shortest_madrid_paris.png) 
	
	'''
	[
	    {
		"id": 2,
		"origin": {
		    "id": 1,
		    "name": "Madrid"
		},
		"destination": {
		    "id": 5,
		    "name": "Paris"
		},
		"departure": "00:00:00",
		"arrival": "01:00:00"
	    }
	]
	'''

*Shortest Time between Madrid and New York:*

![alt text](https://github.com/DESCARTES25/ChallengeCompleteDocker/blob/master/postman_get_shortest_madrid_newyork.png) 

	'''
	
	[
	    {
		"id": 2,
		"origin": {
		    "id": 1,
		    "name": "Madrid"
		},
		"destination": {
		    "id": 5,
		    "name": "Paris"
		},
		"departure": "00:00:00",
		"arrival": "01:00:00"
	    },
	    {
		"id": 4,
		"origin": {
		    "id": 5,
		    "name": "Paris"
		},
		"destination": {
		    "id": 6,
		    "name": "New York"
		},
		"departure": "01:00:00",
		"arrival": "08:00:00"
	    }
	]
	
	'''
*Shortest Time between Madrid and Tokyo:*

![alt text](https://github.com/DESCARTES25/ChallengeCompleteDocker/blob/master/postman_get_shortest_madrid_tokyo.png) 


	'''
	[
	    {
		"id": 1,
		"origin": {
		    "id": 1,
		    "name": "Madrid"
		},
		"destination": {
		    "id": 3,
		    "name": "Berlin"
		},
		"departure": "00:00:00",
		"arrival": "02:00:00"
	    },
	    {
		"id": 5,
		"origin": {
		    "id": 3,
		    "name": "Berlin"
		},
		"destination": {
		    "id": 4,
		    "name": "Tokyo"
		},
		"departure": "02:00:00",
		"arrival": "12:00:00"
	    }
	]
	'''
*Shortest Connection between Madrid and London:*

![alt text](https://github.com/DESCARTES25/ChallengeCompleteDocker/blob/master/postman_get_connection_madrid_london.png) 


	'''
	[
	    {
		"id": 2,
		"origin": {
		    "id": 1,
		    "name": "Madrid"
		},
		"destination": {
		    "id": 5,
		    "name": "Paris"
		},
		"departure": "00:00:00",
		"arrival": "01:00:00"
	    },
	    {
		"id": 3,
		"origin": {
		    "id": 5,
		    "name": "Paris"
		},
		"destination": {
		    "id": 2,
		    "name": "London"
		},
		"departure": "01:00:00",
		"arrival": "04:00:00"
	    }
	]
	'''
*Shortest Connection between Madrid and Tokyo:*

![alt text](https://github.com/DESCARTES25/ChallengeCompleteDocker/blob/master/postman_get_connection_madrid_tokyo.png) 

	'''
	[
	    {
		"id": 1,
		"origin": {
		    "id": 1,
		    "name": "Madrid"
		},
		"destination": {
		    "id": 3,
		    "name": "Berlin"
		},
		"departure": "00:00:00",
		"arrival": "02:00:00"
	    },
	    {
		"id": 5,
		"origin": {
		    "id": 3,
		    "name": "Berlin"
		},
		"destination": {
		    "id": 4,
		    "name": "Tokyo"
		},
		"departure": "02:00:00",
		"arrival": "12:00:00"
	    }
	]
	'''
## Swagger Documentation

Once the cotainers are working, check these links in order to know the complete service specification:

1. Api Rest Service + Postgres
[Swagger Documentation](http://localhost:8082/swagger-ui.html) 

2. Rest Service to calculate the shortest time and connections between cities
[Swagger Documentation](http://localhost:8080/swagger-ui.html) 


## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Spring Boot](https://spring.io/) - The framework used to code the services
* [Maven](https://maven.apache.org/) - Dependency Management and Jar Building
* [Docker](https://www.docker.com/) - Used to deploy the services

## Authors

* **Daniel Escartín Daniel** - *Initial work* 



