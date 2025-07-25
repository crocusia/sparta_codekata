-- 코드를 입력하세요
SELECT
  a.AUTHOR_ID,
  a.AUTHOR_NAME,
  b.CATEGORY,
  SUM(bs.SALES * b.PRICE) AS TOTAL_SALES
FROM BOOK_SALES AS bs
JOIN BOOK AS b ON b.BOOK_ID = bs.BOOK_ID
JOIN AUTHOR AS a ON a.AUTHOR_ID = b.AUTHOR_ID
WHERE bs.SALES_DATE BETWEEN '2022-01-01' AND '2022-01-31'
GROUP BY a.AUTHOR_ID, b.CATEGORY
ORDER BY a.AUTHOR_ID ASC, b.CATEGORY DESC;