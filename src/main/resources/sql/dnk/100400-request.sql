CREATE TABLE request (
    request_id INTEGER NOT NULL,
    request_text VARCHAR(255) NOT NULL,
    service_id INTEGER NOT NULL,
    CONSTRAINT request_pk PRIMARY KEY (request_id)
);