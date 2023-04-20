CREATE TABLE company (
    company_id INTEGER NOT NULL,
    company_name VARCHAR(255) NOT NULL,
    proguser_id INTEGER NOT NULL,
    address_id INTEGER NOT NULL,
    company_telephone VARCHAR(50) NULL,
    company_email VARCHAR(255) NULL,
    CONSTRAINT company_pk PRIMARY KEY (company_id)
);

CREATE SEQUENCE company_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;