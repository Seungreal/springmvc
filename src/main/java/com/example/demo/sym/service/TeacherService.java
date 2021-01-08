  
package com.example.demo.sym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
	@Autowired
    TeacherMapper teacherMapper;

    public int register(Teacher t) {
        return teacherMapper.insert(t);
    }

    public List<?> list() {
        return teacherMapper.selectAll();
    }

    public Teacher detail(String name) {
        return teacherMapper.select(name);
    }

    public int update(Teacher t) {
        return teacherMapper.update(t);
    }

    public int delete(Teacher t) {
        return teacherMapper.delete(t);
    }
}