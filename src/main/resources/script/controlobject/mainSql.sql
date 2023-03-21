SELECT co.controlobject_id,
       co.controlobject_url,
       co.controlobject_name,
       CASE WHEN cor.controlobject_id IS NOT NULL THEN 1 ELSE 0 END access_flag
FROM   controlobject co
       LEFT JOIN controlobjectrole cor ON co.controlobject_id = cor.controlobject_id
AND :accessRoleId = cor.accessrole_id