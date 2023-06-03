SELECT m0.*,
       a.address_house,
       a.address_corpus,
       a.address_litera,
       t.town_id,
       s.street_id
FROM   company m0
WHERE  m0.company_id = :id