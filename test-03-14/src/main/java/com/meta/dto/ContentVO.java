package com.meta.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * create table Content(
contentNum number(10) NOT NULL PRIMARY KEY,
contentName varchar(30) NOT NULL,
contentStory varchar(1000),
genre varchar2(30) NOT NULL,
actor varchar2(15) NOT NULL,
year varchar(30) NOT NULL,
RANK NUMBER(1) NOT NULL,
CONSTRAINT FK_RANK FOREIGN KEY (RANK) REFERENCES MEMBER1(RANK)
);
 */
@Setter
@Getter
@ToString

public class ContentVO {
int contentNum;
String contentTitle;
String contentStory;
String genre;
String actor;
String year;
String poster;
int admin;
}
