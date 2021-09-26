
select distinct maker
  from Product
  where maker = any (select maker from Product where type = 'PC' or type = 'Laptop');

