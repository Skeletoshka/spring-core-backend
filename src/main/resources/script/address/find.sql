SELECT a.*,
       t.town_name,
       s.street_name
FROM   address a
       INNER JOIN street s ON a.street_id = s.street_id
       INNER JOIN town t ON a.town_id = t.town_id
       INNER JOIN address_ft ft ON a.address_id = ft.address_id
WHERE  ft.fulltext LIKE '%' || :search || '%'