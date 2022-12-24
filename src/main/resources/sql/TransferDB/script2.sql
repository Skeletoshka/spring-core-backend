CREATE TABLE capcode (
	capcode_id INTEGER NOT NULL,
	capcode_name VARCHAR(15) NOT NULL,
	capcode_desc VARCHAR(50) NOT NULL,
	CONSTRAINT capcode_pk PRIMARY KEY (capcode_id)
);

CREATE SEQUENCE capcode_id_gen
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

CREATE TABLE capclass (
	capclass_id INTEGER NOT NULL,
	capclass_name VARCHAR(15) NOT NULL,
	capclass_desc VARCHAR(50) NOT NULL,
	capcode_id int4 NOT NULL,
	CONSTRAINT capclass_pk PRIMARY KEY (capclass_id),
	CONSTRAINT capclass_fk FOREIGN KEY (capcode_id) REFERENCES capcode(capcode_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE SEQUENCE capclass_id_gen
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

CREATE TABLE street (
	street_id INTEGER NOT NULL,
	street_name varchar(100) NOT NULL,
	CONSTRAINT street_pk PRIMARY KEY (street_id)
);

CREATE SEQUENCE street_id_gen
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

CREATE TABLE house (
	house_id INTEGER NOT NULL,
	house_name INTEGER NOT NULL,
	house_litera varchar(5) NULL,
	house_corpus INTEGER NULL,
	CONSTRAINT house_pk PRIMARY KEY (house_id)
);

CREATE SEQUENCE house_id_gen
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

CREATE TABLE town (
	town_id INTEGER NOT NULL,
	town_name varchar(50) NOT NULL,
	capclass_id INTEGER NOT NULL,
	CONSTRAINT town_pk PRIMARY KEY (town_id),
	CONSTRAINT town_fk FOREIGN KEY (capclass_id) REFERENCES capclass(capclass_id)
);

CREATE SEQUENCE town_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

CREATE TABLE address (
	address_id INTEGER NOT NULL,
	town_id int4 NOT NULL,
	street_id int4 NOT NULL,
	house_id int4 NOT NULL,
	CONSTRAINT address_pk PRIMARY KEY (address_id),
	CONSTRAINT address_un UNIQUE (town_id,street_id,house_id),
	CONSTRAINT address_fk FOREIGN KEY (house_id) REFERENCES house(house_id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT address_fk_1 FOREIGN KEY (town_id) REFERENCES town(town_id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT address_fk_2 FOREIGN KEY (street_id) REFERENCES street(street_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE SEQUENCE address_id_gen
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

CREATE TABLE direction (
	direction_id INTEGER NOT NULL,
	direction_name varchar(50) NOT NULL,
	direction_desc varchar(100) NULL,
	CONSTRAINT direction_pk PRIMARY KEY (direction_id)
);

CREATE SEQUENCE dbo.direction_id_gen
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;


