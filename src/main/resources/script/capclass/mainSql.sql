SELECT cc.*,
       cct.capclasstype_name
FROM   capclass cc
           INNER JOIN capclasstype cct on cc.capclasstype_id = cct.capclasstype_id
WHERE  1=1
  /*CAPCLASSTYPE_PLACEHOLDER*/