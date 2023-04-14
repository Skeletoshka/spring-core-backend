SELECT p.*,
       cc.capclass_name
FROM   people p
       INNER JOIN capclass cc ON p.capclass_id = cc.capclass_id
WHERE  p.people_id = :id