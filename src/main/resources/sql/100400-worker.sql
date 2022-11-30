CREATE TABLE worker (
    worker_id serial4 NOT NULL,
    worker_lastname varchar(20) NOT NULL,
    worker_name varchar(20) NOT NULL,
    worker_middlename varchar(20) NOT NULL,
    worker_salary float8 NOT NULL,
    post_id int4 NOT NULL,
    worker_birthday date NOT NULL,
    worker_datestartjob date NOT NULL,
    worker_dateendjob date NOT NULL,
    worker_password varchar(10) NOT NULL,
    CONSTRAINT worker_pk PRIMARY KEY (worker_id),
    CONSTRAINT worker_un UNIQUE (worker_password)
    /*CONSTRAINT worker_fk FOREIGN KEY (post_id) REFERENCES post(post_id) ON DELETE CASCADE ON UPDATE CASCADE*/
);
CREATE SEQUENCE worker_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;