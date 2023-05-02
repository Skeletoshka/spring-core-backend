SELECT m0.*,
       sp.studyprogram_name,
       wg.workgroup_name
FROM   schedule m0
       INNER JOIN studyprogram sp ON m0.studyprogram_id = sp.studyprogram_id
       INNER JOIN workgroup wg ON m0.workgroup_id = wg.workroup_id
       /*FROM_PLACEHOLDER*/
WHERE  1=1
  /*WHERE_PLACEHOLDER*/
  /*STUDYPROGRAM_PLACEHOLDER*/
  /*WORKGROUP_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/
/*LIMIT_PLACEHOLDER*/