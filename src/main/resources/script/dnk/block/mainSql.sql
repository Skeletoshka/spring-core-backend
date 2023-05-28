SELECT m0.*,
       SC.studycase_name
FROM   block m0
       INNER JOIN studycase SC ON m0.studycase_id = SC.studycase_id
       /*FROM_PLACEHOLDER*/
WHERE  1=1
  /*STUDYCASE_PLACEHOLDER*/
  /*WHERE_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/
/*LIMIT_PLACEHOLDER*/