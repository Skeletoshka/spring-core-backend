CREATE TABLE workgroup (
	workgroup_id INTEGER NOT NULL,
	workgroup_name varchar(100) NOT NULL,
	direction_id INTEGER NOT NULL,
	workgroup_desc varchar(255) NULL,
	CONSTRAINT workgroup_pk PRIMARY KEY (workgroup_id)
);
CREATE SEQUENCE workgroup_id_gen INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE;