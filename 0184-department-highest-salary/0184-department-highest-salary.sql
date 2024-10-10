# Write your MySQL query statement below

SELECT  d.name as Department , e.name as Employee , e.salary as Salary 
from Employee e JOIN Department d
ON e.departmentId = d.id
where e.salary = ( select max(salary) from Employee where departmentId = d.id ) 


