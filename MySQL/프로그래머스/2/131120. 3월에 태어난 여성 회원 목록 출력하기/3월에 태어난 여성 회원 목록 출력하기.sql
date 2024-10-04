-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME, GENDER, date_format(DATE_OF_BIRTH,'%Y-%m-%d') as DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE GENDER = 'W'
AND month(DATE_OF_BIRTH) = 3
AND TLNO IS NOT NULL
ORDER BY MEMBER_ID;