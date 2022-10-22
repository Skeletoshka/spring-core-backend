CREATE TABLE accessrole (
    accessrole_id serial4 NOT NULL,
    accessrole_name varchar(50) NOT NULL,
    accessrole_fullname varchar(100) NULL,
    CONSTRAINT accessrole_pk PRIMARY KEY (accessrole_id)
);