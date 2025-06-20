-- 테이블 생성
-- 1. 사용자
CREATE TABLE tbl_oncall_user (
    username    VARCHAR2(100),
    password    VARCHAR2(100),
    p_name      VARCHAR2(50),
    p_phone     VARCHAR2(13),
    p_email     VARCHAR2(100),
    p_role      VARCHAR2(50),
    CONSTRAINT pk_oncall_user PRIMARY KEY (username)
);

-- 2. 반려동물
CREATE TABLE tbl_animal (
    ani_no      NUMBER,
    username    VARCHAR2(100),
    ani_name    VARCHAR2(50),
    ani_breed   VARCHAR2(200),
    ani_birth   DATE,
    CONSTRAINT pk_animal PRIMARY KEY (ani_no),
    CONSTRAINT fk_animal_user FOREIGN KEY (username)
        REFERENCES tbl_oncall_user(username)
);

-- 3. 수의사
CREATE TABLE tbl_veterinarian (
    username    VARCHAR2(100),
    v_hospital  VARCHAR2(100),
    v_area      VARCHAR2(50),
    v_major     VARCHAR2(50),
    v_status    VARCHAR2(1),
    CONSTRAINT pk_veterinarian PRIMARY KEY (username),
    CONSTRAINT fk_veterinarian_user FOREIGN KEY (username)
        REFERENCES tbl_oncall_user(username)
);

-- 4. 문의사항 질문
CREATE TABLE tbl_question (
    q_no        NUMBER,
    username    VARCHAR2(100),
    a_no        NUMBER,
    q_title     VARCHAR2(2000),
    q_content   VARCHAR2(2000),
    q_time      DATE,
    q_status    VARCHAR2(1),
    ani_no      NUMBER,
    CONSTRAINT pk_question PRIMARY KEY (q_no),
    CONSTRAINT fk_question_user FOREIGN KEY (username)
        REFERENCES tbl_oncall_user(username),
    CONSTRAINT fk_question_animal FOREIGN KEY (ani_no)
        REFERENCES tbl_animal(ani_no)
);

-- 5. 문의사항 답변
CREATE TABLE tbl_answer (
    a_no        NUMBER,
    q_no        NUMBER,
    a_content   VARCHAR2(2000),
    a_time      DATE,
    CONSTRAINT pk_answer PRIMARY KEY (a_no),
    CONSTRAINT fk_answer_question FOREIGN KEY (q_no)
        REFERENCES tbl_question(q_no)
);

-- 테이블 조회
SELECT * FROM tbl_oncall_user;
SELECT * FROM tbl_question;
SELECT * FROM tbl_answer;
SELECT * FROM tbl_veterinarian;
SELECT * FROM tbl_animal;

-- 테이블 삭제
DROP TABLE tbl_answer;
DROP TABLE tbl_question;
DROP TABLE tbl_animal;
DROP TABLE tbl_oncall_user;
DROP TABLE tbl_veterinarian;

COMMIT;