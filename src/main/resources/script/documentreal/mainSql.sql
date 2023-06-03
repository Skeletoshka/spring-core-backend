SELECT m0.*,
       dt.documenttype_name,
       pu.proguser_name
FROM   documentreal m0
       INNER JOIN documenttype dt ON m0.documenttype_id = dt.documenttype_id
       INNER JOIN proguser pu ON m0.proguser_id = pu.proguser_id
       /*FROM_PLACEHOLDER*/
WHERE  1=1
/*DOCUMENTTYPE_PLACEHOLDER*/
/*WHERE_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/
/*LIMIT_PLACEHOLDER*/