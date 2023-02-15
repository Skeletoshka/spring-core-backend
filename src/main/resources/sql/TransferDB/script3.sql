CREATE TABLE people (
	people_id INTEGER NOT NULL,
	people_name varchar(20) NOT NULL,
	people_lastname varchar(20) NOT NULL,
	people_middlename varchar(20) NOT NULL,
	people_datebirth date NOT NULL,
	capclass_id int4 NOT NULL,
	people_email varchar(40) NULL,
	people_phone varchar(10) NULL,
	people_deleteflag varchar NOT NULL,
	people_datedelete date NULL,
	CONSTRAINT people_pk PRIMARY KEY (people_id),
	CONSTRAINT people_fk_1 FOREIGN KEY (capclass_id) REFERENCES capclass(capclass_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE family (
	family_id INTEGER NOT NULL,
	parent_id INTEGER NOT NULL,
	child_id INTEGER NOT NULL,
	CONSTRAINT family_pk PRIMARY KEY (family_id),
	CONSTRAINT family_fk_1 FOREIGN KEY (parent_id) REFERENCES people(people_id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT family_fk_2 FOREIGN KEY (child_id) REFERENCES people(people_id) ON DELETE CASCADE ON UPDATE CASCADE
);