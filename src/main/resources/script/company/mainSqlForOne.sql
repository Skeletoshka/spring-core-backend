SELECT c.*,
       a.address_house,
       a.address_corpus,
       a.address_litera,
       t.town_id,
       s.street_id
FROM   company c
           INNER JOIN address a ON c.address_id = a.address_id
           INNER JOIN town t on t.town_id = a.town_id
           INNER JOIN street s on a.street_id = s.street_id
WHERE  c.company_id = :id