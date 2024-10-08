# Write your MySQL query statement below

Select a.name as Employee from Employee a
JOIN Employee b
ON a.managerId = b.id
WHERE a.salary > b.salary
