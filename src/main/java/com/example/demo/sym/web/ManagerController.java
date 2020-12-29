package com.example.demo.sym.web;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.sym.service.ManagerDTO;
import com.example.demo.sym.service.ManagerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/managers")
public class ManagerController {
    @Autowired ManagerService managerService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @PostMapping("/")
    public Map<?,?> register(@RequestBody ManagerDTO m){
        var map = new HashMap<>();
        logger.info("등록하려는 관리자정보:"+m.toString());
        int result = managerService.register(m);
        map.put("message", result==1?"SUCCESS":"FAILURE");
        return map;
    }
}