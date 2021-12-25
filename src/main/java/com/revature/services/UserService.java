package com.revature.services;

import com.revature.models.User;
import com.revature.repositories.UserDAO;

public class UserService {

UserDAO eDAO = new UserDAO(); //so that I can use the methods from the EmployeeDAO
	
	public void addUser(User newUser) {
		
		//take in the Employee object sent from the menu and send it to the EmployeeDAO to be inserted into the database
		
		//call the DAO method that inserts the new Employee
		eDAO.insertUser(newUser);
	}
}
