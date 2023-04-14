SELECT p.*,
       cc.capclass_name
FROM   people p
       INNER JOIN capclass cc ON p.capclass_id = cc.capclass_id
WHERE  1=1
  /*CAPCLASS_PLACEHOLDER*/