CREATE TABLE schedule (
    schedule_id int4 NOT NULL,
    studyprogram_id int4 NOT NULL,
    workgroup_id int4 NOT NULL,
    schedule_place varchar(20) NOT NULL,
    schedule_date timestamp NOT NULL,
    CONSTRAINT schedule_pk PRIMARY KEY (schedule_id)
);

CREATE SEQUENCE schedule_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;