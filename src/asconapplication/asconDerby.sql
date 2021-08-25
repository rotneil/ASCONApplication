CONNECT 'jdbc:derby:ascon;create=true;user=ascon;password=ascon';

CREATE TABLE client_table (
    client_id BIGINT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
    client_name VARCHAR(100) NOT NULL,
    client_company VARCHAR(200) NOT NULL,
    client_address VARCHAR(200) NOT NULL,
    accomodation_type INTEGER NOT NULL,
    block_name INTEGER NOT NULL,
    client_location INTEGER NOT NULL,
    client_room_number INTEGER NOT NULL,
    occupants INTEGER NOT NULL,
    client_arrival_date BIGINT NOT NULL,
    client_departure_date BIGINT NOT NULL,
    client_status INT NOT NULL,
    remark VARCHAR(200) NOT NULL,
    course_title VARCHAR(100) NOT NULL,
    department VARCHAR(100) NOT NULL,
    program_cost REAL NOT NULL,
    reference_number VARCHAR (20) NOT NULL
);

CREATE TABLE accomodation_table (
    accomodation_id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
    accomodation_name VARCHAR(100) NOT NULL
);

CREATE TABLE block_name_table (
    block_id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
    block_name VARCHAR(100) NOT NULL
);

CREATE TABLE location_table (
    location_id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
    location_name VARCHAR(100) NOT NULL
);

CREATE TABLE occupant_table (
    occupant_id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
    occupant_name VARCHAR(100) NOT NULL
);

CREATE TABLE front_page_table (
    front_page_id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
    front_page_name VARCHAR(2000) NOT NULL
);

CREATE TABLE ascon_event_table (
    ascon_event_id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
    ascon_event_message VARCHAR(2000) NOT NULL,
    ascon_event_date INTEGER NOT NULL
);

INSERT INTO accomodation_table (accomodation_name) VALUES ('CHALET');
INSERT INTO accomodation_table (accomodation_name) VALUES ('SINGLE ROOM');
INSERT INTO accomodation_table (accomodation_name) VALUES ('DOUBLE ROOM');

INSERT INTO block_name_table (block_name) 
    VALUES ('DUPLEX'), ('OGUNDIPE'), ('BALOGUN'), ('ADELE JINADU'), 
    ('SHIEHK ABUDULAHI'), ('15B'), ('15D'), ('16A'), ('16B'), ('17A');

INSERT INTO location_table (location_name) 
    VALUES ('PHASE 1'), ('PHASE 2');

INSERT INTO occupant_table (occupant_name) 
    VALUES ('STAFF'), ('PARTICIPANT'), ('FACILITY USER'), ('INDIVIDUAL'), ('OTHERS');

INSERT INTO front_page_table (front_page_name) 
    VALUES ('
        ASCON is an acronym of the word Administrative Staff College of 
        Nigeria which was institutionalized by the constitution of Federal 
        Republic of Nigeria in 1978 by the Act 2343, No2. This application was 
        developed to assist the front desk personel in accessing clients 
        payment details '),
        ('
        This application handles the front desktop activity of registering
        clients, printing their receipt and search for clients details');

INSERT INTO ascon_event_table (ascon_event_date, ascon_event_message)
    VALUES ('1457356283007', '
        ASCON general staff meeting with the Director General of the 
        College comes up on the above mentioned date. All members 
        of the college are hereby encouraged and requested to be 
        available for this crucial meeting. Members should also 
        note that the promotion exercise that is sheduled to come 
        after the meeting is sequel on their performance before and 
        after the meeting.'), ('1457356283007', '

        ASCON general staff promotion exercise as directed by 
        the Director General of the 
        College comes up on the above mentioned date. All members 
        of the college are hereby encouraged and requested to be 
        available for this crucial meeting. Members should also 
        note that the promotion exercise that is sheduled to come 
        after the meeting is sequel on their performance before and 
        after the meeting.');

disconnect;