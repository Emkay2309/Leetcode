# Write your MySQL query statement below

SELECT name as Customers from Customers 
WHERE id NOT IN (SELECT customerId from Orders)