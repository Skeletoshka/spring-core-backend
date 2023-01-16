CREATE TABLE public.test (
	test_id int4 NOT NULL,
	test_name varchar(100) NOT NULL,
	test_desc varchar(300) NULL,
	CONSTRAINT test_pk PRIMARY KEY (test_id)
);
CREATE SEQUENCE test_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;