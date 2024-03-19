package com.meta.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*create table bulletin(
bulletinNum number(10) NOT NULL primary key,
usernum number(10) NOT NULL ,
bulletinTitle varchar2(30) NOT NULL,
bulletinDate TIMESTAMP DEFAULT SYSTIMESTAMP,
constraint FK_USERNUM foreign key (userNum) references member1(usernum)
);
*/

@Setter
@Getter
@ToString
public class BulletinVO {
int bulletinNum;
int userid;
String bulletinTitle;
Date bulletinDate;
String bulletinContent;
int readcount;
String name;
}
