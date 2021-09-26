
select * from
  (select distinct
      b.name,
      country,
      count(s.name) as scount
    from ships as s
    join Outcomes as o on o.ship = s.name
    join Battles as b on b.name = o.battle
    join Classes as c on c.class = s.class
    group by battle, country) as b
  where b.scount >= 2;

