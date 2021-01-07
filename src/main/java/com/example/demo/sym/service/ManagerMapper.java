package com.example.demo.sym.service;

import org.springframework.stereotype.Repository;

@Repository
public interface ManagerMapper {

	public int insert(Manager m);

	public Manager access(Manager m);
    
}