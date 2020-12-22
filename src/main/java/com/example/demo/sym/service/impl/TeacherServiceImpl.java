package com.example.demo.sym.service.impl;

import java.util.List;

import com.example.demo.cmm.mpr.TeacherMapper;
import com.example.demo.sym.service.TeacherService;
import com.example.demo.sym.service.model.TeacherDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public int register(TeacherDTO t) {
        return teacherMapper.insert(t);
    }

    @Override
    public List<?> list() {
        return teacherMapper.selectAll();
    }

    @Override
    public TeacherDTO detail(String name) {
        return teacherMapper.select(name);
    }

    @Override
    public int update(TeacherDTO t) {
        return teacherMapper.update(t);
    }

    @Override
    public int delete(TeacherDTO t) {
        return teacherMapper.delete(t);
    }
    
}