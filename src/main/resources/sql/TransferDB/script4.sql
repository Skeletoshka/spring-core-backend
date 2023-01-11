CREATE TABLE shedule (
	shedule_id INTEGER NOT NULL,
	course_id INTEGER NOT NULL,
	teacher_id INTEGER NOT NULL,
	workgroup_id INTEGER NOT NULL,
	shedule_date date NULL,
	shedule_place varchar(50) NULL,
	CONSTRAINT shedule_pk PRIMARY KEY (shedule_id)
);


CREATE TABLE workgroup (
	workgroup_id INTEGER NOT NULL,
	workgroup_name varchar(50) NULL,
	direction_id INTEGER NOT NULL,
	CONSTRAINT workgroup_pk PRIMARY KEY (workgroup_id)
);


CREATE TABLE attendance (
	attendance_id INTEGER NOT NULL,
	shedule_id INTEGER NOT NULL,
	people_id INTEGER NOT NULL,
	attendnce_presenceflag INTEGER NULL,
	CONSTRAINT attendance_pk PRIMARY KEY (attendance_id),
	CONSTRAINT attendance_fk FOREIGN KEY (shedule_id) REFERENCES shedule(shedule_id) ON DELETE CASCADE ON UPDATE CASCADE
);