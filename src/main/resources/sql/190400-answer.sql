CREATE TABLE public.answer (
	answer_id int4 NOT NULL,
	answer_text varchar(200) NOT NULL,
	answer_right int4 NOT NULL,
	testquestion_id int4 NOT NULL,
	CONSTRAINT answer_pk PRIMARY KEY (answer_id),
	CONSTRAINT answer_fk FOREIGN KEY (testquestion_id) REFERENCES public.testquestion(testquestion_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE SEQUENCE answer_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;


CREATE TABLE public.testquestion (
	testquestion_id int4 NOT NULL,
	testquestion_text varchar(300) NOT NULL,
	test_id int4 NOT NULL,
	CONSTRAINT testquestion_pk PRIMARY KEY (testquestion_id),
	CONSTRAINT testquestion_fk FOREIGN KEY (test_id) REFERENCES public.test(test_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE SEQUENCE testquestion_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;