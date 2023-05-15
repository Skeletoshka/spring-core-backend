SELECT m0.*,
       p.people_name,
       p.people_lastname,
       p.people_middlename
FROM   proguser m0
       LEFT JOIN people p ON m0.people_id = p.people_id
       /*FROM_PLACEHOLDER*/
WHERE  1=1
  /*WHERE_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/
/*LIMIT_PLACEHOLDER*/