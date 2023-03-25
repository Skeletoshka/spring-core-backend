SELECT SP.*,
       TR.people_name teacher_name,
       TR.people_secondname teacher_secondname,
       TR.people_middlename teacher_middlename,
       ASS.people_name assistant_name,
       ASS.people_secondname assistant_secondname,
       ASS.people_middlename assistant_middlename
FROM   studyprogram SP
       INNER JOIN people TR ON SP.teacher_id = TR.people_id
       INNER JOIN people ASS ON ASS.teacher_id = TR.people_id
WHERE  1=1
  AND  SP.studyprogram_id = :id
/*WHERE_PLACEHOLDER*/