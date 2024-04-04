# LIMIT
-- SELECT문의 결과 집합에서 반활할 행의 수를 제한하는데 사용된다

SELECT menu_code, menu_name, menu_price
  FROM tbl_menu
ORDER BY menu_price DESC;

-- offset, row count
SELECT menu_code, menu_name, menu_price
  FROM tbl_menu
ORDER BY menu_price DESC
 LIMIT 2, 5;					# 이 줄을 뜻은 3번째부터 5개를 출력하라
 
-- row count
SELECT menu_code, menu_name, menu_price
 FROM tbl_menu
ORDER BY menu_price DESC
 LIMIT 7;				# 7개의 데이터를 보겠다  offset이 생략이되면 처음부터 하나씩 가져온다
 

 

