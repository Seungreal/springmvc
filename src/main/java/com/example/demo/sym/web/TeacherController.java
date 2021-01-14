package com.example.demo.sym.web;

import static com.example.demo.cmm.util.Util.integer;

import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;

import com.example.demo.cmm.enm.Messenger;
import com.example.demo.cmm.enm.Table;
import com.example.demo.cmm.util.Pagination;
import com.example.demo.sts.service.GradeVo;
import com.example.demo.sts.service.SubjectMapper;
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
	@Autowired SubjectMapper subjectMapper;
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
    @GetMapping("/page/{pageSize}/{pageNum}/subject/{subNum}/{examDate}")
    public Map<?,?> selectAllJoin(@PathVariable String examDate,@PathVariable String subNum,
    							@PathVariable String pageSize,@PathVariable String pageNum){
    	var map = new HashMap<>();
    	map.put("examDate", examDate);
    	map.put("subNum", subNum);
    	List<GradeVo> list = teacherMapper.selectJoinAll(map);
    	map.clear();
    	IntSummaryStatistics is = list.stream().collect(summarizingInt(GradeVo::getScore));
    	map.put("ls",is);
    	map.put("subjects",subjectMapper.selectAllSubject().stream().collect(joining(",")));
    	Optional<GradeVo> highscoreGrade = list.stream().collect(reducing((g1,g2)-> g1.getScore() > g2.getScore() ? g1 :g2));
    	System.out.println(highscoreGrade);
    	var page = new Pagination("", 
				integer.apply(pageSize), 
				integer.apply(pageNum),
				list.size());
    	map.put("list",teacherService.paging(list,page));
    	map.put("page",page);
    	return map;
    }
    
}