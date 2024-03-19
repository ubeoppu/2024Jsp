package com.meta.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/*
create table member1(
userNum number(10) NOT NULL PRIMARY KEY,
rank number(1) NOT NULL UNIQUE,
name varchar2(30) NOT NULL UNIQUE,
userId varchar2(20) NOT NULL UNIQUE,
pwd varchar(30) NOT NULL,
email varchar(30) NOT NULL,
phone varchar(13) NOT NULL,
address varchar(100) NOT NULL);
*/
@Setter
@Getter
@ToString

public class MemberVO {   
	
	String userid;
	int admin;
	String name;
	String pwd;
	String email;
	String phone;
	String address;
}
