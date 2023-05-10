SELECT m0.*,
       BL.block_id,
       MA.material_id,
       DR.documentreal_id
FROM   appendix m0
	INNER JOIN documentreal DR ON m0.appendix_id = DR.documentreal_id
	LEFT JOIN material MA ON m0.appendix_id = MA.material_id
	LEFT JOIN block BL ON MA.block_id = BL.block_id
WHERE  m0.appendix_id = :id
