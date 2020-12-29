package com.example.demo.sym.service;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface TeacherMapper {

	public int insert(TeacherDTO t);

	public List<TeacherDTO> selectAll();

	public TeacherDTO select(String name);

	public int update(TeacherDTO t);

	public int delete(TeacherDTO t);
    
}