SELECT m0.*,
       a.address_litera,
       a.address_house,
       a.address_corpus,
       t.town_name,
       s.street_name,
       cc.capclass_name,
       c.company_name
FROM   activity m0
       INNER JOIN address a on m0.address_id = a.address_id
       INNER JOIN town t on a.town_id = t.town_id
       INNER JOIN street s on a.street_id = s.street_id
       INNER JOIN capclass cc on m0.capclass_id = cc.capclass_id
       INNER JOIN company c on a.address_id = c.address_id
       /*FROM_PLACEHOLDER*/
WHERE  1=1
  /*WHERE_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/
/*LIMIT_PLACEHOLDER*/