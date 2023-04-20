SELECT m0.*,
       TR.people_name teacher_name,
       TR.people_lastname teacher_lastname,
       TR.people_middlename teacher_middlename,
       ASS.people_name assistant_name,
       ASS.people_lastname assistant_lastname,
       ASS.people_middlename assistant_middlename,
       DR.documentreal_name,
       DR.documentreal_number,
       DN.direction_name
FROM   studyprogram m0
       INNER JOIN people TR ON m0.teacher_id = TR.people_id
       LEFT JOIN people ASS ON m0.assistant_id = ASS.people_id
       INNER JOIN documentreal DR ON m0.studyprogram_id = DR.documentreal_id
       INNER JOIN direction DN ON m0.direction_id = DN.direction_id
       /*FROM_PLACEHOLDER*/
WHERE  1=1
  /*DIRECTION_PLACEHOLDER*/
  /*TEACHER_PLACEHOLDER*/
  /*ASSISTANT_PLACEHOLDER*/
  /*WHERE_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/
/*LIMIT_PLACEHOLDER*/