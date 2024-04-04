# JOIN

# ALIAS (별칭)
-- 컬럼 별칭
SELECT menu_code AS 'code'
	 , menu_name AS name
     , menu_price AS '메뉴의 가격'
  FROM tbl_menu;
  
-- 테이블 별칭
SELECT menu_code, menu_name, menu_price
  FROM tbl_menu AS m;
  
# INNER JOIN
-- INNER JOIN에서 INNER는 생략 가능

-- ON
SELECT a.menu_code, a.menu_name, a.category_code, b.category_name
FROM tbl_menu a
JOIN tbl_category b ON a.category_code = b.category_code;

-- USING
SELECT a.menu_code, a.menu_name, a.category_code, b.category_name
FROM tbl_menu a
JOIN tbl_category b USING (category_code);

# ON과 USING의 차이점은 작성된 차이점이 있고 ON에서는 =을 사용하고 USING은 조인하고자 하는 컬럼이름이 똑같을 때 사용한다

# OUTER JOIN
-- LEFT JOIN
SELECT b.menu_code, b.menu_name, a.category_code, a.category_name
  FROM tbl_category a
LEFT JOIN tbl_menu b ON a.category_code = b.category_code;

-- RIGHT JOIN
SELECT
a.menu_code, a.menu_name, b.category_code, b.category_name
  FROM tbl_menu a
RIGHT JOIN tbl_category b ON a.category_code = b.category_code;

# CROSS JOIN
SELECT a.menu_name, b.category_name
  FROM tbl_menu a
CROSS JOIN tbl_category b;

# SELF JOIN
SELECT a.category_name AS '카테고리명', b.category_name AS '상위 카테고리명'
  FROM tbl_category a
  JOIN tbl_category b ON a.ref_category_code = b.category_code
 WHERE a.ref_category_code IS NOT NULL;
 
# JOIN 알고리즘
-- NESTED LOOP JOIN
-- EXPLAIN
SELECT /*+ NO_HASH_JOIN(a) */a.menu_name, b.category_name
  FROM tbl_menu a
  JOIN tbl_category b ON a.category_code = b.category_code;
  
  -- HASH JOIN
SELECT /*+ HASH_JOIN(a) */a.menu_name, b.category_name
  FROM tbl_menu a
  JOIN tbl_category b ON a.category_code = b.category_code;