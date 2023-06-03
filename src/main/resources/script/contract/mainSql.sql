SELECT m0.*,
       dr.*,
       dt.documenttype_name
FROM   contract m0
       INNER JOIN documentreal dr ON m0.contract_id = dr.documentreal_id
       INNER JOIN documenttype dt ON dr.documenttype_id = dt.documenttype_id
       /*FROM_PLACEHOLDER*/
WHERE  1=1
/*WHERE_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/
/*LIMIT_PLACEHOLDER*/