package com.meta.dto;

/*
CREATE TABLE BULLETINBOARDWISHLIST(
BULLETINNUM NUMBER(10) NOT NULL,
BULLETINUSERNUM NUMBER(10) NOT NULL,
CONSTRAINT FK_BULLETINNUM FOREIGN KEY(BULLETINNUM)REFERENCES BULLETIN(BULLETINNUM),
CONSTRAINT FK_BULLETINUSERNUM FOREIGN KEY (BULLETINUSERNUM) REFERENCES MEMBER1(USERNUM)
 */
public class BulletinWishListVO {

	int bulletinNum;
	int bulletinUserNum;  //멤버 userNum
}