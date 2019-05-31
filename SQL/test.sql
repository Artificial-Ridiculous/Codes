use test;

select sum(case when id <10 then 1 else 0 end) from a;