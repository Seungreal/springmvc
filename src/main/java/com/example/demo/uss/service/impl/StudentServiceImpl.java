package com.example.demo.uss.service.impl;

import java.util.List;

import com.example.demo.cmm.mpr.StudentMapper;
import com.example.demo.uss.service.StudentService;
import com.example.demo.uss.service.model.StudentDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public int register(StudentDTO s) {
        return studentMapper.insert(s);
    }

    @Override
    public StudentDTO login(StudentDTO s) {
        return studentMapper.login(s);
    }

    @Override
    public StudentDTO detail(String userid) {
        return studentMapper.selectById(userid);
    }

    @Override
    public List<?> list() {
        return studentMapper.selectAll();
    }

    @Override
    public int update(StudentDTO s) {
        return studentMapper.update(s);
    }

    @Override
    public int delete(StudentDTO s) {
        return studentMapper.delete(s);
    }
    
}