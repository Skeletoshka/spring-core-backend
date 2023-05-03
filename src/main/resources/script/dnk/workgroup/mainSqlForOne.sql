SELECT m0.*,
       DIR.direction_name
FROM   workgroup m0
       INNER JOIN direction DIR ON m0.direction_id = DIR.direction_id
WHERE  workgroup_id = :id