
select avg(a.price) from (
  select avg(price) as price
    from Laptop as l
    join Product as p on p.model = l.model
    where maker = 'A'
  union
  select avg(price) as price
    from PC as pc
    join Product as p on p.model = pc.model
    where maker = 'A') as a;

