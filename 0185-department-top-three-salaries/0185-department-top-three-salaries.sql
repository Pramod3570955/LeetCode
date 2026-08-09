# Write your MySQL query statement below
SELECT
    d.name AS Department,
    e1.name AS Employee,
    e1.salary AS Salary
FROM Employee e1
JOIN Department d
    ON e1.departmentId = d.id
LEFT JOIN Employee e2
    ON e1.departmentId = e2.departmentId
    AND e2.salary > e1.salary
GROUP BY
    e1.id,
    e1.name,
    e1.salary,
    d.name
HAVING COUNT(DISTINCT e2.salary) < 3;