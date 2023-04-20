SELECT m0.*,
       cc.capclass_name
FROM   people m0
       INNER JOIN capclass cc ON m0.capclass_id = cc.capclass_id
       /*FROM_PLACEHOLDER*/
WHERE  1=1
  /*CAPCLASS_PLACEHOLDER*/
  /*WHERE_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/
/*LIMIT_PLACEHOLDER*/