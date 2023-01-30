CREATE TABLE studyprogram (
    studyprogram_id INTEGER NOT NULL,
    studyprogram_name varchar(100) NOT NULL,
    direction_id INTEGER NOT NULL,
    teacher_id INTEGER NOT NULL,
    assistant_id INTEGER,
    CONSTRAINT studyprogram_pk PRIMARY KEY (studyprogram_id),
    CONSTRAINT studyprogram_un UNIQUE (studyprogram_name)
    /*CONSTRAINT studyprogram_fk FOREIGN KEY (direction_id) REFERENCES post(direction_id) ON DELETE CASCADE ON UPDATE CASCADE*/
);
CREATE SEQUENCE studyprogram_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;
