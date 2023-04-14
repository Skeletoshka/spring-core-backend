CREATE TABLE capclasstype (
    capclasstype_id INTEGER NOT NULL,
    capclasstype_name VARCHAR(50) NOT NULL,
    capclasstype_desc VARCHAR(100) NOT NULL,
    CONSTRAINT capclasstype_pk PRIMARY KEY (capclasstype_id)
);

CREATE SEQUENCE capclasstype_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;