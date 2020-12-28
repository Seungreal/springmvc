package com.example.demo.sym.service.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component @Data
public class ManagerDTO {
	private String mgrNum,email,password;
}
/*
create table managers(
	mgr_num int primary key,
	email varchar2(20),
	password varchar2(20)
);
 */
