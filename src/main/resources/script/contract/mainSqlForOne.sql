SELECT m0.*,
       dr.*
FROM   contract m0
       INNER JOIN documentreal dr ON m0.contract_id = dr.contract_id
WHERE  m0.contract_id = :id