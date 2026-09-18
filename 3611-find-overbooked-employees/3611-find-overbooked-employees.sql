WITH weekly_hours AS (
    SELECT
        employee_id,

        DATE_SUB(
            meeting_date,
            INTERVAL WEEKDAY(meeting_date) DAY
        ) AS week_start,

        SUM(duration_hours) AS total_hours

    FROM meetings

    GROUP BY
        employee_id,
        DATE_SUB(
            meeting_date,
            INTERVAL WEEKDAY(meeting_date) DAY
        )
),

heavy_weeks AS (
    SELECT
        employee_id,
        COUNT(*) AS meeting_heavy_weeks
    FROM weekly_hours
    WHERE total_hours > 20
    GROUP BY employee_id
    HAVING COUNT(*) >= 2
)

SELECT
    e.employee_id,
    e.employee_name,
    e.department,
    h.meeting_heavy_weeks
FROM employees e
JOIN heavy_weeks h
    ON e.employee_id = h.employee_id
ORDER BY
    h.meeting_heavy_weeks DESC,
    e.employee_name ASC;