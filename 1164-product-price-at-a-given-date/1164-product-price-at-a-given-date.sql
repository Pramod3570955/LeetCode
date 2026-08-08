SELECT
    p.product_id,
    COALESCE(price.new_price, 10) AS price
FROM (SELECT DISTINCT product_id FROM Products) p
LEFT JOIN (
    SELECT
        product_id,
        MAX(change_date) AS change_date
    FROM Products
    WHERE change_date <= '2019-08-16'
    GROUP BY product_id
) latest
ON p.product_id = latest.product_id
LEFT JOIN Products price
ON price.product_id = latest.product_id
AND price.change_date = latest.change_date;