package com.example.demo.sts.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component @Data @AllArgsConstructor @Lazy @NoArgsConstructor
public class Grade {
	private int grdNum,stuNum,sub_num,score;
	private String grade, examDate, passExam;
	
	public Grade(int grdNum,int stuNum,int sub_num,int score,String examDate) {
		this.grdNum=grdNum;
		this.stuNum=stuNum;
		this.sub_num=sub_num;
		this.score=score;
		this.examDate=examDate;
	}
}
/*
create table grades(
	grade_num int primary key,
	subject varchar2(20),
	score varchar2(20),
	grade varchar2(20),
	stu_num int,
	constraint grades_FK foreign key(tea_num) references teachers(tea_num)
);
 */