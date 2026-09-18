WITH half_year AS (
    SELECT
        driver_id,
        CASE
            WHEN MONTH(trip_date) <= 6 THEN 1
            ELSE 2
        END AS half,
        AVG(distance_km / fuel_consumed) AS half_avg
    FROM trips
    GROUP BY
        driver_id,
        CASE
            WHEN MONTH(trip_date) <= 6 THEN 1
            ELSE 2
        END
)

SELECT
    h1.driver_id,
    d.driver_name,
    ROUND(h1.half_avg, 2) AS first_half_avg,
    ROUND(h2.half_avg, 2) AS second_half_avg,
    ROUND(h2.half_avg - h1.half_avg, 2) AS efficiency_improvement
FROM half_year h1
JOIN half_year h2
    ON h1.driver_id = h2.driver_id
    AND h1.half = 1
    AND h2.half = 2
    AND h2.half_avg > h1.half_avg
JOIN drivers d
    ON h1.driver_id = d.driver_id
ORDER BY
    efficiency_improvement DESC,
    d.driver_name ASC;