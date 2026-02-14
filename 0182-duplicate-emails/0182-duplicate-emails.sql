# Write your MySQL query statement below
select distinct e.email As Email
from Person  e
join Person p
where e.email= p.email and e.id != p.id;

