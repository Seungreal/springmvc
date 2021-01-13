package com.example.demo.sym.service;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public interface ManagerMapper {

	public int insert(Manager m);

	public Manager access(Manager m);

	public int insertMany(ArrayList<Manager> list);
    
}