SELECT m0.*,
       cc.capclass_name
FROM   people m0
       INNER JOIN capclass cc ON m0.capclass_id = cc.capclass_id
WHERE  m0.people_id = :id