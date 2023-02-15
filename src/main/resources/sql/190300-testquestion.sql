CREATE TABLE testquestion (
	testquestion_id int4 NOT NULL,
	testquestion_text varchar(300) NOT NULL,
	test_id int4 NOT NULL,
	CONSTRAINT testquestion_pk PRIMARY KEY (testquestion_id),
	--CONSTRAINT testquestion_fk FOREIGN KEY (test_id) REFERENCES test(test_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE SEQUENCE testquestion_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;

CREATE TABLE test (
	test_id int4 NOT NULL,
	test_name varchar(100) NOT NULL,
	test_desc varchar(300) NULL,
	CONSTRAINT test_pk PRIMARY KEY (test_id)
);
CREATE SEQUENCE test_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;