CREATE TABLE proguser (
    proguser_id INTEGER NOT NULL,
    proguser_name varchar(50) NOT NULL,
    proguser_fullname varchar(100) NULL,
    proguser_password varchar(255) NOT NULL,
    proguser_active INTEGER NOT NULL,
    people_id INTEGER NULL,
    CONSTRAINT proguser_pk PRIMARY KEY (proguser_id)
);
CREATE SEQUENCE proguser_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;
INSERT INTO proguser VALUES (0, 'SYSDBA', 'Системный администратор',
                                                     '$2a$10$JtM6dcdfqqBAO1Gscq.JP.SliEMX3.tY.7PvSNh1NJmFb.kQipye2', 1, 1);

CREATE TABLE proguserrole (
    proguserrole_id INTEGER NOT NULL,
    proguser_id INTEGER NOT NULL,
    accessrole_id INTEGER NOT NULL,
    CONSTRAINT proguserrole_pk PRIMARY KEY (proguserrole_id)
);
CREATE SEQUENCE proguserrole_id_gen INCREMENT BY 1 MINVALUE 2 MAXVALUE 2147483647 START 2 CACHE 1 NO CYCLE;
INSERT INTO proguserrole VALUES (1, 0, 1);

CREATE TABLE sqlaction (
    sqlaction_id INTEGER NOT NULL,
    sqlaction_name varchar(25) NOT NULL,
    sqlaction_sql varchar(25) NOT NULL,
    CONSTRAINT sqlaction_pk PRIMARY KEY (sqlaction_id)
);
CREATE SEQUENCE sqlaction_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;

CREATE TABLE proguserauth (
	proguserauth_id INTEGER NOT NULL,
	proguserauth_create date NOT NULL,
	proguserauth_token varchar(50) NOT NULL,
	proguser_id INTEGER NOT NULL,
	CONSTRAINT proguserauth_pk PRIMARY KEY (proguserauth_id),
	CONSTRAINT proguserauth_un UNIQUE (proguser_id)
);
CREATE SEQUENCE proguserauth_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;
INSERT INTO proguserauth (proguserauth_id,proguserauth_create,proguserauth_token,proguser_id) VALUES
	 (1,'2022-12-11','b70cd02a-7933-11ed-a1eb-0242ac120002',0);
