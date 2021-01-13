package com.example.demo.uss.service;

import java.util.HashMap;
import java.util.List;
import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cmm.enm.Sql;
import com.example.demo.cmm.util.DummyGenerator;
import com.example.demo.cmm.util.Pagination;

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

    public int update(Student s) {
        return studentMapper.update(s);
    }

    public int delete(Student s) {
        return studentMapper.delete(s);
    }
    
    public void truncate() {
    	var map = new HashMap<String,String>();
    	map.put("TRUNCATE_STUDENTS", Sql.TRUNCATE.toString()+"students");
    	studentMapper.truncate(map);
    }
    public int count() {
    	var map = new HashMap<String,String>();
    	map.put("COUNT_STUDENTS",Sql.TOTAL_COUNT.toString()+"students");
    	return studentMapper.count(map);
    }
    public List<Student> list(Pagination page){
    	return studentMapper.list().stream()
    			.sorted(comparing(Student::getStuNum).reversed())
    			.skip(page.getStartRow()-1)
    			.limit(page.getPageSize())
    			.collect(toList());
    }
    /*public List<Student> selectByGender(String Gender){
    	return selectAll().stream()
    			
    			.collect(toList());
    }*/
    public List<Student> listByBirthday(){
    	return studentMapper.list().stream()
    			.filter(x->(x.getBirthday().compareTo("1995"))>0)
    			.sorted(comparing(Student::getStuNum).reversed())
    			.collect(toList());
    }
}