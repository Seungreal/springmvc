package com.example.demo.sym.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.sym.service.TeacherDTO;
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
    @Autowired TeacherService teacherService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @PostMapping("")
    public Map<?,?> register(@RequestBody TeacherDTO t){
        var map = new HashMap<>();
        logger.info("강사 정보:"+t.toString());
        int result = teacherService.register(t);
        map.put("message", result==1?"SUCCESS":"FAILURE");
        return map;
    }
    @GetMapping("")
    public List<?> list(){
        return teacherService.list();
    }
    @GetMapping("/{name}")
    public TeacherDTO profile(@PathVariable String name){
        return teacherService.detail(name);
    }
    @PutMapping("")
    public Map<?,?> update(@RequestBody TeacherDTO t){
        var map = new HashMap<>();
        map.put("message", teacherService.update(t)==1?"SUCCESS":"FAILURE");
        return map;
    }
    @DeleteMapping("")
    public Map<?,?> delete(@RequestBody TeacherDTO t){
        var map = new HashMap<>();
        map.put("message", teacherService.delete(t)==1?"SUCCESS":"FAILURE");
        return map;
    }
}