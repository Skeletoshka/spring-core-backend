CREATE TABLE company (
	company_id INTEGER NOT NULL,
	company_name varchar(50) NOT NULL,
	address_id INTEGER NULL,
	company_telephone varchar(20) NULL,
	company_email varchar(100) NULL,
	capclass_id INTEGER NOT NULL,
	CONSTRAINT company_pk PRIMARY KEY (company_id),
	CONSTRAINT company_fk FOREIGN KEY (capclass_id) REFERENCES capclass(capclass_id) ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY DEFERRED,
	CONSTRAINT company_fk_1 FOREIGN KEY (address_id) REFERENCES address(address_id) ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY DEFERRED
);

CREATE TABLE documentreal (
	documentreal_id INTEGER NOT NULL,
	documentreal_name varchar(255) NOT NULL,
	documentreal_date date NOT NULL,
	capclass_id int4 NOT NULL,
	documentreal_path varchar(100) NOT NULL,
	proguser_id int4 NOT NULL,
	CONSTRAINT document_pk PRIMARY KEY (documentreal_id),
	CONSTRAINT document_fk FOREIGN KEY (capclass_id) REFERENCES capclass(capclass_id) ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY DEFERRED,
	CONSTRAINT document_fk_1 FOREIGN KEY (proguser_id) REFERENCES proguser(proguser_id) ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY DEFERRED
);

CREATE TABLE request (
	request_id INTEGER NOT NULL,
	request_name varchar(100) NOT NULL,
	request_date date NOT NULL,
	request_applyflag INTEGER NULL,
	proguser_id int4 NOT NULL,
	CONSTRAINT request_pk PRIMARY KEY (request_id),
	CONSTRAINT request_fk FOREIGN KEY (proguser_id) REFERENCES proguser(proguser_id) ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY DEFERRED
);

ALTER TABLE request ADD capclass_id INTEGER NOT NULL;
ALTER TABLE request ADD CONSTRAINT request_fk_1 FOREIGN KEY (capclass_id) REFERENCES capclass(capclass_id) ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY DEFERRED;

CREATE TABLE service (
	service_id INTEGER NOT NULL,
	service_name varchar(100) NOT NULL,
	service_desc varchar(255) NULL,
	CONSTRAINT service_pk PRIMARY KEY (service_id)
);

CREATE TABLE requestpos (
	requestpos_id INTEGER NOT NULL,
	request_id int4 NOT NULL,
	service_id int4 NOT NULL,
	requestpos_text varchar(150) NOT NULL,
	CONSTRAINT requestpos_pk PRIMARY KEY (requestpos_id),
	CONSTRAINT requestpos_fk FOREIGN KEY (service_id) REFERENCES service(service_id) ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY DEFERRED
);

CREATE TABLE eventreal (
	eventreal_id INTEGER NOT NULL,
	eventreal_name varchar(100) NOT NULL,
	eventreal_date date NOT NULL,
	address_id INTEGER NOT NULL,
	direction_id INTEGER NOT NULL,
	company_id INTEGER NULL,
	CONSTRAINT event_pk PRIMARY KEY (eventreal_id),
	CONSTRAINT event_fk FOREIGN KEY (company_id) REFERENCES company(company_id) ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY DEFERRED,
	CONSTRAINT event_fk_1 FOREIGN KEY (direction_id) REFERENCES direction(direction_id) ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY DEFERRED,
	CONSTRAINT event_fk_2 FOREIGN KEY (address_id) REFERENCES address(address_id) ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY DEFERRED
);

ALTER TABLE requestpos ADD CONSTRAINT requestpos_fk_1 FOREIGN KEY (request_id) REFERENCES request(request_id) ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE workgroup ADD CONSTRAINT workgroup_fk FOREIGN KEY (direction_id) REFERENCES direction(direction_id) ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY DEFERRED;

CREATE TABLE peoplegroup (
	peoplegroup_id INTEGER NOT NULL,
	people_id INTEGER NOT NULL,
	workgroup_id INTEGER NOT NULL,
	CONSTRAINT peoplegroup_pk PRIMARY KEY (peoplegroup_id),
	CONSTRAINT peoplegroup_fk FOREIGN KEY (people_id) REFERENCES people(people_id) ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY DEFERRED,
	CONSTRAINT peoplegroup_fk_1 FOREIGN KEY (workgroup_id) REFERENCES workgroup(workgroup_id) ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY DEFERRED
);

ALTER TABLE attendance ADD CONSTRAINT attendance_fk_1 FOREIGN KEY (people_id) REFERENCES people(people_id) ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE studyprogram ADD CONSTRAINT studyprogram_fk FOREIGN KEY (direction_id) REFERENCES direction(direction_id) ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE studyprogram ADD CONSTRAINT studyprogram_fk_1 FOREIGN KEY (teacher_id) REFERENCES people(people_id) ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE studyprogram ADD CONSTRAINT studyprogram_fk_2 FOREIGN KEY (assistant_id) REFERENCES people(people_id) ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE shedule RENAME COLUMN course_id TO studyprogram_id;
ALTER TABLE shedule ADD CONSTRAINT shedule_fk FOREIGN KEY (studyprogram_id) REFERENCES studyprogram(studyprogram_id) ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE shedule ADD CONSTRAINT shedule_fk_1 FOREIGN KEY (teacher_id) REFERENCES people(people_id) ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY DEFERRED;
ALTER TABLE shedule ADD CONSTRAINT shedule_fk_2 FOREIGN KEY (workgroup_id) REFERENCES workgroup(workgroup_id) ON DELETE CASCADE ON UPDATE CASCADE DEFERRABLE INITIALLY DEFERRED;


