SELECT m0.*,
       dr.*,
       dt.documenttransit_color,
       dt.documenttransit_name,
       pu.proguser_name
FROM   news m0
           INNER JOIN documentreal dr on dr.documentreal_id = m0.news_id
           INNER JOIN documenttransit dt on dt.documenttransit_id = dr.documenttransit_id
           INNER JOIN proguser pu on pu.proguser_id = dr.proguser_id
WHERE  m0.news_id = :id
