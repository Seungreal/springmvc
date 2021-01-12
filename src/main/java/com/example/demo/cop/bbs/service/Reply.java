package com.example.demo.cop.bbs.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component @Data @AllArgsConstructor @Lazy @NoArgsConstructor
public class Reply {
	public String repNum,content,artNum;
}
/*
create table replys(
	reply_num int primary key,
	content varchar2(100),
	art_num int,
	constraint replys_FK foreign key(art_num) references articles(art_num)
);
 */