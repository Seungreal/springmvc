package com.example.demo.uss.service;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component @Data
public class StudentDTO{
    private String stuNum,userid,password,name,ssn,regDate,subject,profileImg;
}

/*
create table students(
	stu_num int primary key,
	userid varchar2(20),
	password varchar2(20),
	name varchar2(20),
	ssn varchar2(20),
	reg_date varchar2(20),
	subject varchar2(20),
	profile_img varchar2(100),
	tea_num int,
	constraint students_FK foreign key(tea_num) references teachers(tea_num)
);
 */