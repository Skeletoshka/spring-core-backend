SELECT m0.*,
       DIR.direction_name
FROM   workgroup m0
       INNER JOIN direction DIR ON m0.direction_id = DIR.direction_id
       /*FROM_PLACEHOLDER*/
WHERE  1=1
  /*WHERE_PLACEHOLDER*/
  /*DIRECTION_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/
/*LIMIT_PLACEHOLDER*/