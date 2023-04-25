CREATE TABLE activity (
    activity_id INTEGER NOT NULL,
    address_id INTEGER NOT NULL,
    direction_id INTEGER NOT NULL,
    company_id INTEGER NULL,
    activity_name VARCHAR(255) NOT NULL,
    activity_date TIMESTAMP NOT NULL,
    capclass_id INTEGER NOT NULL,
    CONSTRAINT activity_pk PRIMARY KEY (activity_id)
);

CREATE SEQUENCE activity_id_gen
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1
    NO CYCLE;