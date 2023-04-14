CREATE TABLE capclass (
    capclass_id INTEGER NOT NULL,
    capclass_name VARCHAR(50) NOT NULL,
    capclass_desc VARCHAR(100) NOT NULL,
    capclasstype_id INTEGER NOT NULL,
    CONSTRAINT capclass_pk PRIMARY KEY (capclass_id)
);

CREATE SEQUENCE capclass_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;