package com.example.demo.sts.web;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.HomeController;
import com.example.demo.cmm.enm.Sql;
import com.example.demo.cmm.enm.Table;
import com.example.demo.cmm.service.CommonMapper;
import com.example.demo.sts.service.GradeService;

@RestController @RequestMapping("/grades")
public class GradeController {
	@Autowired CommonMapper commonMapper;
	@Autowired GradeService gradeService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@GetMapping("/register")
	public int registerMany() {
		logger.info("grade register...");
		gradeService.insertMany(100);
		var map = new HashMap<String,String>();
		map.put("TOTAL_COUNT",Sql.TOTAL_COUNT.toString()+Table.GRADES);
		return commonMapper.totalCount(map);
	}
	
}
