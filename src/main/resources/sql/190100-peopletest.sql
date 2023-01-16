CREATE TABLE public.peopletest (
	peopletest_id int4 NOT NULL,
	people_id int4 NOT NULL,
	test_id int4 NOT NULL,
	CONSTRAINT peopletest_pk PRIMARY KEY (peopletest_id),
	CONSTRAINT peopletest_fk FOREIGN KEY (test_id) REFERENCES public.test(test_id)
);
CREATE SEQUENCE peopletest_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;

CREATE TABLE public.test (
	test_id int4 NOT NULL,
	test_name varchar(100) NOT NULL,
	test_desc varchar(300) NULL,
	CONSTRAINT test_pk PRIMARY KEY (test_id)
);
CREATE SEQUENCE test_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;