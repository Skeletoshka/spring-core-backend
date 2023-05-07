SELECT m0.*,
       cc.capclass_name
FROM   people m0
       INNER JOIN capclass cc ON m0.capclass_id = cc.capclass_id
       LEFT JOIN peoplegroup pg ON m0.people_id = pg.people_id
       /*FROM_PLACEHOLDER*/
WHERE  1=1
  /*CAPCLASS_PLACEHOLDER*/
  /*WORKGROUP_PLACEHOLDER*/
  /*WHERE_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/
/*LIMIT_PLACEHOLDER*/