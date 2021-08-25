CREATE DATABASE IF NOT EXISTS ASCON;

USE ASCON;

DROP TABLE IF EXISTS client_table;
DROP TABLE IF EXISTS accomodation_table;
DROP TABLE IF EXISTS block_name_table;
DROP TABLE IF EXISTS location_table;
DROP TABLE IF EXISTS occupant_table;
DROP TABLE IF EXISTS front_page_table;

CREATE TABLE client_table (
    client_id BIGINT NOT NULL AUTO_INCREMENT,
    client_name TEXT NOT NULL,
    client_company TEXT NOT NULL,
    client_address TEXT NOT NULL,
    accomodation_type TEXT NOT NULL,
    block_name TEXT NOT NULL,
    client_location INTEGER NOT NULL,
    client_room_number INTEGER NOT NULL,
    occupants INTEGER NOT NULL,
    client_arrival_date BIGINT NOT NULL,
    client_departure_date BIGINT NOT NULL,
    client_status INT NOT NULL,
    remark TEXT NOT NULL,
    course_title TEXT NOT NULL,
    department TEXT NOT NULL,
    program_cost REAL NOT NULL,
    
    PRIMARY KEY (client_id)
);

CREATE TABLE accomodation_table (
    accomodation_id INTEGER NOT NULL AUTO_INCREMENT,
    accomodation_name TEXT NOT NULL,
    PRIMARY KEY (accomodation_id)
);

CREATE TABLE block_name_table (
    block_id INTEGER NOT NULL AUTO_INCREMENT,
    block_name TEXT NOT NULL,
    PRIMARY KEY (block_id)
);

CREATE TABLE location_table (
    location_id INTEGER NOT NULL AUTO_INCREMENT,
    location_name TEXT NOT NULL,
    PRIMARY KEY (location_id)
);

CREATE TABLE occupant_table (
    occupant_id INTEGER NOT NULL AUTO_INCREMENT,
    occupant_name TEXT NOT NULL,
    PRIMARY KEY (occupant_id)
);

CREATE TABLE front_page_table (
    front_page_id INTEGER NOT NULL AUTO_INCREMENT,
    front_page_name TEXT NOT NULL,
    PRIMARY KEY (front_page_id)
);

INSERT INTO accomodation_table (accomodation_name) VALUE ('CHALET');
INSERT INTO accomodation_table (accomodation_name) VALUE ('SINGLE ROOM');
INSERT INTO accomodation_table (accomodation_name) VALUE ('DOUBLE ROOM');

INSERT INTO block_name_table (block_name) VALUE ('DUPLEX');
INSERT INTO block_name_table (block_name) VALUE ('OGUNDIPE');
INSERT INTO block_name_table (block_name) VALUE ('BALOGUN');
INSERT INTO block_name_table (block_name) VALUE ('ADELE JINADU');
INSERT INTO block_name_table (block_name) VALUE ('SHIEHK ABUDULAHI');
INSERT INTO block_name_table (block_name) VALUE ('15B');
INSERT INTO block_name_table (block_name) VALUE ('15D');
INSERT INTO block_name_table (block_name) VALUE ('16A');
INSERT INTO block_name_table (block_name) VALUE ('16B');
INSERT INTO block_name_table (block_name) VALUE ('17A');

INSERT INTO location_table (location_name) VALUE ('PHASE 1');
INSERT INTO location_table (location_name) VALUE ('PHASE 2');

INSERT INTO occupant_table (occupant_name) VALUE ('STAFF');
INSERT INTO occupant_table (occupant_name) VALUE ('PARTICIPANT');
INSERT INTO occupant_table (occupant_name) VALUE ('FACILITY USER');
INSERT INTO occupant_table (occupant_name) VALUE ('INDIVIDUAL');
INSERT INTO occupant_table (occupant_name) VALUE ('OTHERS');

INSERT INTO front_page_table (front_page_name) VALUE ('
        ASCON is an acronym of the word Administrative Staff College of 
        Nigeria which was institutionalized by the constitution of Federal 
        Republic of Nigeria in 1978 by the Act 2343, No2. This application was 
        developed to assist the front desk personel in accessing clients 
        payment details ');
INSERT INTO front_page_table (front_page_name) VALUE ('
        This application handles the front desktop activity of registering
        clients, printing their receipt and search for clients details');

