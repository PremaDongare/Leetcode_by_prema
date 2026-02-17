# using join and subquery
select d.name as Department, e.name as Employee, e.salary as Salary
from employee e
join Department d
on e.departmentId = d.id
# subquery
where e.salary=(
    select max(e2.salary)
    from Employee e2
    where e2.departmentId = e.departmentId
)

