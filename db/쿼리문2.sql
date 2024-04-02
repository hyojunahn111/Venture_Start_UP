# ORDER BY

-- 결과 집합을 하나의 열 기준으로 정렬(오름차순)

  SELECT menu_code, menu_name, menu_price
    FROM tbl_menu
ORDER BY menu_price;

-- 역순(내림차순) 정렬
SELECT menu_code, menu_name, menu_price
  FROM tbl_menu
ORDER BY menu_price desc;  -- DESC는 내림차순 정렬로 명시해야함

-- 결과 집합을 여러 개의 열로 정렬
SELECT menu_code, menu_name, menu_price
  FROM tbl_menu
ORDER BY menu_price DESC, menu_name ASC;

-- 결과 집합을 연산 결과로 정렬 (별칭 지정 가능)
SELECT menu_code, menu_name, menu_price,  menu_code * menu_price AS '연산결과'
  FROM tbl_menu
ORDER BY '연산결과' DESC;

SELECT FIELD('A', 'A', 'B', 'C');			-- 맨 앞은 찾고자하는 것 뒤에는 순서
SELECT FIELD('B', 'A', 'B', 'C');

SELECT menu_name, orderable_status, FIELD(orderable_status, 'Y', 'N')
  FROM tbl_menu;

SELECT menu_name, orderable_status
  FROM tbl_menu
ORDER BY FIELD(orderable_status, 'N', 'Y');

-- NULL
-- 오름차순(ASC) 정렬 시 NULL이 맨 처음(default)
SELECT category_code, category_name, ref_category_code
  FROM tbl_category
ORDER BY ref_category_code IS NULL;

SELECT category_code, category_name, ref_category_code
  FROM tbl_category
ORDER BY ref_category_code IS NULL DESC, ref_category_code DESC;