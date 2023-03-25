CREATE TABLE documentreal (
	documentreal_id int4 NOT NULL,
	documenttype_id int4 NOT NULL,
	documenttransit_id int4 NULL,
	documentreal_name varchar(100) NOT NULL,
	documentreal_number varchar(100) NOT NULL,
	documentreal_datecreate date NOT NULL,
	documentreal_datemodify date NULL,
	proguser_id int4 NOT NULL,
	CONSTRAINT documentreal_pk PRIMARY KEY (documentreal_id)
);

CREATE SEQUENCE documentreal_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;