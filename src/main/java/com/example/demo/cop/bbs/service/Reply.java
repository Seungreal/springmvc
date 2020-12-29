package com.example.demo.cop.bbs.service;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component @Data
public class Reply {
	public String replyNum,content,artNum;
}
/*
create table replys(
	reply_num int primary key,
	content varchar2(100),
	art_num int,
	constraint replys_FK foreign key(art_num) references articles(art_num)
);
 */