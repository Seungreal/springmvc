package com.example.demo.uss.service;

import java.util.List;

import com.example.demo.uss.service.model.StudentDTO;

import org.springframework.stereotype.Component;

@Component
public interface StudentService {

	public int register(StudentDTO s);

	public StudentDTO login(StudentDTO s);

	public StudentDTO detail(String userid);

	public List<?> list();

	public int update(StudentDTO s);

	public int delete(StudentDTO s);
    
}