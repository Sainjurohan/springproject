package com.bway.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bway.springmvc.dao.EmployeeDao;
import com.bway.springmvc.model.Employee;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeDao edao;
	
	@RequestMapping(value = "/emp/list")
	public ResponseEntity<List<Employee>> getAllEmp() {
		
		ResponseEntity<List<Employee>> elist = new ResponseEntity<List<Employee>>(edao.getAllEmployee(),HttpStatus.OK);
		
		
		return elist;
	}
	
	
	@RequestMapping(value = "/emp/{id}")
	public ResponseEntity<Employee> getOne (@PathVariable("id") int id){
		
		ResponseEntity<Employee> emp = new ResponseEntity<Employee>(edao.getById(id) , HttpStatus.OK);
		return emp;
	}
}
