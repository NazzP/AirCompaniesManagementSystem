-- Airplanes Table
CREATE TABLE airplanes (
                           id serial PRIMARY KEY,
                           factory_serial_number bigint NOT NULL,
                           aircompany_id bigint,
                           number_of_flights bigint NOT NULL,
                           flight_distance double precision NOT NULL,
                           fuel_capacity double precision NOT NULL,
                           type varchar(255) NOT NULL,
                           created_at timestamp NOT NULL
);

-- AirCompanies Table
CREATE TABLE aircompanies (
                              id serial PRIMARY KEY,
                              name varchar(255) NOT NULL UNIQUE,
                              company_type varchar(255) NOT NULL,
                              founded_at date NOT NULL
);

-- Flights Table
CREATE TABLE flights (
                         id serial PRIMARY KEY,
                         flight_status varchar(255),
                         airplane_id bigint,
                         aircompany_id bigint,
                         departure_country varchar(255) NOT NULL,
                         destination_country varchar(255) NOT NULL,
                         distance double precision NOT NULL,
                         estimated_flight_time double precision NOT NULL,
                         started_at timestamp,
                         ended_at timestamp,
                         delay_started_at timestamp,
                         created_at timestamp NOT NULL
);

-- Foreign Key Constraints
ALTER TABLE airplanes ADD CONSTRAINT fk_airplanes_aircompany FOREIGN KEY (aircompany_id) REFERENCES aircompanies(id) ON DELETE CASCADE;
ALTER TABLE flights ADD CONSTRAINT fk_flights_airplane FOREIGN KEY (airplane_id) REFERENCES airplanes(id) ON DELETE CASCADE;
ALTER TABLE flights ADD CONSTRAINT fk_flights_aircompany FOREIGN KEY (aircompany_id) REFERENCES aircompanies(id) ON DELETE CASCADE;
