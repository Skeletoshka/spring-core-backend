CREATE TABLE testhistory (
	testhistory_id INTEGER NOT NULL,
	people_id INTEGER NOT NULL,
	testquestion_id INTEGER NOT NULL,
	answer_id INTEGER NOT NULL,
	CONSTRAINT testhistory_pk PRIMARY KEY (testhistory_id)
);
CREATE SEQUENCE testhistory_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;
