SELECT m0.*,
       a.address_litera,
       a.address_house,
       a.address_corpus,
       t.town_name,
       s.street_name,
       cc.capclass_name,
       c.company_name
FROM   activity m0
       LEFT JOIN address a on m0.address_id = a.address_id
       LEFT JOIN town t on a.town_id = t.town_id
       LEFT JOIN street s on a.street_id = s.street_id
       INNER JOIN capclass cc on m0.capclass_id = cc.capclass_id
       LEFT JOIN company c on a.address_id = c.address_id
WHERE  m0.activity_id = :id