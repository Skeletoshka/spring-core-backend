SELECT DISTINCT m0.* ,
       ROW_NUMBER() OVER() row_id,
       WG.workgroup_name ,
       ST.student_class ,
       ST.student_mun ,
       CON.contract_date ,
       DR.documentreal_number ,
       DR.documentreal_datecreate,
       CP.company_name ,
       P.people_id AS parent_id,
       P.people_name AS parent_name,
       P.people_lastname AS parent_lastname,
       P.people_middlename AS parent_middlename,
       P.people_phone AS parent_phone,
       P.people_email AS parent_email,
       TT.studyprogram_name,
       TT.studyprogram_id
FROM   people m0
	   INNER JOIN peoplegroup PG ON m0.people_id = PG.people_id
	   INNER JOIN workgroup WG ON PG.workgroup_id = WG.workgroup_id
	   INNER JOIN student ST ON m0.people_id = ST.student_id
	   INNER JOIN contract CON ON ST.contract_id = CON.contract_id
	   INNER JOIN documentreal DR ON CON.contract_id = DR.documentreal_id
	   INNER JOIN company CP ON m0.company_id = CP.company_id
	   INNER JOIN "family" F ON m0.people_id = F.child_id
	   INNER JOIN people P ON F.parent_id = P.people_id
	   INNER JOIN (
	   		SELECT DISTINCT SP.*,
	   			   SC.workgroup_id
	   		FROM   studyprogram SP
	   			   INNER JOIN schedule SC ON SC.studyprogram_id = SP.studyprogram_id
	   ) TT ON WG.workgroup_id = TT.workgroup_id
	   /*FROM_PLACEHOLDER*/
WHERE  1=1
/*WHERE_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/
/*LIMIT_PLACEHOLDER*/