package com.revature;

import java.util.List;
import java.util.Scanner;

import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.services.UserService;

public class Menu {
	
	UserDAO eDAO = new UserDAO();
	UserService us = new UserService();

	public void displayMenu() {
		
		boolean displayMenu = true;
		Scanner scan = new Scanner(System.in);
		
		//Greeting for the user
		System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Welcome to The Employee Reimbursement System (ERS)");
		System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		
		//display the menu as long as the displayMenu boolean is true
		while(displayMenu) {
			
			//menu options
			System.out.println("Hello! Please select the reimbursement type below");
			System.out.println("LODGING");
			System.out.println("TRAVEL");
			System.out.println("FOOD");
			System.out.println("ADD");
			System.out.println("USERS");
			System.out.println("EXIT");
			
			String input = scan.nextLine();
			
			/*
			 * I need to figure out a solution that will have a menu that asks what user
			 * type, then another menu that will show based on user type, once that is
			 * selected, the menus will follow the case diagram.
			 */
			switch(input) {
			
			case "LODGING":{
				System.out.println("Please enter the amount");
				String amount = scan.nextLine();
				System.out.println(amount + " to be submitted");
				System.out.println("Please give the name of where you lodged");
				String lodge = scan.nextLine();
				System.out.println(lodge + " is where you lodged");
				break;
			}
			case "TRAVEL":{
				System.out.println("Please enter the amount");
				String amount1 = scan.nextLine();
				System.out.println(amount1 + " to be submitted");
				System.out.println("Please give the name of city and state you traveled");
				String travel = scan.nextLine();
				System.out.println(travel + " is where you traveled");
				break;
			}
			case "FOOD":{
				System.out.println("Please enter the amount");
				String amount2 = scan.nextLine();
				System.out.println(amount2 + " to be submitted");
				System.out.println("Please give the name of where you ate");
				String food = scan.nextLine();
				System.out.println(food + " is where you ate");
				break;
			}
			case "ADD":{
				//we need to prompt the user for the employee's name, and their role_id
				System.out.println("Enter Employee First Name");
				String f_name = scan.nextLine();
				
				System.out.println("Enter Employee Last Name");
				String l_name = scan.nextLine();
				
				System.out.println("Enter Role Id: 1) Finance Manager 2) Employee");
				int roleId = scan.nextInt(); //we need nextInt because ID is an int datatype in the database
				scan.nextLine(); //without any nextLine(), your enter keystroke will be grabbed as the next input
				//so we need nextLine() in order to actually move to the..... NEXT line!
				
				//Given all this information, we'll create a new Employee object to send to the service layer
				//then the service layer will send it to the repository layer.
				User newEmployee = new User(f_name, l_name, roleId);
				
				//Put the new Employee into the addEmployee() method in the EmployeeService Class
				us.addEmployee(newEmployee);
				break;
			}
			case "USERS" :{
				//get the List of employees from the repository layer
				List<User> users = eDAO.getEmployees();
				
				//enhanced for loop to print out the Employees one by one
				for (User e : users) {
					System.out.println(e);
			}
				break;
			}
			case "EXIT":{
				displayMenu = false;
				break;
			}
		
			}
			
		}
		
		
	}
	
}
