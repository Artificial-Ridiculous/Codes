use test;
select if (
(select count(*) from a) = 1
,
(select num
from my_numbers
group by num
having count(num)=1
order by num desc
limit 1) as a
,
null
) 

as num