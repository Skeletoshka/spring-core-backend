CREATE TABLE people (
	people_id INTEGER NOT NULL,
	people_name VARCHAR(100) NOT NULL,
	people_lastname VARCHAR(100) NOT NULL,
	people_middlename VARCHAR(100) NOT NULL,
	people_datebirth DATE NOT NULL,
	capclass_id INTEGER NOT NULL,
	people_email VARCHAR(255) NULL,
	people_phone VARCHAR(50) NULL,
	people_deleteflag INTEGER NOT NULL,
	people_datedelete DATE NULL,
	company_id INTEGER,
	CONSTRAINT people_pk PRIMARY KEY (people_id)
);
CREATE SEQUENCE people_id_gen
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;

CREATE TABLE "family" (
	family_id int4 NOT NULL,
	parent_id int4 NOT NULL,
	child_id int4 NOT NULL,
	CONSTRAINT family_pk PRIMARY KEY (family_id),
	CONSTRAINT family_un UNIQUE (parent_id, child_id)
);