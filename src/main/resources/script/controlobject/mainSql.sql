SELECT m0.controlobject_id,
       m0.controlobject_url,
       m0.controlobject_name,
       CASE WHEN cor.controlobject_id IS NOT NULL THEN 1 ELSE 0 END access_flag
FROM   controlobject m0
       LEFT JOIN controlobjectrole cor ON m0.controlobject_id = cor.controlobject_id AND :accessRoleId = cor.accessrole_id
       /*FROM_PLACEHOLDER*/
WHERE 1=1
  /*WHERE_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/
/*LIMIT_PLACEHOLDER*/