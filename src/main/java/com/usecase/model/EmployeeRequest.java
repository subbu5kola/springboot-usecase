package com.usecase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class EmployeeRequest {
	
	public int id;
	public String name;
	public String address;
	public int account;
	public String manager;
	public String status;
	public int requestId;
	
	public EmployeeRequest() {
		
	}
	
    public EmployeeRequest(int id,String name,String address,int account,String manager,String status,int requestId) {
		this.id=id;
		this.name=name;
		this.address=address;
		this.account=account;
		this.manager=manager;
		this.status=status;
		this.requestId=requestId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}   
}
