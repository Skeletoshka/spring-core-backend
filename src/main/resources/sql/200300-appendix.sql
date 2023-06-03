CREATE TABLE appendix (
    appendix_id INTEGER NOT NULL,
    appendix_name VARCHAR(100) NOT NULL,
    appendix_path VARCHAR(100) NOT NULL,
    CONSTRAINT appendix_pk PRIMARY KEY (appendix_id)
);

CREATE TABLE material (
    material_id INTEGER NOT NULL,
    block_id INTEGER NOT NULL,
    CONSTRAINT material_pk PRIMARY KEY (material_id)
);