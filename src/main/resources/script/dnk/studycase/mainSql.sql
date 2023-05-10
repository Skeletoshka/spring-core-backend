SELECT m0.*,
       SP.studyprogram_name
FROM studycase m0
       INNER JOIN studyprogram SP ON m0.studyprogram_id = SP.studyprogram_id
       /*FROM_PLACEHOLDER*/
WHERE  1=1
  /*STUDYPROGRAM_PLACEHOLDER*/
  /*WHERE_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/
/*LIMIT_PLACEHOLDER*/