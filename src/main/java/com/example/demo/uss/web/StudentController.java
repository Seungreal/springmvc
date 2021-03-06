package com.example.demo.uss.web;

import static com.example.demo.cmm.util.Util.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.HomeController;
import com.example.demo.cmm.enm.Messenger;
import com.example.demo.cmm.enm.Sql;
import com.example.demo.cmm.enm.Table;
import com.example.demo.cmm.service.CommonMapper;
import com.example.demo.cmm.util.Pagination;
import com.example.demo.sts.service.GradeService;
import com.example.demo.sts.service.SubjectMapper;
import com.example.demo.sts.service.SubjectService;
import com.example.demo.sym.service.ManagerService;
import com.example.demo.sym.service.TeacherMapper;
import com.example.demo.sym.service.TeacherService;
import com.example.demo.uss.service.Student;
import com.example.demo.uss.service.StudentMapper;
import com.example.demo.uss.service.StudentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired GradeService gradeService;
	@Autowired StudentService studentService;
	@Autowired SubjectService subjectService;
	@Autowired TeacherService teacherService;
	@Autowired ManagerService managerService;
    @Autowired StudentMapper studentMapper;
    @Autowired CommonMapper commonMapper;
    @Autowired Pagination page;
    @PostMapping("")
    public Messenger register(@RequestBody Student s){
        return studentService.register(s)==1?Messenger.SUCCESS:Messenger.FAILURE;
    }
    @GetMapping("/insert-many/{count}")
    public String insertMany(@PathVariable String count) {
    	managerService.insertMany(1);
    	subjectService.insertMany(5);
    	studentService.insertMany(Integer.parseInt(count));
    	teacherService.insertMany(5);
    	//gradeService.insertMany(Integer.parseInt(count));
    	return String.valueOf(studentService.count());
    }
    @PostMapping("/login")
    public Map<?,?> login(@RequestBody Student s){
        var map = new HashMap<>();
        Student result = studentService.login(s);
        map.put("message", result!=null?"SUCCESS":"FAILURE");
        map.put("sessionUser", result);
        return map;
    }
    @GetMapping("/count")
    public String count(){
    	var map = new HashMap<>();
        map.put("TOTAL_COUNT",Sql.TOTAL_COUNT.toString()+Table.STUDENTS.toString());
    	return String.valueOf(commonMapper.totalCount(map));
    }
    @GetMapping("/{userid}")
    public Student profile(@PathVariable String userid){
        return studentService.detail(userid);
    }
    @GetMapping("/page/{pageSize}/{pageNum}")
    public Map<?,?> list(@PathVariable String pageSize,@PathVariable String pageNum){
        var map = new HashMap<>();
        map.put("TOTAL_COUNT",Sql.TOTAL_COUNT.toString()+Table.STUDENTS.toString());
        var page = new Pagination(
				Table.STUDENTS.toString(), 
				integer.apply(pageSize), 
				integer.apply(pageNum),
				commonMapper.totalCount(map));
        map.put("list",studentService.list(page));
        map.put("page", page);
    	return map;
    }
    @PutMapping("")
    public Messenger update(@RequestBody Student s){
        return studentService.update(s)==1?Messenger.SUCCESS:Messenger.FAILURE;
    }
    @DeleteMapping("")
    public Messenger delete(@RequestBody Student s){
        return studentService.delete(s)==1?Messenger.SUCCESS:Messenger.FAILURE;
    }
    @GetMapping("/truncate")
    public Messenger truncate() {
    	studentService.truncate();
    	return studentService.count()==0?Messenger.SUCCESS:Messenger.FAILURE;
    }
    /*@GetMapping("/find-by-gender/{gender}")
    public List<Student> findByGender(@PathVariable String gender) {
    	logger.info(String.format("find by %s", gender));
    	return studentService.selectByGender(gender);
    }*/
}