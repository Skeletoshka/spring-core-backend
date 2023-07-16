SELECT m0.*,
       cc.capclass_name,
       c.company_name,
       dir.direction_name
FROM   activity m0
       INNER JOIN capclass cc on m0.capclass_id = cc.capclass_id
       LEFT JOIN company c on m0.company_id = c.company_id
       INNER JOIN direction dir ON m0.direction_id = dir.direction_id
       /*FROM_PLACEHOLDER*/
WHERE  1=1
  /*WHERE_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/
/*LIMIT_PLACEHOLDER*/