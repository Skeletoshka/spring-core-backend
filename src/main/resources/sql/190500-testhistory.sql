CREATE TABLE testhistory (
	testhistory_id int4 NOT NULL,
	people_id int4 NOT NULL,
	testquestion_id int4 NOT NULL,
	answer_id int4 NOT NULL,
	CONSTRAINT testhistory_pk PRIMARY KEY (testhistory_id),
	--CONSTRAINT testhistory_fk FOREIGN KEY (testquestion_id) REFERENCES testquestion(testquestion_id) ON DELETE CASCADE ON UPDATE CASCADE,
	--CONSTRAINT testhistory_fk_1 FOREIGN KEY (answer_id) REFERENCES answer(answer_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE SEQUENCE testhistory_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;
