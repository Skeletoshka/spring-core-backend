CREATE TABLE address (
    address_id INTEGER NOT NULL,
    town_id INTEGER NOT NULL,
    street_id INTEGER NOT NULL,
    address_house VARCHAR(10) NOT NULL,
    address_litera VARCHAR(10) NULL,
    address_corpus VARCHAR(10) NULL,
    CONSTRAINT address_pk PRIMARY KEY (address_id),
    CONSTRAINT address_un UNIQUE (town_id, street_id, address_house, address_litera, address_corpus)
);

INSERT INTO address VALUES (1, 1, 1, 1, null, null), (2, 1, 1, 2, null, null), (3, 1, 1, 3, null, null), (4, 1, 1, 4, null, null),
                           (5, 1, 2, 1, null, null), (6, 1, 2, 2, null, null), (7, 1, 2, 3, null, null), (8, 1, 2, 4, null, null),
                           (9, 1, 3, 1, null, null), (10, 1, 3, 2, null, null), (11, 1, 3, 3, null, null), (12, 1, 3, 4, null, null),
                           (13, 1, 4, 1, null, null), (14, 1, 4, 2, null, null), (15, 1, 4, 3, null, null), (16, 1, 4, 4, null, null);

CREATE TABLE street (
    street_id INTEGER NOT NULL,
    street_name VARCHAR(255) NOT NULL,
    CONSTRAINT street_pk PRIMARY KEY (street_id),
    CONSTRAINT street_un UNIQUE (street_name)
);

INSERT INTO street VALUES (1, 'Ветлужская'), (2, 'Красноводская'), (3, 'Попова'), (4, 'Шоссе космонавтов');

CREATE TABLE town (
    town_id INTEGER NOT NULL,
    town_name VARCHAR(255) NOT NULL,
    capclass_id INTEGER NOT NULL,
    CONSTRAINT town_pk PRIMARY KEY (town_id),
    CONSTRAINT town_un UNIQUE (town_name)
);

INSERT INTO town VALUES (1, 'Пермь', 1);

CREATE OR REPLACE VIEW address_ft AS
SELECT a.address_id, CONCAT(t.town_name, ' ', s.street_name, ' ', a.address_house, ' ', a.address_litera, ' ', a.address_corpus) as fulltext
FROM   address a
       INNER JOIN street s ON a.street_id = s.street_id
       INNER JOIN town t ON a.town_id = t.town_id ;