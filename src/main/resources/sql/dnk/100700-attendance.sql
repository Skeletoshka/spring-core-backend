CREATE TABLE attendance (
    attendance_id INTEGER NOT NULL,
    schedule_id INTEGER NOT NULL,
    people_id INTEGER NOT NULL,
    attendance_presenceflag INTEGER NOT NULL,
    CONSTRAINT attendance_pk PRIMARY KEY (attendance_id)
);
CREATE SEQUENCE attendance_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;
