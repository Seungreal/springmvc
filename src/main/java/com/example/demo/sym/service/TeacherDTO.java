package com.example.demo.sym.service;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component @Data
public class TeacherDTO {
	private String teaNum,name,password,subject,email,profileImg;
}

/*
create table teachers(
	tea_num int primary key,
	name varchar2(20),
	password varchar2(20),
	subject varchar2(20),
	email varchar2(20),
	profile_img varchar2(100)
);
 */