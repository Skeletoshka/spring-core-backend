SELECT m0.*,
       BL.block_id,
       MA.material_id,
       DR.documentreal_datecreate,
       DR.documentreal_datemodify,
       p.proguser_name,
       DT.documenttype_name
FROM   appendix m0
	INNER JOIN documentreal DR ON m0.appendix_id = DR.documentreal_id
	INNER JOIN documenttype DT ON DR.documenttype_id = DT.documenttype_id
	INNER JOIN proguser P ON DR.proguser_id = p.proguser_id
	LEFT JOIN material MA ON m0.appendix_id = MA.material_id
	LEFT JOIN block BL ON MA.block_id = BL.block_id
       /*FROM_PLACEHOLDER*/
WHERE  1=1
  /*BLOCK_PLACEHOLDER*/
  /*WHERE_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/
/*LIMIT_PLACEHOLDER*/