# 서브쿼리

-- 서브쿼리1
SELECT category_code
  FROM tbl_menu
 WHERE menu_name LIKE '%민트%';
 
 -- 메인쿼리1
 SELECT menu_code, menu_name, menu_price, category_code, orderable_status
   FROM tbl_menu;
 
   
-- (WHERE절에 서브쿼리 사용)
-- 서브쿼리1을 활용한 메인쿼리1 : 메뉴명이 붕어빵초밥인 메뉴의 카테고리 코드와 동일한 카테고리 코드를 가진 메뉴 출력
SELECT menu_code, menu_name, menu_price, category_code, orderable_status
   FROM tbl_menu
 WHERE category_code = (SELECT category_code
						FROM tbl_menu
						WHERE menu_name = '붕어빵초밥');
                        

-- (참고) 서브쿼리를 대상은 IN 연상 등도 사용 가능
SELECT menu_code, menu_name, menu_price, category_code, orderable_status
   FROM tbl_menu
 WHERE category_code = (SELECT category_code
						FROM tbl_menu
						WHERE menu_name LIKE '%김치%');			-- +뒤에는 값이 하나만 들어와야하는데 값이 두개가 들어와서 오류가 나는 것이다
                        
-- (해결방안)
SELECT menu_code, menu_name, menu_price, category_code, orderable_status
   FROM tbl_menu
 WHERE category_code IN (SELECT category_code					-- =을 IN으로 변경해서 해결했다
						FROM tbl_menu							-- ()안에 들어가 있는 애들을 4, 8로 변경해도 값이 값다. SELECT문이 나타내는 값이 4,8 이기 때문이다
						WHERE menu_name LIKE '%김치%');                        
                        
                        
SELECT category_code
  FROM tbl_menu
 WHERE menu_name LIKE '%김치%';
 
 -- 서브쿼리2
 SELECT COUNT(*) AS 'count'			-- 카테고리 코드 같은 값이 몇 개인지 출력
   FROM tbl_menu
GROUP BY category_code;
 
-- 메인쿼리2
-- SELECT MAX(count)
--  FROM (); 

SELECT MAX(count)
  FROM ( SELECT COUNT(*) AS 'count'		
		   FROM tbl_menu
		 GROUP BY category_code) AS countmenu;		-- 서브쿼리를 FROM절에서 사용할 떄는 별칭이 필요하다  
 
#상관 서브쿼리
-- 메인쿼리가 서브쿼리의 결과에 영향을 주는 경우

-- 서브쿼리
SELECT AVG(menu_price)			-- 카테고리별 평균 가격을 구함
  FROM tbl_menu
GROUP BY category_code;

-- 메인쿼리
SELECT menu_code, menu_name, menu_price, category_code, orderable_status
  FROM tbl_menu;
 
SELECT a.menu_code, a.menu_name, menu_price, category_code, orderable_status
  FROM tbl_menu a
 WHERE menu_price > (SELECT AVG(menu_price)			-- 카테고리별 평균 가격을 구함
					   FROM tbl_menu
					  WHERE category_code = a.category_code		-- 이 코드가 없다면 에러가 난다. 이유는 서브 쿼리에서 한 개 이상의 대소 비교를 하기 때문이다
					 GROUP BY category_code);

 # EXISTS
 -- 조회결과가 있을 때 true, 아니면 false
 
 -- 메뉴가 있는 카테고리명만 조회
 SELECT category_name
   FROM tbl_category a
  WHERE EXISTS(
				SELECT 1					-- 1번이라고 하는 것은 true라는 의미를 가진다
				  FROM tbl_menu b
				 WHERE b.category_code = a.category_code
                 );
                 
                 
 # CTE (Common Table Expressions)
 -- 파생 테이블과 비슷한 개념이며 코드의 가독성과 재사용성을 위해 파생 테이블 대신 사용
 -- FROM 절에서만 사용 (JOIN이면 JOIN구문에서도 가능)

WITH menucate AS (
	SELECT a.menu_name, b.category_name
      FROM tbl_menu a
      JOIN tbl_category b ON a.category_code = b.category_code
	)
SELECT *
  FROM menucate
ORDER BY menu_name;