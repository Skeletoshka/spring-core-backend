SELECT m0.*,
       sh.shedule_date,
       sp.sturyprogram_name,
       p.people_name,
       p.people_lastname,
       p.people_middlename
FROM   attendance m0
       INNER JOIN shedule sh ON m0.shedule_id = sh.shedule_id
       INNER JOIN studyprogram sp ON sh.studyprogram_id = sp.studyprogram_id
       INNER JOIN people p ON m0.people_id = p.people_id
       /*FROM_PLACEHOLDER*/
WHERE  1=1
  /*WHERE_PLACEHOLDER*/
  /*PEOPLE_PLACEHOLDER*/
  /*STUDYPROGRAM_PLACEHOLDER*/
  /*SCHEDULE_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/
/*LIMIT_PLACEHOLDER*/