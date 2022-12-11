CREATE TABLE controlobject (
    controlobject_id integer NOT NULL,
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
    CONSTRAINT controlobjectrole_un UNIQUE (sqlaction_id,accessrole_id,controlobject_id)
    /*CONSTRAINT controlobjectrole_fk FOREIGN KEY (controlobject_id) REFERENCES controlobject(controlobject_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT controlobjectrole_fk_1 FOREIGN KEY (sqlaction_id) REFERENCES sqlaction(sqlaction_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT controlobjectrole_fk_2 FOREIGN KEY (accessrole_id) REFERENCES accessrole(accessrole_id) ON DELETE CASCADE ON UPDATE CASCADE*/
);
CREATE SEQUENCE controlobjectrole_id_gen INCREMENT BY 1 MINVALUE 2 MAXVALUE 2147483647 START 2 CACHE 1 NO CYCLE;
