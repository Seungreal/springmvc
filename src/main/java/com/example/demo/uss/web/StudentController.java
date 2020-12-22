package com.example.demo.uss.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.uss.service.StudentService;
import com.example.demo.uss.service.model.StudentDTO;

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
    @Autowired StudentService studentService;
    @PostMapping("")
    public Map<?,?> register(@RequestBody StudentDTO s){
        var map = new HashMap<>();
        int result = studentService.register(s);
        map.put("message", result==1?"SUCCESS":"FAILURE");
        return map;
    }
    @PostMapping("/login")
    public Map<?,?> login(@RequestBody StudentDTO s){
        var map = new HashMap<>();
        StudentDTO result = studentService.login(s);
        map.put("message", result!=null?"SUCCESS":"FAILURE");
        map.put("sessionUser", result);
        return map;
    }
    @GetMapping("/{userid}")
    public StudentDTO profile(@PathVariable String userid){
        return studentService.detail(userid);
    }
    @GetMapping("")
    public List<?> list(){
        return studentService.list();
    }
    @PutMapping("")
    public Map<?,?> update(@RequestBody StudentDTO s){
        var map = new HashMap<>();
        map.put("message", studentService.update(s)==1?"SUCCESS":"FAILURE");
        return map;
    }
    @DeleteMapping("")
    public Map<?,?> delete(@RequestBody StudentDTO s){
        var map = new HashMap<>();
        map.put("message", studentService.delete(s)==1?"SUCCESS":"FAILURE");
        return map;
    }
}