SELECT m0.*,
       cct.capclasstype_name
FROM   capclass m0
       INNER JOIN capclasstype cct on m0.capclasstype_id = cct.capclasstype_id
       /*FROM_PLACEHOLDER*/
WHERE  1=1
  /*CAPCLASSTYPE_PLACEHOLDER*/
  /*WHERE_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/
/*LIMIT_PLACEHOLDER*/