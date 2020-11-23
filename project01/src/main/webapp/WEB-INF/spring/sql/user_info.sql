DROP TABLE USER;
DROP SEQUENCE USER_SEQ;



CREATE SEQUENCE USER_SEQ;


CREATE TABLE USER_INFO(
	USER_NO NUMBER(20),
	USER_ID VARCHAR2(20) NOT NULL,
	USER_PW VARCHAR2(1000) NOT NULL,
	USER_NAME VARCHAR2(20) NOT NULL,
	USER_EMAIL VARCHAR2(500) NOT NULL,
	USER_ROLE VARCHAR2(20) NOT NULL,
	USER_PHONE VARCHAR2(500) NOT NULL,
	USER_ADDRESS VARCHAR2(500) NOT NULL,
	USER_REGDATE DATE NOT NULL,
	CONSTRAINT USERNO PRIMARY KEY (USER_NO),
	CONSTRAINT USERROLE CHECK (USER_ROLE IN ('USER', 'ADMIN'))
);



SELECT * FROM USER_INFO;



