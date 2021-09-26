
select s.name, c.country, c.numGuns
  from Ships as s
  join Classes as c on c.class = s.class
  join Outcomes as o on o.ship = s.name
  join Battles as b on b.name = o.battle
  where o.result = 'damaged';

