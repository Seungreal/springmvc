package com.example.demo.sts.service;

import static java.util.Arrays.asList;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cmm.util.DummyGenerator;

@Service
public class SubjectService {
	@Autowired SubjectMapper subjectMapper;
	@Autowired DummyGenerator dummy;
	public int insertMany(int count) {
		var list = new ArrayList<Subject>();
		Subject g = null;
		var l1 = asList("Java","Spring","Python","jQuery","eGovframe");
		var l2 = asList("Java","Spring","Python","jQuery","eGovframe");
		for(int i=0;i<count;i++) {
			g= new Subject();
			g.setSubject(l1.get(i));
			g.setDesc(l2.get(i));
			list.add(g);
		}
    	int r= subjectMapper.insertMany(list);
    	return r;
	}
}
