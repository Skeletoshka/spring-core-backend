CREATE TABLE service (
    service_id INTEGER NOT NULL,
    service_name VARCHAR(255) NOT NULL,
    service_desc VARCHAR(255) NULL,
    CONSTRAINT service_pk PRIMARY KEY (service_id)
);

CREATE SEQUENCE service_id_gen
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1
    NO CYCLE;