SELECT m0.*,
       a.address_house,
       a.address_corpus,
       a.address_litera,
       t.town_id,
       s.street_id
FROM   company m0
       INNER JOIN address a ON m0.address_id = a.address_id
       INNER JOIN town t on t.town_id = a.town_id
       INNER JOIN street s on a.street_id = s.street_id
       /*FROM_PLACEHOLDER*/
WHERE 1=1
  /*WHERE_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/
/*LIMIT_PLACEHOLDER*/