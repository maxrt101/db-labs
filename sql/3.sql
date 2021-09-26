
select distinct maker
  from Laptop as l
  join Product as p on l.model = p.model
  where speed <= 500;

