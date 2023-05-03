SELECT m0.*,
       sh.schedule_date,
       sp.studyprogram_name,
       p.people_name,
       p.people_lastname,
       p.people_middlename,
       WG.workgroup_name
FROM   attendance m0
       INNER JOIN schedule sh ON m0.schedule_id = sh.schedule_id
       INNER JOIN studyprogram sp ON sh.studyprogram_id = sp.studyprogram_id
       INNER JOIN people p ON m0.people_id = p.people_id
       INNER JOIN workgroup WG ON sh.workgroup_id = WG.workgroup_id
       /*FROM_PLACEHOLDER*/
WHERE  1=1
  /*WHERE_PLACEHOLDER*/
  /*PEOPLE_PLACEHOLDER*/
  /*STUDYPROGRAM_PLACEHOLDER*/
  /*SCHEDULE_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/
/*LIMIT_PLACEHOLDER*/