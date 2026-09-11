# Write your MySQL query statement below
WITH RECURSIVE employee_hierarchy AS (

    -- CEO / top-level employees
    SELECT
        employee_id,
        employee_name,
        manager_id,
        salary,
        1 AS level
    FROM Employees
    WHERE manager_id IS NULL

    UNION ALL

    -- Find employees under each manager
    SELECT
        e.employee_id,
        e.employee_name,
        e.manager_id,
        e.salary,
        h.level + 1
    FROM Employees e
    JOIN employee_hierarchy h
        ON e.manager_id = h.employee_id
),

subordinates AS (

    -- Direct employees
    SELECT
        employee_id AS manager_id,
        employee_id AS employee_id
    FROM Employees

    UNION ALL

    -- Employees further down the hierarchy
    SELECT
        s.manager_id,
        e.employee_id
    FROM subordinates s
    JOIN Employees e
        ON e.manager_id = s.employee_id
),

team_data AS (
    SELECT
        s.manager_id,
        COUNT(*) - 1 AS team_size,
        SUM(e.salary) AS total_team_salary
    FROM subordinates s
    JOIN Employees e
        ON e.employee_id = s.employee_id
    GROUP BY s.manager_id
)

SELECT
    h.employee_id,
    h.employee_name,
    h.level,
    COALESCE(t.team_size, 0) AS team_size,
    COALESCE(t.total_team_salary, h.salary) AS budget
FROM employee_hierarchy h
LEFT JOIN team_data t
    ON h.employee_id = t.manager_id
ORDER BY
    h.level ASC,
    budget DESC,
    h.employee_name ASC;