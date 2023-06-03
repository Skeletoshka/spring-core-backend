SELECT m0.*,
       dr.*,
       dt.documenttype_name,
       ax.appendix_name,
       ax.appendix_path
FROM   contract m0
       INNER JOIN documentreal dr ON m0.contract_id = dr.documentreal_id
       INNER JOIN documenttype dt ON dr.documenttype_id = dt.documenttype_id
       INNER JOIN appendix ax ON m0.contract_id = ax.appendix_id
       /*FROM_PLACEHOLDER*/
WHERE  1=1
/*WHERE_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/
/*LIMIT_PLACEHOLDER*/