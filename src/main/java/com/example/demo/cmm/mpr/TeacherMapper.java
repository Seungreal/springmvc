package com.example.demo.cmm.mpr;

import java.util.List;

import com.example.demo.sym.service.model.TeacherDTO;

import org.springframework.stereotype.Repository;

@Repository
public interface TeacherMapper {

	public int insert(TeacherDTO t);

	public List<TeacherDTO> selectAll();

	public TeacherDTO select(String name);

	public int update(TeacherDTO t);

	public int delete(TeacherDTO t);
    
}