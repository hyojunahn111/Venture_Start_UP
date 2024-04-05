# FOREIGN KEY (FK)
-- FROEIGN KEY 제약조건에 의해 테이블 간 관계(Relationship) 형성
DROP TABLE IF EXISTS user_level;
CREATE TABLE user_level (
		level_code INT NOT NULL UNIQUE,
        level_title VARCHAR(25) NOT NULL
) ENGINE=INNODB;

INSERT INTO user_level
VALUES
(10, '초보'),
(20, '중수'),
(30, '고수');

DROP TABLE IF EXISTS user_fk_1;
CREATE TABLE user_fk_1 (
		user_no INT PRIMARY KEY,				
		#user_no INT,
        user_id VARCHAR(255) NOT NULL,
        user_pwd VARCHAR(255) NOT NULL,
        user_name VARCHAR(255),
        phone VARCHAR(255) NOT NULL,
        email VARCHAR(255),
        level_code INT,
        CONSTRAINT level_code_fk FOREIGN KEY (level_code) REFERENCES user_level(level_code)
) ENGINE=INNODB;

INSERT INTO user_fk_1 (user_no, user_id, user_pwd, user_name, phone, email, level_code)
VALUES
(1, 'user01', 'pass01', '다람쥐', '010-4444-4444', 'squirrel@gamil.com', 10),
(2, 'user02', 'pass02', '원숭이', '010-8888-8888', null, 20);

-- FOREIGN KEY 제약조건으로 인한 에러 발생(참조 테이블 컬럼에 없는 값 적용)
INSERT INTO user_fk_1 (user_no, user_id, user_pwd, user_name, phone, email, level_code)
VALUES
(3, 'user03', 'pass03', '양', '010-5555-5555', 'sheep@gamil.com', 50);

INSERT INTO user_fk_1 (user_no, user_id, user_pwd, user_name, phone, email, level_code)
VALUES
(3, 'user03', 'pass03', '양', '010-5555-5555', 'sheep@gamil.com', null);

SELECT * FROM information_schema.table_constraints
 WHERE constraint_schema = 'menu' AND table_name = 'user_fk_1';

select * from user_fk_1;

-- ON UPDATE SET NULL, ON DELETE SET NULL
DROP TABLE IF EXISTS user_fk_2;
CREATE TABLE user_fk_2 (
		user_no INT PRIMARY KEY,				
		#user_no INT,
        user_id VARCHAR(255) NOT NULL,
        user_pwd VARCHAR(255) NOT NULL,
        user_name VARCHAR(255),
        phone VARCHAR(255) NOT NULL,
        email VARCHAR(255),
        level_code INT,
        CONSTRAINT level_code_fk FOREIGN KEY (level_code) REFERENCES user_level(level_code)
        ON UPDATE SET NULL
        ON DELETE SET NULL
) ENGINE=INNODB;

INSERT INTO user_fk_2 (user_no, user_id, user_pwd, user_name, phone, email, level_code)
VALUES
(1, 'user01', 'pass01', '뽀로로', '010-8282-8282', 'pororol@gamil.com', 10),
(2, 'user02', 'pass02', '크롱', '010-9595-9955', null, 20);

SELECT * FROM user_fk_2;

UPDATE user_level
   SET level_code = null
 WHERE level_code = 10;
 
SELECT * FROM user_level;

-- 2) 부모 테이블의 컬럼 삭제
DELETE
  FROM user_level
 WHERE level_code = 20;

# CHECK
DROP TABLE IF EXISTS user_check;
CREATE TABLE user_check(
	user_no INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    gender VARCHAR(3) CHECK (gender IN ('남', '여')),
    age INT,
    CHECK (age > 19)
    ) ENGINE=INNODE;
    
INSERT INTO user_check(user_no, user_name, gender, age)
VALUES
(null, '김길동', '남', 20),
(null, '홍길동', '여', 22);

SELECT * FROM user_check;

#INSERT INTO user_check(user_no, user_name, gender, age)
#VALUES (null, '유길동', '여성', 29)

#INSERT INTO user_check(user_no, user_name, gender, age)
#VALUES (null, '유길동', '여' 29);

#DEFAULT
-- 컬럼 타입이 DATE이면 current_Date 사용가능
-- 컬럼 타입이 DATETIME이면 current_time, current)timestamp, now() 모두 사용 가능
DROP TABLE IF EXISTS tbl_default;
CREATE TABLE tbl_default(
	country_code INT AUTO_INCREMENT PRIMARY KEY,
    country_name VARCHAR(255) DEFAULT '한국',
    population VARCHAR(255) DEFAULT '0명',
    add_day DATE DEFAULT (current_Date),
    add_time DATETIME DEFAULT (current_time)
    )ENGINE=INNODB;
    
SELECT * FROM tbl_default;

-- default 값을 넣어주기 위해 default 사용
INSERT INTO tbl_default VALUES (null, default, default, default, default);

-- default 값이 설정된 컬럼을 insert 대상 컬럼에 명시하지 않으면 default 값으로 삽입됨
INSERT INTO tbl_default(country_code) VALUES (null);

-- null 입력 시 null로 삽입됨(NOT NULL 제약 조건이 있는 경우 에러 발생)
INSERT INTO tbl_default VALUES (null, null, null, null, null);