-- 코드를 입력하세요
SELECT
  info.INGREDIENT_TYPE,
  SUM(fh.TOTAL_ORDER)  
FROM FIRST_HALF AS fh
INNER JOIN ICECREAM_INFO AS info
  ON fh.FLAVOR = info.FLAVOR
GROUP BY INGREDIENT_TYPE
ORDER BY SUM(fh.TOTAL_ORDER) ASC; 

  
