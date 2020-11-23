DROP TABLE USER
DROP SEQUENCE USER_SEQ;

CREATE SEQUENCE USER_SEQ;
CREATE TABLE USER(
	USER_NO NUMBER(10),
	USER_ID VARCHAR2(20) NOT NULL,
	USER_PW VARCHAR2(1000) NOT NULL,
	USER_NAME VARCHAR2(20) NOT NULL,
	USER_EMAIL VARCHAR2(500) NOT NULL,
	USER_ROLE VARCHAR2(20) NOT NULL,
	USER_PHONE VARCHAR2(500) NOT NULL,
	USER_ADDRESS VARCHAR2(500) NOT NULL,
	USER_REGDATE DATE NOT NULL,
	CONSTRAINT USERNO PRIMARY KEY (USER_NO),
	CONSTRAINT USERROLE CHECK (USER_ROLE IN ('USER','ADMIN'))
);


DROP TABLE ITEM;
DROP SEQUENCE ITEM_NO_SEQ;

CREATE SEQUENCE ITEM_NO_SEQ;
CREATE TABLE ITEM(
	ITEM_NO NUMBER(20),
	ITEM_NAME VARCHAR2(500) NOT NULL,
	ITEM_PRICE VARCHAR2(20) NOT NULL,
	ITEM_PHOTO VARCHAR2(1000) NOT NULL,
);

CREATE SEQUENCE LIKE_NO_SEQ;
CREATE TABLE LIKE(
	LIKE_NO
	ITEM_NO
	USER_NO

);