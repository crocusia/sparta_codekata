-- 코드를 입력하세요
SELECT
  ao.ANIMAL_ID,
  ao.ANIMAL_TYPE,
  ao.NAME
FROM ANIMAL_INS AS ai
INNER JOIN ANIMAL_OUTS AS ao
  ON ai.ANIMAL_ID = ao.ANIMAL_ID
WHERE ai.SEX_UPON_INTAKE LIKE '%Intact%'
  AND ai.SEX_UPON_INTAKE != ao.SEX_UPON_OUTCOME;