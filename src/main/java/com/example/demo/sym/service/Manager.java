package com.example.demo.sym.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component @Data @AllArgsConstructor @Lazy @NoArgsConstructor
public class Manager {
	private String mgrNum,email,password,name,profileImg;
}
/*
create table managers(
	mgr_num int primary key auto increment,
	email varchar(20),
	password varchar(20)
	name varchar(20)
	profile_img text
);
 */
