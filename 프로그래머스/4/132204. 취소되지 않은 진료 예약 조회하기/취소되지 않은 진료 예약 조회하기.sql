-- 코드를 입력하세요
SELECT
  s.APNT_NO,
  s.PT_NAME,
  s.PT_NO,
  s.MCDP_CD,
  d.DR_NAME,
  s.APNT_YMD
FROM DOCTOR AS d 
INNER JOIN (
    SELECT 
       a.APNT_NO,
       p.PT_NAME,
       p.PT_NO,
       a.MCDP_CD,
       a.MDDR_ID,
       a.APNT_YMD
    FROM PATIENT AS p 
    INNER JOIN APPOINTMENT AS a
      ON p.PT_NO = a.PT_NO
    WHERE DATE(a.APNT_YMD) = '2022-04-13'
      AND a.APNT_CNCL_YN = 'N'
) AS s
  ON d.DR_ID = s.MDDR_ID
WHERE s.MCDP_CD = 'CS'
ORDER BY s.APNT_YMD	ASC;
