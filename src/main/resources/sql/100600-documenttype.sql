CREATE TABLE documenttype (
	documenttype_id int4 NOT NULL,
	documenttype_name varchar(255) NOT NULL,
	CONSTRAINT documenttype_pk PRIMARY KEY (documenttype_id),
	CONSTRAINT documenttype_un UNIQUE (documenttype_name)
);

CREATE SEQUENCE documenttype_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;