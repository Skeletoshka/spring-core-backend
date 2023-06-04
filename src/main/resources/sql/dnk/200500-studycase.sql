CREATE TABLE studycase (
    studycase_id INTEGER NOT NULL,
    studyprogram_id INTEGER NOT NULL,
    studycase_name VARCHAR(255) NOT NULL,
    studycase_desc VARCHAR(255) NULL,
    studycase_num INTEGER NOT NULL,
    studycase_visible INTEGER NOT NULL,
    CONSTRAINT studycase_pk PRIMARY KEY (studycase_id)
);
CREATE SEQUENCE studycase_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;