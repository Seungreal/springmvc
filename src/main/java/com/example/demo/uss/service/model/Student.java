package com.example.demo.uss.service.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component @Data
public class Student {
	private String stuNum,userid,password,name,ssn,regDate,subject,profileImg;
}
