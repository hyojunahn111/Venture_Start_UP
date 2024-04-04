# DML (Data Manipulation Language)
-- 데이터 조작 언어
-- 테이블에 값을 삽입(INSERT)하거나, 수정(UPDATE), 삭제(DELETE), 조회(SELECT)하는 언어

# INSERT
-- INSERT INTO 테이블명 VALUES (모든 컬럼에 대하여 컬럼순으로 삽입할 데이터 나열...);
INSERT INTO tbl_menu VALUES (null, '꿔바로우', 18000, 5, 'Y');

# INSERT INTO 테이블명(컬럼명1, 컬럼명2, 컬럼명3, ...)
-- VALUES(컬럼명1에 대한 데이터, 컬렁명2에 대한 데이터, 컬럼명3에 대한 데이터, ...);
INSERT INTO tbl_menu(menu_code, menu_name, menu_price, category_Code, orderable_status)
VALUES (null, '돈가스김밥', 8000, 4, 'Y');

-- NULL 허용 가능한 (NULLABLE) 컬럼이나 AUTO_INCREAMENT가 있는 컬럼을 제외하고 INSERT 가능
-- 삽입할 컬럼명을 명시하면 INSERT시 데이터의 순서를 바꾸는 것도 가능
INSERT INTO tbl_menu(menu_name, category_code, menu_price, orderable_status)
VALUES('쉬림프로제파시트', 12, 21000, 'Y');

INSERT INTO tbl_category(category_name)
VALUES('내가좋아하는음식');

SELECT * FROM tbl_menu;
SELECT * FROM tbl_category;

-- MULTI INSERT
INSERT INTO tbl_menu
VALUES(null, '감자위김', 3000, 12, 'Y'), (NULL, '햄버거', 10000, 12, 'Y'), (NULL, '초콜릿케이크', 9000, 12, 'Y');


# UPDATE
-- UPDATE 테이블명
-- 	  SET 컬럼명1 = 수정할데이터
-- 	    , 컬럼명2 = 수정할데이터
-- 	    , ...
-- [ WHERE 수정 대상 데이터 조건 ]
UPDATE tbl_menu
   SET menu_name = '오늘점심맛있다'
	 , menu_price = 1000
 WHERE menu_code = 21;
 
SELECT * FROM tbl_menu WHERE menu_code = 21;
select * from tbl_menu;

-- MYSQL은 UPDATE나 DELETE시 자기 자신 테이블의 데이털을 사용하면 1093 에러 발생
UPDATE tbl_menu
   SET menu_name = '오늘저녁밥'
 WHERE menu_code = (SELECT menu_code
					  FROM tbl_menu
					 WHERE menu_name = '오늘점심맛있다');
                     
UPDATE tbl_menu
   SET menu_name = '오늘저녁밥'
 WHERE menu_code = (SELECT tmp.menu_code
					  FROM(SELECT menu_code
							 FROM tbl_menu
							WHERE menu_name = '오늘점심맛있다'
						  ) tmp
					);
                    
SELECT * FROM tbl_menu WHERE menu_code = 21;


# DELETE
-- DELETE FROM 테이블명 [ 삭제 조건];

DELETE
  FROM tbl_menu
 WHERE menu_code = 21;
 
 SELECT * FROM tbl_menu WHERE menu_code = 21;
 
 -- LIMIT를 활용한 행 삭제 (offest 지정은 안됨)
 DELETE
   FROM tbl_menu
 ORDER BY menu_price
 LIMIT 3;
 
# REPLACE

-- PRIMARY KEY 도는 UNIQUE KEY에 대해 중복값을 INSERT하면 충돌(에러) 발생
-- INSERT INTO tbl_menu VALUES (2, '떡볶이', 2000, 4, 'Y');

REPLACE INTO tbl_menu VALUES (200, '로제떡볶이', 150000, 4, 'Y');

-- REPLACE는 중복값에 대해서는 데이터를 엎어쓰고, 중복값이 없다면 INSERT함
-- INTO 키워드는 생략 가능하다
REPLACE tbl_menu VALUES (200, '복날삼계탕', 150000, 4, 'Y');
