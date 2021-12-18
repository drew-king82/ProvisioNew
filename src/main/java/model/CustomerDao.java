package model;

import beans.Customer;

public interface CustomerDao{
	//create customer
	void create(Customer customer);
	//find customer by id
	
	boolean login(String email, String password);
	
	int findId(String email);
	}