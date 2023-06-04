SELECT m0.*,
       cc.capclass_name,
       s.student_id,
       s.student_class,
       s.student_mun,
       s.contract_id
FROM   people m0
       INNER JOIN capclass cc ON m0.capclass_id = cc.capclass_id
       LEFT JOIN student s ON m0.people_id = s.student_id
WHERE  m0.people_id = :id