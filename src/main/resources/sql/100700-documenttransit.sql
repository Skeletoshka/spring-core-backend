CREATE TABLE documenttransit (
	documenttransit_id int4 NOT NULL,
	documenttransit_name varchar(100) NOT NULL,
	documenttype_id int4 NOT NULL,
	documenttransit_number int4 NOT NULL,
	documenttransit_color int4 NOT NULL,
	CONSTRAINT documenttransit_pk PRIMARY KEY (documenttransit_id),
	CONSTRAINT documenttransit_un UNIQUE (documenttype_id, documenttransit_number)
);

CREATE SEQUENCE documenttransit_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;