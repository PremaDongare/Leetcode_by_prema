# By joins and Group by
select d.name as Department, e.name as Employee, e.salary as Salary
from Employee e
join Department d 
on e.departmentId = d.id
join(
    select departmentId, max(salary) As maxsalary
    From Employee
    Group by departmentId
)temp         #store max salary
on e.departmentId = temp.departmentId
And e.salary = temp.maxSalary;

