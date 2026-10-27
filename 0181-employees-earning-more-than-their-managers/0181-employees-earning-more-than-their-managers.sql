# Write your MySQL query statement below
SELECT Worker.name AS Employee FROM 
Employee AS Worker JOIN Employee AS Manager ON Worker.managerId = Manager.id 
WHERE Worker.salary > Manager.salary