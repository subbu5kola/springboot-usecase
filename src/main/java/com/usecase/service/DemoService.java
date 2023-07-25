package com.usecase.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.usecase.model.EmployeeRequest;

@Service
public class DemoService {

	List<EmployeeRequest> employeeRequest;
	Map<Integer,List<EmployeeRequest>> employeeRequestMap;
	
	public DemoService() {
		employeeRequestMap = new HashMap<Integer,List<EmployeeRequest>>();
		
		employeeRequest = new ArrayList<EmployeeRequest>();
		employeeRequest.add(new EmployeeRequest(1,"rajesh","hyderabad",12345,"raj","",1));
		employeeRequest.add(new EmployeeRequest(1,"rajesh","hyderabad",12345,"raj","",2));
		employeeRequestMap.put(1,employeeRequest);
		
		employeeRequest = new ArrayList<EmployeeRequest>();
		employeeRequest.add(new EmployeeRequest(2,"rupesh","chennai",12347,"raj","",1));
		employeeRequest.add(new EmployeeRequest(2,"rupesh","chennai",12347,"raj","",2));
		employeeRequestMap.put(2,employeeRequest);
		}

	public List<EmployeeRequest> getEmployeeRequest(int id) {
		return employeeRequestMap.get(id);		
	}

	
	public List<EmployeeRequest> getEmployeeRequests() {		
		return employeeRequestMap.values().stream().flatMap(e->e.stream()).collect(Collectors.toList());		
	}
	
	public void saveEmployeeRequest(int id,EmployeeRequest er) {	
		 employeeRequest  =	this.employeeRequestMap.get(id);
		 if(employeeRequest==null) {
		employeeRequest = new ArrayList<EmployeeRequest>();
		 } 
		 employeeRequest.add(er);	
		 this.employeeRequestMap.put(id,employeeRequest);		
	}
	
	public void updateEmployeeRequest(int id,int rid,EmployeeRequest er) {
		employeeRequest  =	this.employeeRequestMap.get(id);

		for (EmployeeRequest ur : employeeRequest) {
		    if (ur.id==er.id && ur.requestId==er.requestId) {
		        ur.setStatus(er.getStatus());
		        break;  
		    }
		}			
	}
}
