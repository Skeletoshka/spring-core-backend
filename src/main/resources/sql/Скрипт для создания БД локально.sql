CREATE TABLE post (
    post_id INTEGER NOT NULL,
    post_name varchar(20) NOT NULL,
    CONSTRAINT post_pk PRIMARY KEY (post_id)
);
CREATE SEQUENCE post_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;

CREATE TABLE worker (
    worker_id INTEGER NOT NULL,
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
    CONSTRAINT worker_un UNIQUE (worker_password),
    CONSTRAINT worker_fk FOREIGN KEY (post_id) REFERENCES post(post_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE SEQUENCE worker_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;

CREATE TABLE proguser (
    proguser_id INTEGER NOT NULL,
    proguser_name varchar(50) NOT NULL,
    proguser_fullname varchar(100) NULL,
    proguser_password varchar(255) NOT NULL,
    proguser_active integer NOT NULL,
    worker_id integer NULL,
    CONSTRAINT proguser_pk PRIMARY KEY (proguser_id),
    CONSTRAINT proguser_fk FOREIGN KEY (worker_id) REFERENCES worker(worker_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE SEQUENCE proguser_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;
INSERT INTO proguser VALUES (0, 'SYSDBA', 'Системный администратор',
                                                     '$2a$10$JtM6dcdfqqBAO1Gscq.JP.SliEMX3.tY.7PvSNh1NJmFb.kQipye2', 1, null);

CREATE TABLE accessrole (
    accessrole_id INTEGER NOT NULL,
    accessrole_name varchar(50) NOT NULL,
    accessrole_fullname varchar(100) NULL,
    CONSTRAINT accessrole_pk PRIMARY KEY (accessrole_id)
);
CREATE SEQUENCE accessrole_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;
INSERT INTO accessrole (accessrole_id,accessrole_name,accessrole_fullname) VALUES
	 (1,'SYSDBA','Системный администратор');


CREATE TABLE proguserrole (
    proguserrole_id INTEGER NOT NULL,
    proguser_id INTEGER NOT NULL,
    accessrole_id INTEGER NOT NULL,
    CONSTRAINT proguserrole_pk PRIMARY KEY (proguserrole_id),
    CONSTRAINT proguserrole_fk FOREIGN KEY (proguser_id) REFERENCES proguser(proguser_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT proguserrole_fk_1 FOREIGN KEY (accessrole_id) REFERENCES accessrole(accessrole_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE SEQUENCE proguserrole_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;
INSERT INTO proguserrole (proguserrole_id,proguser_id,accessrole_id) VALUES
	 (1,0,1);


CREATE TABLE sqlaction (
    sqlaction_id INTEGER NOT NULL,
    sqlaction_name varchar(25) NOT NULL,
    sqlaction_sql varchar(25) NOT NULL,
    CONSTRAINT sqlaction_pk PRIMARY KEY (sqlaction_id)
);
CREATE SEQUENCE sqlaction_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;

CREATE TABLE controlobject (
    controlobject_id INTEGER NOT NULL,
    controlobject_name varchar(250) NOT NULL,
    controlobject_url varchar(100) NOT NULL,
    CONSTRAINT controlobject_pk PRIMARY KEY (controlobject_id)
);
CREATE SEQUENCE controlobject_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;

CREATE TABLE controlobjectrole (
    controlobjectrole_id INTEGER NOT NULL,
    controlobject_id INTEGER NOT NULL,
    accessrole_id INTEGER NOT NULL,
    sqlaction_id INTEGER NOT NULL,
    CONSTRAINT controlobjectrole_pk PRIMARY KEY (controlobjectrole_id),
    CONSTRAINT controlobjectrole_un UNIQUE (sqlaction_id,accessrole_id,controlobject_id),
    CONSTRAINT controlobjectrole_fk FOREIGN KEY (controlobject_id) REFERENCES controlobject(controlobject_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT controlobjectrole_fk_1 FOREIGN KEY (sqlaction_id) REFERENCES sqlaction(sqlaction_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT controlobjectrole_fk_2 FOREIGN KEY (accessrole_id) REFERENCES accessrole(accessrole_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE SEQUENCE controlobjectrole_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;

CREATE TABLE proguserauth (
	proguserauth_id INTEGER NOT NULL,
	proguserauth_create date NOT NULL,
	proguserauth_token varchar(50) NOT NULL,
	proguser_id INTEGER NOT NULL,
	CONSTRAINT proguserauth_pk PRIMARY KEY (proguserauth_id),
	CONSTRAINT proguserauth_un UNIQUE (proguser_id),
	CONSTRAINT proguserauth_fk FOREIGN KEY (proguser_id) REFERENCES proguser(proguser_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE SEQUENCE proguserauth_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;
INSERT INTO proguserauth (proguserauth_id,proguserauth_create,proguserauth_token,proguser_id) VALUES
	 (1,'2022-12-11','b70cd02a-7933-11ed-a1eb-0242ac120002',0);
