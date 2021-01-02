delete from cities;

INSERT INTO cities(name) VALUES('Madrid');
INSERT INTO cities(name) VALUES('London');
INSERT INTO cities(name) VALUES('Berlin');
INSERT INTO cities(name) VALUES('Tokyo');
INSERT INTO cities(name) VALUES('Paris');
INSERT INTO cities(name) VALUES('New York');

delete from itineraries;

INSERT INTO itineraries(origin_id ,
    destination_id ,
    departure ,
    arrival 
) VALUES((select id from cities where name = 'Madrid'),(select id from cities where name = 'Berlin'),'00:00:00','02:00:00');


INSERT INTO itineraries(origin_id ,
    destination_id ,
    departure ,
    arrival 
) VALUES((select id from cities where name = 'Madrid'),(select id from cities where name = 'Paris'),'00:00:00','01:00:00');

INSERT INTO itineraries(origin_id ,
    destination_id ,
    departure ,
    arrival 
) VALUES((select id from cities where name = 'Paris'),(select id from cities where name = 'London'),'01:00:00','04:00:00');

INSERT INTO itineraries(origin_id ,
    destination_id ,
    departure ,
    arrival 
) VALUES((select id from cities where name = 'Paris'),(select id from cities where name = 'New York'),'01:00:00','08:00:00');

INSERT INTO itineraries(origin_id ,
    destination_id ,
    departure ,
    arrival 
) VALUES((select id from cities where name = 'Berlin'),(select id from cities where name = 'Tokyo'),'02:00:00','12:00:00');

INSERT INTO itineraries(origin_id ,
    destination_id ,
    departure ,
    arrival 
) VALUES((select id from cities where name = 'London'),(select id from cities where name = 'Tokyo'),'04:00:00','14:00:00');
			

INSERT INTO itineraries(origin_id ,
    destination_id ,
    departure ,
    arrival 
) VALUES((select id from cities where name = 'New York'),(select id from cities where name = 'Tokyo'),'08:00:00','16:00:00');

			


COMMIT;


