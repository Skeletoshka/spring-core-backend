SELECT m0.*,
       DR.documentreal_datecreate,
       DR.documentreal_datemodify,
       p.proguser_name,
       DT.documenttype_name
FROM   appendix m0
	INNER JOIN documentreal DR ON m0.appendix_id = DR.documentreal_id
	INNER JOIN documenttype DT ON DR.documenttype_id = DT.documenttype_id
	INNER JOIN proguser P ON DR.proguser_id = p.proguser_id
       /*FROM_PLACEHOLDER*/
WHERE  1=1
  /*WHERE_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/
/*LIMIT_PLACEHOLDER*/