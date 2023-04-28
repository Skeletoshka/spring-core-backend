CREATE TABLE requestpos (
    requestpos_id INTEGER NOT NULL,
    request_id INTEGER NOT NULL,
    requestpos_text VARCHAR(255) NOT NULL,
    service_id INTEGER NOT NULL,
    CONSTRAINT requestpos_pk PRIMARY KEY (requestpos_id)
);

CREATE SEQUENCE requestpos_id_gen
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1
    NO CYCLE;