package com.example.demo.sts.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data @Component @ Lazy
public class GradeVo {
	// Grade
	private int grdNum,stuNum,score;
	private String subject, grade, examDate, passExam;
	// Subject
	private int subNum, teaNum;
	private String description;
	// Teacher
	private String teaName,teaPassword,email,teaProfileImg;
	// Student
    private String userid,stuPassword,stuName,birthday,gender,regDate,stuProfileImg;
}
