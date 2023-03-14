CREATE TABLE block (
    block_id INTEGER NOT NULL,
    block_name varchar(100) NOT NULL,
    studyprogram_id INTEGER NOT NULL,
    block_num INTEGER NOT NULL,
    block_visible INTEGER NOT NULL,
    capclass_id INTEGER NOT NULL,
    CONSTRAINT block_pk PRIMARY KEY (block_id),
    CONSTRAINT block_un UNIQUE (studyprogram_id,capclass_id)
);
CREATE SEQUENCE block_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;