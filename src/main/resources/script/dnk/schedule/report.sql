SELECT m0.attendance_id,
	   p.people_name ,
	   p.people_lastname ,
	   p.people_middlename ,
	   m0.attendance_presenceflag ,
	   sp.studyprogram_name,
	   wg.workgroup_name ,
	   s.schedule_date ,
	   t.people_name AS teacher_name,
	   t.people_lastname AS teacher_lastname,
	   t.people_middlename AS teacher_middlename
FROM   attendance m0
	   INNER JOIN people p ON m0.people_id = p.people_id
	   INNER JOIN schedule s ON m0.schedule_id = s.schedule_id
	   INNER JOIN studyprogram sp ON s.studyprogram_id = sp.studyprogram_id
	   INNER JOIN workgroup wg ON s.workgroup_id = wg.workgroup_id
	   INNER JOIN people t ON sp.teacher_id = t.people_id
	   /*FROM_PLACEHOLDER*/
WHERE  1=1
/*WHERE_PLACEHOLDER*/
/*STUDYPROGRAM_PLACEHOLDER*/
/*WORKGROUP_PLACEHOLDER*/
/*DATERANGE_PLACEHOLDER*/
/*STUDENT_PLACEHOLDER*/
/*TEACHER_PLACEHOLDER*/
/*ORDERBY_PLACEHOLDER*/
/*LIMIT_PLACEHOLDER*/
