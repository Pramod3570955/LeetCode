# Write your MySQL query statement below
WITH current_borrowers AS (
    SELECT
        book_id,
        COUNT(*) AS current_borrowers
    FROM borrowing_records
    WHERE return_date IS NULL
    GROUP BY book_id
)

SELECT
    b.book_id,
    b.title,
    b.author,
    b.genre,
    b.publication_year,
    c.current_borrowers
FROM library_books b
JOIN current_borrowers c
    ON b.book_id = c.book_id
WHERE c.current_borrowers = b.total_copies
ORDER BY
    c.current_borrowers DESC,
    b.title ASC;