SELECT m0.*,
       DR.*,
       dt.documenttype_name
FROM   appendix m0
	   INNER JOIN documentreal DR ON m0.appendix_id = DR.documentreal_id
	   INNER JOIN documenttype dt ON dr.documenttype_id = dt.documenttype_id
WHERE  m0.appendix_id = :id
