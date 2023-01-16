CREATE TABLE public.testhistory (
	testhistory_id int4 NOT NULL,
	people_id int4 NOT NULL,
	testquestion_id int4 NOT NULL,
	answer_id int4 NOT NULL,
	CONSTRAINT testhistory_pk PRIMARY KEY (testhistory_id),
	CONSTRAINT testhistory_fk FOREIGN KEY (answer_id) REFERENCES public.answer(answer_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE SEQUENCE testhistory_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;

CREATE TABLE public.answer (
	answer_id int4 NOT NULL,
	answer_text varchar(200) NOT NULL,
	answer_right int4 NULL,
	testquestion_id int4 NOT NULL,
	CONSTRAINT answer_pk PRIMARY KEY (answer_id)
);
CREATE SEQUENCE answer_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;