CREATE TABLE studyprogram (
    studyprogram_id INTEGER NOT NULL,
    studyprogram_name VARCHAR(100) NOT NULL,
    direction_id INTEGER NOT NULL,
    teacher_id INTEGER NOT NULL,
    assistant_id INTEGER,
    CONSTRAINT studyprogram_pk PRIMARY KEY (studyprogram_id),
    CONSTRAINT studyprogram_un UNIQUE (studyprogram_name)
);
