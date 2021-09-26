
select distinct maker 
  from Laptop as l
  join Product as p on l.model = p.model
  where speed <= 500 
  and maker = any (select maker from Product where type = 'PC');

