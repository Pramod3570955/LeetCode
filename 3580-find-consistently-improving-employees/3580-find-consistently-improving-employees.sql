WITH ranked_reviews AS (
    SELECT
        employee_id,
        review_date,
        rating,
        ROW_NUMBER() OVER (
            PARTITION BY employee_id
            ORDER BY review_date DESC
        ) AS rn
    FROM performance_reviews
),

latest_three AS (
    SELECT
        employee_id,
        rating,
        rn
    FROM ranked_reviews
    WHERE rn <= 3
),

rating_summary AS (
    SELECT
        employee_id,

        MAX(CASE
            WHEN rn = 1 THEN rating
        END) AS latest_rating,

        MAX(CASE
            WHEN rn = 2 THEN rating
        END) AS middle_rating,

        MAX(CASE
            WHEN rn = 3 THEN rating
        END) AS earliest_rating,

        COUNT(*) AS review_count

    FROM latest_three
    GROUP BY employee_id
)

SELECT
    e.employee_id,
    e.name,
    r.latest_rating - r.earliest_rating AS improvement_score
FROM rating_summary r
JOIN employees e
    ON e.employee_id = r.employee_id
WHERE r.review_count = 3
  AND r.earliest_rating < r.middle_rating
  AND r.middle_rating < r.latest_rating
ORDER BY
    improvement_score DESC,
    e.name ASC;