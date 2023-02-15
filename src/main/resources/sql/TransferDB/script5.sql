CREATE TABLE studyprogram (
 studyprogram_id INTEGER NOT NULL,
 studyprogram_name varchar(100) NOT NULL,
 direction_id int4 NOT NULL,
 teacher_id int4 NOT NULL,
 assistant_id int4 NULL,
 CONSTRAINT studyprogram_pk PRIMARY KEY (studyprogram_id),
 CONSTRAINT studyprogram_un UNIQUE (studyprogram_name)
);

CREATE TABLE block (
 block_id INTEGER NOT NULL,
 block_name varchar(100) NOT NULL,
 studyprogram_id INTEGER NOT NULL,
 block_num INTEGER NOT NULL,
 block_visible INTEGER NOT NULL,
 capclass_id INTEGER NOT NULL,
 CONSTRAINT block_pk PRIMARY KEY (block_id),
 CONSTRAINT block_un UNIQUE (studyprogram_id, capclass_id),
 CONSTRAINT block_fk FOREIGN KEY (studyprogram_id) REFERENCES studyprogram(studyprogram_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE appendix (
 appendix_id INTEGER NOT NULL,
 appendix_name varchar(100) NOT NULL,
 appendix_path varchar(100) NOT NULL,
 block_id int4 NOT NULL,
 people_id int4 NOT NULL,
 CONSTRAINT appendix_pk PRIMARY KEY (appendix_id),
 CONSTRAINT appendix_un UNIQUE (block_id),
 CONSTRAINT appendix_fk FOREIGN KEY (block_id) REFERENCES block(block_id) ON DELETE CASCADE ON UPDATE CASCADE
);

