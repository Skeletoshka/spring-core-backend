CREATE TABLE student (
	student_id INTEGER NOT NULL,
	student_class VARCHAR(5) NOT NULL,
	student_mun VARCHAR(250) NOT NULL,
	contract_id INTEGER NOT NULL,
	CONSTRAINT student_pk PRIMARY KEY (student_id)
);