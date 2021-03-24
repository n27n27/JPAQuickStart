CREATE TABLE s_emp(
	id			NUMBER(7)			CONSTRAINT	s_emp_id_nn NOT NULL,	-- 직원 아이디
	name		VARCHAR2(25)		CONSTRAINT	s_emp_name_nn NOT NULL,	-- 직원 이름
	start_date	DATE,													-- 입사일
	title		VARCHAR2(25),											-- 직급
	dept_name	VARCHAR2(25),											-- 부서이름
	salary		NUMBER(11, 2),											-- 급여
	CONSTRAINT  s_emp_id_pk PRIMARY KEY (id)
);

INSERT INTO s_emp VALUES (1, '안은경', '2002-12-03', '영업대표이사', '영업부', 2500);
SELECT * FROM s_emp;