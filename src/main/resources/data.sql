-- Inserting AirCompanies
INSERT INTO aircompanies (name, company_type, founded_at) VALUES ('AirCompany1', 'Type1', '2022-01-01');
INSERT INTO aircompanies (name, company_type, founded_at) VALUES ('AirCompany2', 'Type2', '2022-01-02');

-- Inserting Airplanes
INSERT INTO airplanes (factory_serial_number, aircompany_id, number_of_flights, flight_distance, fuel_capacity, type, created_at) VALUES (123456789, 1, 100, 5000.0, 1000.0, 'Type1', '2022-01-01 10:00:00');
INSERT INTO airplanes (factory_serial_number, aircompany_id, number_of_flights, flight_distance, fuel_capacity, type, created_at) VALUES (987654321, 2, 150, 7500.0, 1500.0, 'Type2', '2022-01-02 11:00:00');

-- Inserting Flights
INSERT INTO flights (flight_status, airplane_id, aircompany_id, departure_country, destination_country, distance, estimated_flight_time, started_at, ended_at, delay_started_at, created_at) VALUES ('ACTIVE', 1, 1, 'Country1', 'Country2', 2500.0, 2.5, '2025-01-01 12:00:00', '2025-01-01 14:30:00', '2025-01-01 12:15:00', '2025-01-01 11:30:00');
INSERT INTO flights (flight_status, airplane_id, aircompany_id, departure_country, destination_country, distance, estimated_flight_time, started_at, ended_at, delay_started_at, created_at) VALUES ('DELAYED', 2, 2, 'Country2', 'Country3', 5000.0, 5.0, '2022-01-02 13:00:00', '2022-01-02 17:00:00', '2022-01-02 13:30:00', '2022-01-02 12:00:00');
