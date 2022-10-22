CREATE TABLE proguser (
    proguser_id serial4 NOT NULL,
    proguser_name varchar(50) NOT NULL,
    proguser_fullname varchar(100) NULL,
    proguser_password varchar(255) NOT NULL,
    proguser_active integer NOT NULL,
    worker_id integer NULL,
    CONSTRAINT proguser_pk PRIMARY KEY (proguser_id),
    CONSTRAINT proguser_fk FOREIGN KEY (worker_id) REFERENCES worker(worker_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE proguserrole (
    proguserrole_id serial4 NOT NULL,
    proguser_id integer NOT NULL,
    accessrole_id integer NOT NULL,
    CONSTRAINT proguserrole_pk PRIMARY KEY (proguserrole_id),
    CONSTRAINT proguserrole_fk FOREIGN KEY (proguser_id) REFERENCES proguser(proguser_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT proguserrole_fk_1 FOREIGN KEY (accessrole_id) REFERENCES accessrole(accessrole_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE dbo.sqlaction (
    sqlaction_id serial4 NOT NULL,
    sqlaction_name varchar(25) NOT NULL,
    sqlaction_sql varchar(25) NOT NULL,
    CONSTRAINT sqlaction_pk PRIMARY KEY (sqlaction_id)
);