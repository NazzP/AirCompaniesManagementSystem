-- Inserting AirCompanies
INSERT INTO aircompanies (name, company_type, founded_at) VALUES ('AirCompany1', 'Type1', '2022-01-01');
INSERT INTO aircompanies (name, company_type, founded_at) VALUES ('AirCompany2', 'Type2', '2022-01-02');
INSERT INTO aircompanies (name, company_type, founded_at) VALUES ('AirCompany3', 'Type3', '2022-01-03');
INSERT INTO aircompanies (name, company_type, founded_at) VALUES ('AirCompany4', 'Type4', '2022-01-04');

-- Inserting Airplanes
INSERT INTO airplanes (factory_serial_number, aircompany_id, number_of_flights, flight_distance, fuel_capacity, type, created_at) VALUES (123456789, 1, 100, 5000.0, 1000.0, 'Type1', '2022-01-01 10:00:00');
INSERT INTO airplanes (factory_serial_number, aircompany_id, number_of_flights, flight_distance, fuel_capacity, type, created_at) VALUES (987654321, 2, 150, 7500.0, 1500.0, 'Type2', '2022-01-02 11:00:00');
INSERT INTO airplanes (factory_serial_number, aircompany_id, number_of_flights, flight_distance, fuel_capacity, type, created_at) VALUES (246813579, 3, 200, 10000.0, 2000.0, 'Type3', '2022-01-03 10:00:00');
INSERT INTO airplanes (factory_serial_number, aircompany_id, number_of_flights, flight_distance, fuel_capacity, type, created_at) VALUES (135792468, 4, 250, 12500.0, 2500.0, 'Type4', '2022-01-04 11:00:00');

-- Inserting Flights
INSERT INTO flights (flight_status, airplane_id, aircompany_id, departure_country, destination_country, distance, estimated_flight_time, started_at, ended_at, delay_started_at, created_at) VALUES ('ACTIVE', 1, 2, 'Country1', 'Country2', 2500.0, 2.5, '2025-01-01 12:00:00', NULL , NULL, '2025-01-01 11:30:00');
INSERT INTO flights (flight_status, airplane_id, aircompany_id, departure_country, destination_country, distance, estimated_flight_time, started_at, ended_at, delay_started_at, created_at) VALUES ('ACTIVE', 1, 1, 'Country1', 'Country2', 2500.0, 2.5, '2022-01-01 12:00:00', NULL , NULL, '2022-01-01 11:30:00');
INSERT INTO flights (flight_status, airplane_id, aircompany_id, departure_country, destination_country, distance, estimated_flight_time, started_at, ended_at, delay_started_at, created_at) VALUES ('PENDING', 2, 2, 'Country2', 'Country3', 5000.0, 5.0, NULL, NULL, NULL, '2022-01-02 12:00:00');
INSERT INTO flights (flight_status, airplane_id, aircompany_id, departure_country, destination_country, distance, estimated_flight_time, started_at, ended_at, delay_started_at, created_at) VALUES ('COMPLETED', 2, 2, 'Country2', 'Country3', 5000.0, 2.0, '2022-01-02 13:00:00', '2022-01-02 17:10:00', NULL, '2022-01-02 12:00:00');
INSERT INTO flights (flight_status, airplane_id, aircompany_id, departure_country, destination_country, distance, estimated_flight_time, started_at, ended_at, delay_started_at, created_at) VALUES ('DELAYED', 1, 1, 'Country3', 'Country4', 7500.0, 7.5, '2025-01-03 12:30:00', NULL , '2025-01-03 12:45:00', '2025-01-03 12:15:00');
