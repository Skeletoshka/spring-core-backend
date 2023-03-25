SELECT SP.*,
       TR.people_name teacher_name,
       TR.people_secondname teacher_secondname,
       TR.people_middlename teacher_middlename,
       ASS.people_name assistant_name,
       ASS.people_secondname assistant_secondname,
       ASS.people_middlename assistant_middlename,
       DR.documentreal_name,
       DR.documentreal_number
FROM   studyprogram SP
       INNER JOIN people TR ON SP.teacher_id = TR.people_id
       LEFT JOIN people ASS ON SP.assistant_id = ASS.people_id
       INNER JOIN documentreal DR ON SP.studyprogram_id = DR.documentreal_id
WHERE  1=1
/*WHERE_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/