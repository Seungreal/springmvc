package com.example.demo.sts.service;

import static java.util.Arrays.asList;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cmm.util.DummyGenerator;
import com.example.demo.cmm.util.Inventory;

@Service
public class SubjectService {
	@Autowired SubjectMapper subjectMapper;
	@Autowired DummyGenerator dummy;
	@Autowired Inventory<Subject> ls;
	public int insertMany(int count) {
		Subject g = null;
		var l1 = asList("Java","Spring","Python","jQuery","eGovframe");
		var l2 = asList("Java","Spring","Python","jQuery","eGovframe");
		for(int i=0;i<count;i++) {
			g= new Subject();
			g.setSubject(l1.get(i));
			g.setDesc(l2.get(i));
			ls.add(g);
		}
    	int r= subjectMapper.insertMany(ls.get());
    	return r;
	}
}
