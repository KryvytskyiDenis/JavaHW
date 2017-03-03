DROP TABLE IF EXISTS car;
CREATE TABLE car(
car_id SERIAL NOT NULL PRIMARY KEY,
model VARCHAR,
make VARCHAR,
id_engine INTEGER,
price DOUBLE PRECISION,
date DATE
);

DROP TABLE IF EXISTS mechanic;
CREATE TABLE mechanic(
mechanic_id SERIAL PRIMARY KEY,
name VARCHAR,
surname VARCHAR,
service_station_id INTEGER
);

DROP TABLE IF EXISTS service_stations;
CREATE TABLE service_stations(
service_stations_id SERIAL PRIMARY KEY,
address VARCHAR
);

DROP TABLE IF EXISTS car_service_stations;
CREATE TABLE car_service_stations(
car_service_stations_id SERIAL PRIMARY KEY,
car_id INTEGER,
service_stations_id INTEGER 
)

