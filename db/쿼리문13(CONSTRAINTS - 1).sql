# CONSTRAINTS
-- 데이터 무결성 보장을 목적으로 테이블 작성(정의)시 각 컬럼의 값 기록에 대한 제약조건 설정 가능
-- 입력/수정하는 데이터에 문제가 없는지 자동으로 검사해줌
-- NOT NULL, UNIQUE, PRIMARY KEY, FOREIGN KEY, CHECK

# NOT NULL

DROP TABLE IF EXISTS user_notnull;
CREATE TABLE user_notnull (
		user_no INT NOT NULL,
        user_id VARCHAR(255) NOT NULL,
        user_pwd VARCHAR(255) NOT NULL,
        user_name VARCHAR(255) NOT NULL,
        gender CHAR(3),
        phone VARCHAR(255) NOT NULL,
        email VARCHAR(255)
) ENGINE=INNODB;

INSERT INTO user_notnull(user_no, user_id, user_pwd, user_name, gender, phone, email)
	 VALUES (1, 'user01', 'pass01', '박서준', '남', '010-1234-5678', 'parksj@naver.com'),
		    (2, 'user02', 'pass02', '한소희', '여', '010-8765-4321', 'hansh@gamil.com');
            
SELECT * FROM user_notnull;

# UNIQUE

INSERT INTO user_notnull(user_no, user_id, user_pwd, user_name, gender, phone, email)
	 VALUES (3, 'user03', 'pass03', '황향숙', '여', '010-9999-9999', 'hwanghs@kakao.com');			
     


# UNIQUE
DROP TABLE IF EXISTS user_unique;
CREATE TABLE user_unique (
		user_no INT NOT NULL UNIQUE,
        user_id VARCHAR(255) NOT NULL,
        user_pwd VARCHAR(255) NOT NULL,
        user_name VARCHAR(255) NOT NULL,
        gender CHAR(3),
        phone VARCHAR(255) NOT NULL,
        email VARCHAR(255),
        CONSTRAINT UNIQUE (phone)				-- constaint 생략해되 된다
) ENGINE=INNODB;

INSERT INTO user_unique(user_no, user_id, user_pwd, user_name, gender, phone, email)
			VALUES
            (1, 'user01', 'pass01', '박서준', '남', '010-1234-5678', '123@naver.com'),
            (2, 'user02', 'pass02', '한소희', '여', '010-7856-7856', '1234132313@daum.net');
            
SELECT * FROM user_unique;

INSERT INTO user_unique(user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES (100, 'user01', 'pass01', '박서준', '남', '010-1234-5679', null);

INSERT INTO user_unique(user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES (3, 'user03', 'pass03', '한소희', '여', '010-7856-7856', null);

# PRIMARY KEY (PK)
-- NOT NULL + UNIQUE
-- 한 테이블 한 개만 설정할 수 있음
DROP TABLE IF EXISTS user_pk;
CREATE TABLE user_pk (
		#user_no INT PRIMARY KEY,				-- pk는 이처럼 앞에서 사용할수도 있고
		user_no INT,
        user_id VARCHAR(255) NOT NULL,
        user_pwd VARCHAR(255) NOT NULL,
        user_name VARCHAR(255) NOT NULL,
        gender CHAR(3),
        phone VARCHAR(255) NOT NULL,
        email VARCHAR(255),
        CONSTRAINT user_pk_const PRIMARY KEY (user_no)			-- 이처럼 뒤에다가 설정할 수 있다(단 둘중 하나만 사용해야함)
) ENGINE=INNODB;

-- PRIMARY KEY 제약조건으로 인해 에러 발생(PK는 NOT NULL)
INSERT INTO user_pk(user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES (null, 'user01', 'pass01', '박서준', '남', '010-1234-5678', null);

-- PRIMARY KEY 제약조건으로 인해 에러발생(PK는 UNIQUE)
INSERT INTO user_pk(user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES (1, 'user02', 'pass02', '한세준', '여', '010-123-5678', null);
INSERT INTO user_pk(user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES (1, 'user03', 'pass03', '한소희', '여', '010-7856-7851', null);


SELECT * from user_pk;


DROP TABLE IF EXISTS user_pk;
CREATE TABLE user_pk (
		#user_no INT PRIMARY KEY,				
		user_no INT,
        user_id VARCHAR(255) NOT NULL,
        user_pwd VARCHAR(255) NOT NULL,
        user_name VARCHAR(255) NOT NULL,
        gender CHAR(3),
        phone VARCHAR(255) NOT NULL,
        email VARCHAR(255),
        CONSTRAINT user_pk_const PRIMARY KEY (user_no, user_id)			
) ENGINE=INNODB;


INSERT INTO user_pk(user_no, user_id, user_pwd, user_name, gender, phone, email)
			VALUES
            (1, 'user01', 'pass01', '박서준', '남', '010-1234-5678', 'hello@naver.com'),
            (2, 'user02', 'pass02', '한소희', '여', '010-7856-7812', 'bye@daum.net');
            

            
            -- PRIMARY KEY 제약조건으로 인해 에러 발생(PK는 NOT NULL)
INSERT INTO user_pk(user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES (null, 'user01', 'pass01', '박서준', '남', '010-1234-5678', null);

-- PRIMARY KEY 제약조건으로 인해 에러발생(PK는 UNIQUE)
INSERT INTO user_pk(user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES (1, 'user02', 'pass02', '한세준', '여', '010-123-5678', null);