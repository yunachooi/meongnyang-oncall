-- 테이블 생성
CREATE TABLE tbl_veterinarian (
    v_no NUMBER PRIMARY KEY,
    v_name VARCHAR2(50),
    v_hospital VARCHAR2(100),
    v_area VARCHAR2(50),
    v_major VARCHAR2(50),
    v_status VARCHAR2(1)
);

CREATE TABLE tbl_protector (
    username VARCHAR2(100) PRIMARY KEY,
    password VARCHAR2(100),
    p_name VARCHAR2(50),
    p_phone VARCHAR2(13),
    p_email VARCHAR2(100)
);

CREATE TABLE tbl_animal (
    ani_no NUMBER PRIMARY KEY,
    ani_name VARCHAR2(50),
    ani_breed VARCHAR2(200),
    ani_birth DATE
);

CREATE TABLE tbl_question (
    q_no NUMBER PRIMARY KEY,
    username VARCHAR2(100),
    a_no NUMBER,
    q_title VARCHAR2(2000),
    q_content VARCHAR2(2000),
    q_time DATE,
    q_status VARCHAR2(1),
    FOREIGN KEY (username) REFERENCES tbl_protector(username),
    FOREIGN KEY (a_no) REFERENCES tbl_animal(ani_no)
);

CREATE TABLE tbl_answer (
    a_no NUMBER PRIMARY KEY,
    q_no NUMBER,
    v_no NUMBER,
    a_content VARCHAR2(2000),
    a_time DATE,
    FOREIGN KEY (q_no) REFERENCES tbl_question(q_no),
    FOREIGN KEY (v_no) REFERENCES tbl_veterinarian(v_no)
);

-- 테이블 조회
SELECT * FROM tbl_protector;
SELECT * FROM tbl_question;
SELECT * FROM tbl_answer;
SELECT * FROM tbl_veterinarian;
SELECT * FROM tbl_animal;

-- 테이블 삭제
DROP TABLE tbl_answer;
DROP TABLE tbl_question;
DROP TABLE tbl_animal;
DROP TABLE tbl_protector;
DROP TABLE tbl_veterinarian;
