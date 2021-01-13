package com.example.demo.sts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cmm.util.DummyGenerator;
@Service
public class GradeService{
	@Autowired GradeMapper gradeMapper;
	@Autowired DummyGenerator dummy;
	public int insertMany(int count) {
		for(int i=1;i<=count;i++) {
			for(int j=1;j<=5;j++) {
				gradeMapper.insert(dummy.makeGrade(i, j));
			}
		}
    	return 0;
	}
	public List<GradeVo> selectAllforExam(String examDate){
		return gradeMapper.selectJoinAll(examDate);
	}
}
