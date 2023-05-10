CREATE TABLE appendix (
    appendix_id INTEGER NOT NULL,
    appendix_name VARCHAR(100) NOT NULL,
    appendix_path VARCHAR(100) NOT NULL,
    CONSTRAINT appendix_pk PRIMARY KEY (appendix_id)
);
CREATE SEQUENCE appendix_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;

CREATE TABLE material (
    material_id INTEGER NOT NULL,
    block_id INTEGER NOT NULL,
    CONSTRAINT material_pk PRIMARY KEY (material_id)
);