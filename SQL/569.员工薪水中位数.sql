drop database if exists leetcode ;
create database if not exists leetcode;

use leetcode;

Create table If Not Exists Employee (Id int, Company varchar(255), Salary int);
Truncate table Employee;
insert into Employee (Id, Company, Salary) values ('1', 'A', '2341');
insert into Employee (Id, Company, Salary) values ('2', 'A', '341');
insert into Employee (Id, Company, Salary) values ('3', 'A', '15');
insert into Employee (Id, Company, Salary) values ('4', 'A', '15314');
insert into Employee (Id, Company, Salary) values ('5', 'A', '451');
insert into Employee (Id, Company, Salary) values ('6', 'A', '513');
insert into Employee (Id, Company, Salary) values ('7', 'B', '15');
insert into Employee (Id, Company, Salary) values ('8', 'B', '13');
insert into Employee (Id, Company, Salary) values ('9', 'B', '1154');
insert into Employee (Id, Company, Salary) values ('10', 'B', '1345');
insert into Employee (Id, Company, Salary) values ('11', 'B', '1221');
insert into Employee (Id, Company, Salary) values ('12', 'B', '234');
insert into Employee (Id, Company, Salary) values ('13', 'C', '2345');
insert into Employee (Id, Company, Salary) values ('14', 'C', '2645');
insert into Employee (Id, Company, Salary) values ('15', 'C', '2645');
insert into Employee (Id, Company, Salary) values ('16', 'C', '2652');
insert into Employee (Id, Company, Salary) values ('17', 'C', '65');


select * 
from(
    select e1.Id,e1.Company,count(e1.Id) as rank
    from Employee as e1 left join Employee as e2
    on e1.Company = e2.Company and e1.Salary <= e2.Salary
    group by e1.Company,e1.ID
    order by e1.Company asc,rank desc
)t3 
left join 
(
    select Id,e1.Company,t1.cnt
    from Employee as e1 left join (
        select Company,count(Company) as cnt
        from Employee
        group by Company
    )t1
    on e1.Company=t1.Company
)t2
on t3.Id = t2.Id
-- where ABS((t2.cnt-1)/2 - t3.rank) < 0.6


-- select e1.ID,e1.Company,count(e1.Id)
-- from Employee as e1 left join Employee as e2
-- on e1.Company = e2.Company and e1.Salary <= e2.Salary
-- group by e1.Company,e1.ID
-- having ABS((count(distinct e1.Id)-1)/2 - count(e2.Id)) < 0.6

/* select count()
(
    select e1.Company,count(e1.Id)
    from Employee as e1 left join Employee as e2
    on e1.Company = e2.Company and e1.Salary <= e2.Salary
    group by e1.Company,e1.ID
)t 
group by t.Company */

-- select Id,count()


