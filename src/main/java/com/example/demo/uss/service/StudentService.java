package com.example.demo.uss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService{
    @Autowired
    StudentMapper studentMapper;

    public int register(StudentDTO s) {
        return studentMapper.insert(s);
    }

    public StudentDTO login(StudentDTO s) {
        return studentMapper.login(s);
    }

    public StudentDTO detail(String userid) {
        return studentMapper.selectById(userid);
    }

    public List<?> list() {
        return studentMapper.selectAll();
    }

    public int update(StudentDTO s) {
        return studentMapper.update(s);
    }

    public int delete(StudentDTO s) {
        return studentMapper.delete(s);
    }
    
}