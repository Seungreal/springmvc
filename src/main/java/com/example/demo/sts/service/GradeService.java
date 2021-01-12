package com.example.demo.sts.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cmm.util.DummyGenerator;
@Service
public class GradeService{
	@Autowired GradeMapper gradeMapper;
	@Autowired DummyGenerator dummy;
	public int insertMany(int count) {
		var list = new ArrayList<Grade>();
		Grade g = null;
		for(int i=0;i<count;i++) {
			g= dummy.makeGrade();
			g.setStuNum(i+1);
			list.add(g);
		}
    	int r= gradeMapper.insertMany(list);
    	return r;
	}
}
