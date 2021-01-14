  
package com.example.demo.sym.service;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cmm.util.DummyGenerator;
import com.example.demo.cmm.util.Pagination;
import com.example.demo.sts.service.GradeVo;
import com.example.demo.uss.service.Student;

@Service
public class TeacherService {
	@Autowired
    TeacherMapper teacherMapper;
	@Autowired DummyGenerator dummy;

    public int register(Teacher t) {
        return teacherMapper.insert(t);
    }
    
    public void insertMany(int count) {
    	List<String> l = asList("Java","Spring","Python","jQuery","eGovframe");
    	Teacher t = null;
    	for(int i=0;i<count;i++) {
    		t=dummy.makeTeacher();
    		t.setSubNum(i);
    		teacherMapper.insert(t);
    	}
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

	public List<GradeVo> paging(List<GradeVo> list, Pagination page) {
		return list.stream()
				.sorted(comparing(GradeVo::getStuNum))
				.skip(page.getStartRow()-1)
				.limit(page.getPageSize())
				.collect(toList());
	}

	
}