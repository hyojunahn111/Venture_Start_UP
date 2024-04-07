SELECT DISTINCT c.category_code, c.category_name
  FROM tbl_category c
 WHERE c.category_code IS NOT NULL
 ORDER BY c.category_name DESC;
 
 
 SELECT m.menu_name, m.menu_price
   FROM tbl_menu m
  WHERE m.menu_price >= 20000 AND m.menu_price <= 30000 AND m.menu_name LIKE '%밥%';
  
  
SELECT *
  FROM tbl_menu m
 WHERE m.menu_price < 10000 OR m.menu_name LIKE '%김치%'
ORDER BY m.menu_price ASC, m.menu_name DESC;
  
 
SELECT *
  FROM tbl_menu m
 WHERE m.menu_price = 13000 AND m.category_code IN
 ( SELECT c.category_code
	 FROM tbl_category c
	WHERE c.category_name NOT IN ('기타', '쥬스', '커피')
    )
    AND m.orderable_status NOT LIKE '%N%';
 -- ORDER BY c.category_name DESC;
 
 -- 서브쿼리
 SELECT c.category_code
   FROM tbl_category c
  WHERE c.category_name NOT IN ('기타', '쥬스', '커피');
  
SELECT *
  FROM tbl_category;
  

  
SELECT e.EMP_ID, e.EMP_NAME, e.PHONE, e.ENT_DATE, e.ENT_YN
  FROM employee e
 WHERE e.PHONE LIKE '%2'
ORDER BY HIRE_DATE DESC
LIMIT 3;
  
SELECT *
  FROM employee;
  
  
SELECT e.EMP_ID, e.EMP_NAME, e.JOB_CODE, e.SALARY, e.PHONE, e.HIRE_DATE, e.EMAIL
  FROM employee e
 WHERE e.JOB_CODE = 'J5'
 ORDER BY e.SALARY DESC;
 
SELECT *
  FROM employee;
  
SELECT *
  FROM department;

SELECT d.DEPT_TITLE, COUNT(*) AS '부서별인원', SUM(SALARY), AVG(SALARY)
  FROM employee e, department d
 WHERE e.DEPT_CODE = d.DEPT_ID
GROUP BY e.DEPT_CODE;
-- WITH ROLLUP;

SELECT e.EMP_NAME, e.EMP_NO, e.PHONE, d.DEPT_TITLE, j.JOB_NAME
  FROM employee e, department d, job j
WHERE e.DEPT_CODE = d.DEPT_ID AND e.JOB_CODE = j.JOB_CODE
ORDER BY e.HIRE_DATE ASC;

 
  
SELECT *
FROM job;

SELECT e.EMP_NAME, e.EMP_ID, e.MANAGER_ID
  FROM employee e
 WHERE e.MANAGER_ID IS NOT NULL;

SELECT count(*) AS '관리자가 있는 직원 총 수'
  FROM employee e
 WHERE e.MANAGER_ID IS NOT NULL AND EXISTS(SELECT * FROM employee b WHERE e.MANAGER_ID = b.EMP_ID);
 
 SELECT e.EMP_NAME, b.EMP_NAME
   FROM employee e, employee b
  WHERE e.EMP_ID = b.MANAGER_ID;

 SELECT e.EMP_NAME, b.EMP_NAME
   FROM employee e 
   LEFT JOIN employee b ON e.MANAGER_ID = b.EMP_ID; 

   
 SELECT e.EMP_NAME, b.EMP_NAME, d.DEPT_TITLE, de.DEPT_TITLE
   FROM employee e, employee b, department d, department de
  WHERE e.EMP_ID = b.MANAGER_ID AND d.DEPT_ID = e.DEPT_CODE AND b.DEPT_CODE = de.DEPT_ID;

 SELECT d.DEPT_TITLE, SUM(e.SALARY) AS total_salary
   FROM employee e, department d
  WHERE e.DEPT_CODE = d.DEPT_ID
GROUP BY d.DEPT_TITLE
ORDER BY total_salary DESC
LIMIT 1;

SELECT d.DEPT_TITLE, SUM(e.SALARY) AS total_salary
FROM employee e
JOIN department d ON e.DEPT_CODE = d.DEPT_ID
GROUP BY d.DEPT_TITLE
ORDER BY total_salary DESC
LIMIT 1;


 SELECT e.EMP_NAME, e.MANAGER_ID, d.DEPT_TITLE
   FROM employee e, department d
  WHERE e.DEPT_CODE = d.DEPT_ID;
  
  
# 서브쿼리를 이용하여 영업부인 직원들의 사원번호, 직원명, 부서코드, 급여를 출력하세요.
#참고. 영업부인 직원은 부서명에 ‘영업’이 포함된 직원임

SELECT e.EMP_ID, e.EMP_NAME, e.DEPT_CODE, e.SALARY
FROM employee e
WHERE e.DEPT_CODE IN (
  SELECT d.DEPT_ID
  FROM department d
  WHERE d.DEPT_TITLE LIKE '%영업%'
);

SELECT *
FROM department;

# 서브쿼리와 JOIN을 이용하여 영업부인 직원들의 사원번호, 직원명, 부서명, 급여를 출력하세요.
SELECT e.EMP_ID, e.EMP_NAME, d.DEPT_TITLE, e.SALARY
FROM employee e
JOIN (
  SELECT d.DEPT_ID, d.DEPT_TITLE
  FROM department d
  WHERE DEPT_TITLE LIKE '%영업%'
) d ON e.DEPT_CODE = d.DEPT_ID;

#JOIN을 이용하여 부서의 부서코드, 부서명, 해당 부서가 위치한 지역명, 국가명을 추출하는 쿼리를 작성하세요.
SELECT d.DEPT_ID, d.DEPT_TITLE, l.LOCAL_NAME, n.NATIONAL_NAME
FROM department d, location l, nation n
WHERE d.LOCATION_ID = l.LOCAL_CODE AND l.NATIONAL_CODE = n.NATIONAL_CODE;

#위 1에서 작성한 쿼리를 서브쿼리로 활용하여 모든 직원의 사원번호, 직원명, 급여, 부서명, (부서의) 국가명을 출력하세요.
SELECT e.EMP_ID, e.EMP_NAME, e.SALARY, d.DEPT_TITLE, n.NATIONAL_NAME
FROM employee e, department d, nation n
WHERE EXISTS (
    SELECT 1
    FROM location l
    WHERE e.DEPT_CODE = d.DEPT_ID
    AND d.LOCATION_ID = l.LOCAL_CODE
    AND l.NATIONAL_CODE = n.NATIONAL_CODE
);

SELECT *
FROM employee;

SELECT e.EMP_ID, e.EMP_NAME, e.SALARY, d.DEPT_TITLE, n.NATIONAL_NAME
FROM employee e, department d, nation n;

SELECT e.EMP_ID, e.EMP_NAME, e.SALARY, sub.DEPT_TITLE, sub.NATIONAL_NAME
FROM employee e
JOIN (
  SELECT d.DEPT_ID, d.DEPT_TITLE, l.LOCAL_NAME, n.NATIONAL_NAME
  FROM department d, location l, nation n
  WHERE d.LOCATION_ID = l.LOCAL_CODE AND l.NATIONAL_CODE = n.NATIONAL_CODE
) sub ON e.DEPT_CODE = sub.DEPT_ID;

SELECT e.EMP_ID, e.EMP_NAME, e.SALARY, q.DEPT_TITLE, q.NATIONAL_NAME
FROM employee e
LEFT JOIN (
    SELECT d.DEPT_ID, d.DEPT_TITLE, l.LOCAL_NAME, n.NATIONAL_NAME
    FROM department d, location l, nation n
    WHERE d.LOCATION_ID = l.LOCAL_CODE AND l.NATIONAL_CODE = n.NATIONAL_CODE
) AS q ON e.DEPT_CODE = q.DEPT_ID
ORDER BY q.NATIONAL_NAME DESC;


SELECT e.EMP_ID, e.EMP_NAME, e.SALARY, q.DEPT_TITLE, q.NATIONAL_NAME,(e.SALARY + sg.MIN_SAL) AS 위로금
FROM employee e
LEFT JOIN (
    SELECT d.DEPT_ID, d.DEPT_TITLE, l.LOCAL_NAME, n.NATIONAL_NAME
    FROM department d, location l, nation n
    WHERE d.LOCATION_ID = l.LOCAL_CODE AND l.NATIONAL_CODE = n.NATIONAL_CODE
) AS q ON e.DEPT_CODE = q.DEPT_ID
LEFT JOIN SAL_GRADE sg ON e.SALARY BETWEEN sg.MIN_SAL AND sg.MAX_SAL
WHERE q.NATIONAL_NAME = '러시아'
ORDER BY 위로금 DESC;

SELECT d.DEPT_TITLE AS '부서명', COUNT(*) AS '인원', SUM(e.SALARY) AS '급여합계', AVG(e.SALARY) AS '급여평균'
FROM employee e
JOIN department d ON e.DEPT_CODE = d.DEPT_ID
GROUP BY e.DEPT_CODE

UNION ALL

-- 전체 집계 정보
SELECT 
  '전체' AS '부서명', 
  COUNT(*) AS '인원', 
  SUM(SALARY) AS '급여합계', 
  AVG(SALARY) AS '급여평균'
FROM employee;

SELECT d.DEPT_TITLE AS '부서명', COUNT(*) AS '인원', SUM(e.SALARY) AS '급여합계', AVG(e.SALARY) AS '급여평균'
  FROM employee e
  LEFT JOIN department d ON e.DEPT_CODE = d.DEPT_ID
GROUP BY d.DEPT_TITLE
WITH ROLLUP;


SELECT e.EMP_ID, e.EMP_NAME, e.PHONE, d.DEPT_TITLE, j.JOB_NAME, e.SALARY
  FROM department d, employee e, job j
 WHERE e.JOB_CODE = j.JOB_CODE AND e.DEPT_CODE = d.DEPT_ID AND j.JOB_NAME = '대리'
 UNION ALL
 SELECT e.EMP_ID, e.EMP_NAME, e.PHONE, d.DEPT_TITLE, j.JOB_NAME, e.SALARY
  FROM department d, employee e, job j
 WHERE e.JOB_CODE = j.JOB_CODE AND e.DEPT_CODE = d.DEPT_ID AND j.JOB_NAME = '차장'
 UNION ALL
  SELECT e.EMP_ID, e.EMP_NAME, e.PHONE, d.DEPT_TITLE, j.JOB_NAME, e.SALARY
  FROM department d, employee e, job j
 WHERE e.JOB_CODE = j.JOB_CODE AND e.DEPT_CODE = d.DEPT_ID AND e.SALARY > 2000000 AND e.SALARY < 3000000;
 
