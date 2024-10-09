# Write your MySQL query statement below

SELECT name as Customers from Customers c 
LEFT JOIN Orders o 
ON c.id = o.customerId
WHERE o.customerId is NULL