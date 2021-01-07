package com.example.demo.uss.service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cmm.enm.Sql;
import com.example.demo.cmm.util.DummyGenerator;

@Service
public class StudentService{
	@Autowired DummyGenerator dummy;
    @Autowired
    StudentMapper studentMapper;

    public int register(Student s) {
        return studentMapper.insert(s);
    }
    
    public void insertMany(int count) {
    	for(int i=0;i<count;i++) {
    		studentMapper.insert(dummy.makeStudent());
    	}
    }

    public Student login(Student s) {
        return studentMapper.login(s);
    }

    public Student detail(String userid) {
        return studentMapper.selectById(userid);
    }

    /*public List<?> list() {
        return studentMapper.selectAll();
    }*/

    public int update(Student s) {
        return studentMapper.update(s);
    }

    public int delete(Student s) {
        return studentMapper.delete(s);
    }
    
    public void truncate() {
    	var map = new HashMap<String,String>();
    	map.put("TRUNCATE_STUDENTS", Sql.TRUNCATE_STUDENTS.toString());
    	studentMapper.truncate(map);
    }
    public int count() {
    	var map = new HashMap<String,String>();
    	map.put("COUNT_STUDENTS",Sql.COUNT_STUDENTS.toString());
    	return studentMapper.count(map);
    }
    public List<Student> selectAll(){
    	var map = new HashMap<>();
    	map.put("SELECT_ALL_STUDENTS",Sql.SELECT_ALL_STUDENTS.toString());
    	return studentMapper.selectAll(map);
    }
    public List<Student> selectByGender(String Gender){
    	return selectAll().stream()
    			
    			.collect(toList());
    }
}