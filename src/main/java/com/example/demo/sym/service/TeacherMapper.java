package com.example.demo.sym.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.sts.service.GradeVo;

@Repository
public interface TeacherMapper {

	public int insert(Teacher t);

	public List<Teacher> selectAll();

	public Teacher select(String name);

	public int update(Teacher t);

	public int delete(Teacher t);

	public Teacher access(Teacher t);
    
	public List<GradeVo> selectJoinAll(Map<?,?> paramMap);
}