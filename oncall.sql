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
DROP TABLE tbl_veterinarian;
DROP TABLE tbl_oncall_user;

COMMIT;

-- 더미데이터
INSERT INTO tbl_oncall_user (username, password, p_name, p_phone, p_email, p_role) 
VALUES ('vet1', '1234', '김수의', '010-1111-1111', 'vet1@example.com', 'vets');
INSERT INTO tbl_oncall_user (username, password, p_name, p_phone, p_email, p_role) 
VALUES ('vet2', '1234', '박동물', '010-2222-2222', 'vet2@example.com', 'vets');
INSERT INTO tbl_oncall_user (username, password, p_name, p_phone, p_email, p_role) 
VALUES ('vet3', '1234', '이강아', '010-3333-3333', 'vet3@example.com', 'vets');
INSERT INTO tbl_oncall_user (username, password, p_name, p_phone, p_email, p_role) 
VALUES ('vet4', '1234', '최고양', '010-4444-4444', 'vet4@example.com', 'vets');
INSERT INTO tbl_oncall_user (username, password, p_name, p_phone, p_email, p_role) 
VALUES ('vet5', '1234', '정병원', '010-5555-5555', 'vet5@example.com', 'vets');

INSERT INTO tbl_veterinarian (username, v_hospital, v_area, v_major, v_status) 
VALUES ('vet1', '해피동물병원', '서울', '고양이|내과', 'Y');
INSERT INTO tbl_veterinarian (username, v_hospital, v_area, v_major, v_status) 
VALUES ('vet2', '우리동물병원', '부산', '고양이|외과', 'N');
INSERT INTO tbl_veterinarian (username, v_hospital, v_area, v_major, v_status) 
VALUES ('vet3', '튼튼동물의료센터', '대구', '고양이|강아지', 'Y');
INSERT INTO tbl_veterinarian (username, v_hospital, v_area, v_major, v_status) 
VALUES ('vet4', '건강동물병원', '인천', '파충류', 'Y');
INSERT INTO tbl_veterinarian (username, v_hospital, v_area, v_major, v_status) 
VALUES ('vet5', '사랑동물병원', '광주', '강아지', 'N');