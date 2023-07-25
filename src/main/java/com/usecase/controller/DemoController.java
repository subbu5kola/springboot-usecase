package com.usecase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.model.EmployeeRequest;
import com.usecase.service.DemoService;

import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin
public class DemoController {
	
	@Autowired
	private DemoService service;
	
	@GetMapping("/welcome")
	public String getEmployee() {		
		return "welcome";		
	}
	
	@GetMapping(value="/employees/{id}/requests")
	public List<EmployeeRequest> getEmployeeRequest(@PathVariable("id") int id) {		
		return service.getEmployeeRequest(id);		
	}
	
	@GetMapping(value="/employees")
	public List<EmployeeRequest> getAllEmployeeRequest() {		
		return service.getEmployeeRequests();		
	}
	
	@PostMapping(value="/employees/{id}/requests",produces = {"application/json"}, 
		   consumes = {"application/json"})
	public EmployeeRequest saveEmployeeRequest(@PathVariable("id") int id,@RequestBody EmployeeRequest er) {
		service.saveEmployeeRequest(id,er);
		return er;		
	}
	
	@PatchMapping(value="/employees/{id}/requests/{requestId}",produces = {"application/json"},consumes = {"application/json"})
	public EmployeeRequest updateEmployeeRequest(@PathVariable("id") int id,@PathVariable("requestId") int rid,@RequestBody EmployeeRequest er) {
		service.updateEmployeeRequest(id,rid,er);
		return er;		
	}

}
