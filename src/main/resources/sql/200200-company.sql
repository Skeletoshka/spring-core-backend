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

CREATE OR REPLACE VIEW company_ft AS
SELECT c.company_id, CONCAT(c.company_name, ' ', c.proguser_id, ' ', c.address_id, ' ', c.company_telephone, ' ', c.company_email) as fulltext
FROM   company c;