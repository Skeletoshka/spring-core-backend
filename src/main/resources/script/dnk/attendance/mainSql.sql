SELECT DISTINCT p.people_id,
       m0.attendance_presenceflag,
       sh.schedule_date,
       sp.studyprogram_name,
       p.people_name,
       p.people_lastname,
       p.people_middlename,
       WG.workgroup_name
FROM   schedule sh
       INNER JOIN studyprogram sp ON sh.studyprogram_id = sp.studyprogram_id
       INNER JOIN workgroup WG ON sh.workgroup_id = WG.workgroup_id
       INNER JOIN peoplegroup PG ON WG.workgroup_id = PG.workgroup_id
       INNER JOIN people p ON PG.people_id = p.people_id
       LEFT OUTER JOIN attendance m0 ON (sh.schedule_id = m0.schedule_id AND p.people_id = m0.people_id)
       /*FROM_PLACEHOLDER*/
WHERE  1=1
  /*WHERE_PLACEHOLDER*/
  /*PEOPLE_PLACEHOLDER*/
  /*SCHEDULE_PLACEHOLDER*/
  /*WORKGROUP_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/
/*LIMIT_PLACEHOLDER*/