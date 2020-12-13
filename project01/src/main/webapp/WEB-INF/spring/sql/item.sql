DROP TABLE ITEM;
DROP SEQUENCE ITEM_NO_SEQ;

DROP TABLE ITEM_GROUP;
DROP SEQUENCE ITEM_GROUP_NO_SEQ;
--
CREATE SEQUENCE ITEM_GROUP_NO_SEQ;
CREATE TABLE ITEM_GROUP(
	ITEM_GROUP_NO NUMBER(20) NOT NULL,
	GROUP_NO NUMBER(20) PRIMARY KEY,
	CONSTRAINT GROUP_NO_FK FOREIGN KEY(GROUP_NO) REFERENCES ITEM(GROUP_NO)
);

--
CREATE SEQUENCE ITEM_NO_SEQ;


CREATE TABLE ITEM(
	ITEM_NO NUMBER(20) PRIMARY KEY,
	GROUP_NO NUMBER(20) NOT NULL,
	CATEGORY_NO NUMBER(2),
	ITEM_NAME VARCHAR2(500) NOT NULL,
	ITEM_COLOR VARCHAR2(20) NOT NULL,
	ITEM_SIZE VARCHAR2(5) NOT NULL, --S,M,L,F
	ITEM_PRICE VARCHAR2(20) NOT NULL,
	ITEM_SKU NUMBER(20) NOT NULL, --재고
	ITEM_PHOTO VARCHAR2(1000) NOT NULL,
	ITEM_CONTENT VARCHAR2(1000) NOT NULL, --설명
	CREATEDAT DATE NOT NULL,
	CONSTRAINT CATE_NO_FK FOREIGN KEY (CATEGORY_NO) REFERENCES CATEGORY(CATEGORY_NO)
);

SELECT * FROM ITEM;

INSERT INTO ITEM
VALUES(ITEM_NO_SEQ.NEXTVAL, 1, 10, '토핑 라운드 니트','아이보리','F','29000',99,
	'20501eb6569c0202686773fa0eb2877b.webp', '하나쯤은 꼭 소장해야 하는 오랫동안 꾸준히 착용 가능한 라운드니트', SYSDATE);
INSERT INTO ITEM
VALUES(ITEM_NO_SEQ.NEXTVAL, 1, 10, '토핑 라운드 니트','베이지','F','29000',99,
	'20501eb6569c0202686773fa0eb2877b.webp', '하나쯤은 꼭 소장해야 하는 오랫동안 꾸준히 착용 가능한 라운드니트', SYSDATE);
INSERT INTO ITEM
VALUES(ITEM_NO_SEQ.NEXTVAL, 1, 10, '토핑 라운드 니트','옐로우','F','29000',99,
	'20501eb6569c0202686773fa0eb2877b.webp', '하나쯤은 꼭 소장해야 하는 오랫동안 꾸준히 착용 가능한 라운드니트', SYSDATE);
INSERT INTO ITEM
VALUES(ITEM_NO_SEQ.NEXTVAL, 1, 10, '토핑 라운드 니트','핑크','F','29000',99,
	'20501eb6569c0202686773fa0eb2877b.webp', '하나쯤은 꼭 소장해야 하는 오랫동안 꾸준히 착용 가능한 라운드니트', SYSDATE);
-- ITEM_PHOTO : 20501eb6569c0202686773fa0eb2877b.webp

	--item_photo : f1a98ab452847a19869717473d353a4e.webp
INSERT INTO ITEM
VALUES(ITEM_NO_SEQ.NEXTVAL, 2, 13, '모어 슬림 롱부츠컷 슬랙스 sl(가을,겨율용)','베이지','S','39900',99,
	'f1a98ab452847a19869717473d353a4e.webp', '가장 많은 사랑받았던 부츠컷핏으로 보여드려요 :)', SYSDATE);
INSERT INTO ITEM
VALUES(ITEM_NO_SEQ.NEXTVAL, 2, 13, '모어 슬림 롱부츠컷 슬랙스 sl(가을,겨율용)','베이지','M','39900',99,
	'f1a98ab452847a19869717473d353a4e.webp','가장 많은 사랑받았던 부츠컷핏으로 보여드려요 :)', SYSDATE);
INSERT INTO ITEM
VALUES(ITEM_NO_SEQ.NEXTVAL, 2, 13, '모어 슬림 롱부츠컷 슬랙스 sl(가을,겨율용)','베이지','L','39900',99,
	'f1a98ab452847a19869717473d353a4e.webp', '가장 많은 사랑받았던 부츠컷핏으로 보여드려요 :)', SYSDATE);
INSERT INTO ITEM
VALUES(ITEM_NO_SEQ.NEXTVAL, 2, 13, '모어 슬림 롱부츠컷 슬랙스 sl(가을,겨율용)','블랙','S','39900',99,
	'f1a98ab452847a19869717473d353a4e.webp', '가장 많은 사랑받았던 부츠컷핏으로 보여드려요 :)', SYSDATE);
INSERT INTO ITEM
VALUES(ITEM_NO_SEQ.NEXTVAL, 2, 13, '모어 슬림 롱부츠컷 슬랙스 sl(가을,겨율용)','블랙','M','39900',99,
	'f1a98ab452847a19869717473d353a4e.webp', '가장 많은 사랑받았던 부츠컷핏으로 보여드려요 :)', SYSDATE);
INSERT INTO ITEM
VALUES(ITEM_NO_SEQ.NEXTVAL, 2, 13, '모어 슬림 롱부츠컷 슬랙스 sl(가을,겨율용)','블랙','L','39900',99,
	'f1a98ab452847a19869717473d353a4e.webp', '가장 많은 사랑받았던 부츠컷핏으로 보여드려요 :)', SYSDATE);


select *
from (select rownum, distinct group_no from item)
where rownum = 1;

select *
from
(select rownum, ITEM_NO, distinct GROUP_NO, CATEGORY_NO, ITEM_NAME, ITEM_COLOR, ITEM_SIZE,
		ITEM_PRICE, ITEM_SKU, ITEM_PHOTO, ITEM_CONTENT, CREATEDAT 
from item)
where rownum=1


select *
from ITEM
where distinct group_no=1;

select DISTINCT ITEM_NAME, ITEM_COLOR, ITEM_SIZE,GROUP_NO, ITEM_NO, CATEGORY_NO, 
		ITEM_PRICE, ITEM_SKU, ITEM_PHOTO, ITEM_CONTENT, CREATEDAT 
from item
GROUP BY GROUP_NO
