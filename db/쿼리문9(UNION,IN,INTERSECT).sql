# UNION															# UNION을 사용할 땐 컬럼 갯수가 맞아야한다(같을 필요는 없지만 나중에 정보가 나올 때 이게 어떤건지 모르게 된다.
SELECT menu_code, menu_name, menu_price,category_code
  FROM tbl_menu
 WHERE category_code = 10
 UNION															# 중복된 데이터를 제거함
SELECT menu_code, menu_name, menu_price, category_code
  FROM tbl_menu
 WHERE menu_price < 9000;
 
 
 # UNION ALL
SELECT menu_code, menu_name, menu_price, category_code
  FROM tbl_menu
 WHERE category_code = 10
 
 UNION ALL														
 
 SELECT category_code, menu_name, menu_price, category_code
   FROM tbl_menu
  WHERE menu_price < 9000;
  
   # INTERSECT
 -- MYSQL은 INTERSECT를 제공하지 않음
 -- 단, INNER JOIN 또는 IN을 활용해 구현할 수 있음
 
 -- 1) INNER JOIN
SELECT menu_code, menu_name, menu_price, category_code
  FROM tbl_menu
 WHERE category_code = 10;
 
SELECT menu_code, menu_name, menu_price, category_code
  FROM tbl_menu
 WHERE menu_price < 9000;
 
 
SELECT a.menu_code, a.menu_name, a.menu_price, a.category_code
  FROM tbl_menu a
  JOIN (SELECT menu_code, menu_name, menu_price, category_code
		  FROM tbl_menu
		 WHERE menu_price < 9000) b ON a.menu_code = b.menu_code
 WHERE a.category_code = 10;
 
 
 -- 2) IN
SELECT menu_code, menu_name, menu_price, category_code
  FROM tbl_menu
 WHERE category_code = 10
   AND menu_code IN(SELECT menu_code, menu_name, menu_price, category_code
					  FROM tbl_menu
					 WHERE menu_price < 9000);
 
# MINUS
-- MYSQL은 MINUS를 제공하지 않음
-- 단, LEFT JOIN을 활용해 구현 가능

SELECT a.menu_code, a.menu_name, a.menu_price, a.category_code
  FROM tbl_menu a
  LEFT JOIN (SELECT menu_code, menu_name, menu_price, category_code
		  FROM tbl_menu
		 WHERE menu_price < 9000) b ON a.menu_code = b.menu_code
 WHERE a.category_code = 10
 AND b.menu_code IS NULL;
  