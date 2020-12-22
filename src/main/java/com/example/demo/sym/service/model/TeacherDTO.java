package com.example.demo.sym.service.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component @Data
public class TeacherDTO {
	private String teaNum,name,password,subject,email,profileImg;
}
