package com.example.demo.sym.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cmm.util.DummyGenerator;
import com.example.demo.sts.service.Grade;

@Service
public class ManagerService {
	@Autowired ManagerMapper managerMapper;
	@Autowired DummyGenerator dummy;

	public int register(Manager m) {
		return managerMapper.insert(m);
	}

	public int insertMany(int count) {
		var list = new ArrayList<Manager>();
		Manager m = null;
		for(int i=0;i<count;i++) {
			m= dummy.makeManager();
			list.add(m);
		}
    	int r= managerMapper.insertMany(list);
    	return r;
	}
    
}