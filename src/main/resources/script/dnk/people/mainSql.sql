SELECT DISTINCT m0.*,
       cc.capclass_name,
       c.company_name,
       par.people_name as parent_name,
       par.people_lastname as parent_lastname,
       par.people_middlename as parent_middlename
FROM   people m0
       INNER JOIN capclass cc ON m0.capclass_id = cc.capclass_id
       LEFT JOIN peoplegroup pg ON m0.people_id = pg.people_id
       LEFT JOIN company c ON m0.company_id = c.company_id
       LEFT JOIN family f ON m0.people_id = f.child_id
       LEFT JOIN people par ON f.parent_id = par.people_id
       /*FROM_PLACEHOLDER*/
WHERE  1=1
  /*CAPCLASS_PLACEHOLDER*/
  /*WORKGROUP_PLACEHOLDER*/
  /*WHERE_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/
/*LIMIT_PLACEHOLDER*/