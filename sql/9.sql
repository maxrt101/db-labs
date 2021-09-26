
select distinct
    p.maker,
    case
      when c.count is not null then concat('yes(', c.count, ')')
      else 'no'
    end as printer
  from Product as p
  left outer join
    (select maker, count(*) as count
      from Printer as p
      join Product as pd on p.model = pd.model
      group by maker) as c on p.maker = c.maker
  order by 1;

