CREATE TABLE controlobjectrole (
    controlobject_id integer NOT NULL,
    controlobject_name varchar(250) NOT NULL,
    controlobject_url varchar(100) NOT NULL,
    CONSTRAINT controlobject_pk PRIMARY KEY (controlobject_id)
);

CREATE TABLE controlobjectrole (
    controlobjectrole_id serial4 NOT NULL,
    controlobject_id integer NOT NULL,
    accessrole_id integer NOT NULL,
    sqlaction_id integer NOT NULL,
    CONSTRAINT controlobjectrole_pk PRIMARY KEY (controlobjectrole_id),
    CONSTRAINT controlobjectrole_un UNIQUE (sqlaction_id,accessrole_id,controlobject_id),
    CONSTRAINT controlobjectrole_fk FOREIGN KEY (controlobject_id) REFERENCES controlobject(controlobject_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT controlobjectrole_fk_1 FOREIGN KEY (sqlaction_id) REFERENCES sqlaction(sqlaction_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT controlobjectrole_fk_2 FOREIGN KEY (accessrole_id) REFERENCES accessrole(accessrole_id) ON DELETE CASCADE ON UPDATE CASCADE
);