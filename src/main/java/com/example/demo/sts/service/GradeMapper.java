package com.example.demo.sts.service;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface GradeMapper {
	public int insertMany(List<Grade> list);
	public List<GradeVo> selectJoinAll(String s);
	public void insert(Grade g);
	public List<Grade> selectSome(Grade g);
	public Grade selectOne(Grade g);
	public int update(Grade g);
	public int delete(Grade g);
}
