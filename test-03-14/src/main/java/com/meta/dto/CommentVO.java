package com.meta.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
create table comments(
commentNum number(5) not null primary key,
commentContent varchar2(500) not null,
commentDate date default systimestamp not null,
bulletinNum number(10) not null,
commentCount number(10),
CONSTRAINT FK_commentNum FOREIGN KEY (bulletinNum) REFERENCES bulletin(bulletinNum)ON DELETE CASCADE);
 */
@Setter
@Getter
@ToString
public class CommentVO {
int commentNum;
String commentContent;
Date commentDate;
int bulletinNum;
String userid;
}
