CREATE TABLE accessrole (
    accessrole_id serial4 NOT NULL,
    accessrole_name varchar(50) NOT NULL,
    accessrole_fullname varchar(100) NULL,
    CONSTRAINT accessrole_pk PRIMARY KEY (accessrole_id)
);
CREATE SEQUENCE accessrole_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;