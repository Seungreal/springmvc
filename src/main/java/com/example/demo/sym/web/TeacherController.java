package com.example.demo.sym.web;

import java.util.List;

import com.example.demo.cmm.enm.Messenger;
import com.example.demo.sym.service.Teacher;
import com.example.demo.sym.service.TeacherMapper;
import com.example.demo.sym.service.TeacherService;

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
@RequestMapping("/teachers")
public class TeacherController {
	@Autowired TeacherMapper teacherMapper;
    @Autowired TeacherService teacherService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @PostMapping("")
    public Messenger register(@RequestBody Teacher t){
        logger.info("강사 정보:"+t.toString());
        return teacherService.register(t)==1?Messenger.SUCCESS:Messenger.FAILURE;
    }
    @PostMapping("/access")
    public Teacher access(@RequestBody Teacher t) {
    	logger.info("강사 정보:"+t.toString());
    	return teacherMapper.access(t);
    }
    @GetMapping("")
    public List<?> list(){
        return teacherService.list();
    }
    @GetMapping("/{name}")
    public Teacher profile(@PathVariable String name){
        return teacherService.detail(name);
    }
    @PutMapping("")
    public Messenger update(@RequestBody Teacher t){
        return teacherService.update(t)==1?Messenger.SUCCESS:Messenger.FAILURE;
    }
    @DeleteMapping("")
    public Messenger delete(@RequestBody Teacher t){
        return teacherService.delete(t)==1?Messenger.SUCCESS:Messenger.FAILURE;
    }
}