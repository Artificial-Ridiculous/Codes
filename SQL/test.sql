use test;
select if((select count( distinct id) from a) >2 
,
select 8
,
select 9)