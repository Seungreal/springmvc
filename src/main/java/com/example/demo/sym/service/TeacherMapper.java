package com.example.demo.sym.service;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface TeacherMapper {

	public int insert(Teacher t);

	public List<Teacher> selectAll();

	public Teacher select(String name);

	public int update(Teacher t);

	public int delete(Teacher t);

	public Teacher access(Teacher t);
    
}