SELECT m0.*,
       pu.proguser_name,
       dr.documentreal_name,
       con.contract_date
FROM   company m0
       INNER JOIN contract con ON m0.contract_id = con.contract_id
       INNER JOIN proguser pu ON m0.proguser_id = pu.proguser_id
       INNER JOIN documentreal dr ON con.contract_id = dr.documentreal_id
       /*FROM_PLACEHOLDER*/
WHERE 1=1
  /*WHERE_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/
/*LIMIT_PLACEHOLDER*/