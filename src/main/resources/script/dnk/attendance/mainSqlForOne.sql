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
WHERE  m0.attendance_id = :id
