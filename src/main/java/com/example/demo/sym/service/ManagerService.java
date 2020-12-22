  
package com.example.demo.sym.service;

import com.example.demo.sym.service.model.ManagerDTO;

import org.springframework.stereotype.Component;

@Component
public interface ManagerService {

	public int register(ManagerDTO m);
    
}