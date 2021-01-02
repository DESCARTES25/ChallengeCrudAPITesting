DROP TABLE IF EXISTS cities;
CREATE TABLE cities(id serial PRIMARY KEY, name VARCHAR(255));

DROP TABLE IF EXISTS itineraries;
CREATE TABLE itineraries(
    id serial PRIMARY KEY,
    origin_id INT NOT NULL,
    destination_id INT NOT NULL,
    departure TIME NOT NULL,
    arrival TIME NOT NULL,
CONSTRAINT fk_origin
      FOREIGN KEY(origin_id) 
	  REFERENCES cities(id),
CONSTRAINT fk_destination
      FOREIGN KEY(destination_id) 
	  REFERENCES cities(id)

);  
