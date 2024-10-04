-- 코드를 작성해주세요
WITH size_rank(ID,col_rank)
AS
(
    SELECT ID,PERCENT_RANK() OVER(ORDER BY size_of_colony DESC)
    FROM ecoli_data
)
SELECT ID,
CASE WHEN col_rank <= 0.25 THEN 'CRITICAL'
    WHEN col_rank <= 0.5 THEN 'HIGH'
    WHEN col_rank <= 0.75 THEN 'MEDIUM'
    ELSE 'LOW'
END as COLONY_NAME
FROM size_rank
ORDER BY ID;