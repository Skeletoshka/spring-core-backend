SELECT m0.*,
       dt.documenttype_name,
       pu.proguser_name
FROM   documentreal m0
       INNER JOIN documenttype dt ON m0.documenttype_id = dt.documenttype_id
       INNER JOIN proguser pu ON m0.proguser_id = pu.proguser_id
WHERE  m0.documentreal_id = :id
