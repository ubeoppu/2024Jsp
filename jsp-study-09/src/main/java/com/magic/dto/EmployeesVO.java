package com.magic.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmployeesVO {
String id = null;
String pass = null;
String name = null;
String lev = null;
Date enter;
int gender = 0;
String phone = null;
}
