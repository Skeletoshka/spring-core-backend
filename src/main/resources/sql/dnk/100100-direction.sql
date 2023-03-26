CREATE TABLE direction (
	direction_id int4 NOT NULL,
	direction_name varchar(100) NOT NULL,
	direction_desc varchar(100) NULL,
	CONSTRAINT direction_pk PRIMARY KEY (direction_id)
);

CREATE SEQUENCE direction_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;