  
package com.example.demo.sym.service;

import java.util.List;

import com.example.demo.sym.service.model.TeacherDTO;

import org.springframework.stereotype.Component;

@Component
public interface TeacherService {

	public int register(TeacherDTO t);

	public List<?> list();

	public TeacherDTO detail(String name);

	public int update(TeacherDTO t);

	public int delete(TeacherDTO t);
    
}