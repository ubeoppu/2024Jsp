package com.meta.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
CREATE TABLE BULLETINBOARDWISHLIST(
BULLETINNUM NUMBER(10) NOT NULL,
BULLETINUSERNUM NUMBER(10) NOT NULL,
CONSTRAINT FK_BULLETINNUM FOREIGN KEY(BULLETINNUM)REFERENCES BULLETIN(BULLETINNUM),
CONSTRAINT FK_BULLETINUSERNUM FOREIGN KEY (BULLETINUSERNUM) REFERENCES MEMBER1(USERNUM)
 */
@Setter
@Getter
@ToString
public class BulletinWishListVO {

	int bulletinNum;
	int bulletinUserid;  //멤버 userNum
}
