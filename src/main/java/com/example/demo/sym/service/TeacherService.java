  
package com.example.demo.sym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
	@Autowired
    TeacherMapper teacherMapper;

    public int register(TeacherDTO t) {
        return teacherMapper.insert(t);
    }

    public List<?> list() {
        return teacherMapper.selectAll();
    }

    public TeacherDTO detail(String name) {
        return teacherMapper.select(name);
    }

    public int update(TeacherDTO t) {
        return teacherMapper.update(t);
    }

    public int delete(TeacherDTO t) {
        return teacherMapper.delete(t);
    }
}