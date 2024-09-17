# Write your MySQL query statement below
select e.name, b.bonus
from Employee e
left join Bonus b ON e.empId=b.empId
Where b.bonus < 1000 OR b.bonus IS NULL;