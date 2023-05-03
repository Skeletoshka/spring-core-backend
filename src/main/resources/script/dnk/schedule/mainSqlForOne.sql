SELECT m0.*,
       sp.studyprogram_name,
       wg.workgroup_name
FROM   schedule m0
           INNER JOIN studyprogram sp ON m0.studyprogram_id = sp.studyprogram_id
           INNER JOIN workgroup wg ON m0.workgroup_id = wg.workgroup_id
WHERE  m0.schedule_id = :id