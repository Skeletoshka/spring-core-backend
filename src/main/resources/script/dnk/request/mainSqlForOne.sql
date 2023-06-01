SELECT m0.*,
       dr.*,
       dt.documenttransit_color,
       dt.documenttransit_name,
       pu.proguser_name,
       s.service_name
FROM   request m0
           INNER JOIN documentreal dr on dr.documentreal_id = m0.request_id
           LEFT JOIN documenttransit dt on dt.documenttransit_id = dr.documenttransit_id
           INNER JOIN proguser pu on pu.proguser_id = dr.proguser_id
           INNER JOIN service s ON m0.service_id = s.service_id
WHERE  m0.request_id = :id
