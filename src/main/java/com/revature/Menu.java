package com.revature;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.repositories.ReimbursementDAO;
import com.revature.repositories.UserDAO;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;

public class Menu {
	
	UserDAO eDAO = new UserDAO();
	UserService us = new UserService();
	ReimbursementDAO eDAO1 = new ReimbursementDAO();
	ReimbursementService ri = new ReimbursementService();

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
			System.out.println("1 -> USERS");
			System.out.println("2 -> ADD USER");
			System.out.println("3 -> REIMBURSEMENT REQUEST");
			System.out.println("4 -> REIMBURSEMENT STATUS");
			System.out.println("5 -> FINANCE MANAGER APPROVAL");
			System.out.println("6 -> EXIT");
			
			String input = scan.nextLine();
			
			
			switch(input) {
			
			case "5":{
				System.out.println("Please enter the amount");
				String amount = scan.nextLine();
				System.out.println(amount + " to be submitted");
				System.out.println("Please give the name of where you lodged");
				String lodge = scan.nextLine();
				System.out.println(lodge + " is where you lodged");
				break;
			}
			case "4":{
				System.out.println("Please enter the amount");
				String amount1 = scan.nextLine();
				System.out.println(amount1 + " to be submitted");
				System.out.println("Please give the name of city and state you traveled");
				String travel = scan.nextLine();
				System.out.println(travel + " is where you traveled");
				break;
			}
			case "3":{
				System.out.println("Enter the amount for reimbursement");
				double reimb_amount = scan.nextDouble();
				scan.nextLine();
				
				System.out.println("Enter the description of reimbursement");
				String reimb_description = scan.nextLine();
				
				System.out.println("Did you attach receipt: 1) Yes 2) No");
				int reimb_receipt = scan.nextInt();
				scan.nextLine();
				
				System.out.println("Select the type of expense: 1) LODGING 2) TRAVEL 3) FOOD 4) OTHER");
				int reimb_type_id = scan.nextInt();
				scan.nextLine();
				
				//without any nextLine(), your enter keystroke will be grabbed as the next input
				//so we need nextLine() in order to actually move to the..... NEXT line!
				
				//Given all this information, we'll create a new Employee object to send to the service layer
				//then the service layer will send it to the repository layer.
				Reimbursement newReimbursement = new Reimbursement(reimb_amount, reimb_description, reimb_receipt, reimb_type_id);
				
				//Put the new Employee into the addEmployee() method in the EmployeeService Class
				ri.addReimbursement(newReimbursement);
				break;
			}
			case "2":{
				//we need to prompt the user for the employee's name, and their role_id
				System.out.println("Enter username");
				String username = scan.nextLine();
				
				System.out.println("Enter password");
				String password = scan.nextLine();
				
				System.out.println("Enter Users First Name");
				String f_name = scan.nextLine();
				
				System.out.println("Enter Users Last Name");
				String l_name = scan.nextLine();
				
				System.out.println("Enter email");
				String user_email = scan.nextLine();
				
				System.out.println("Enter Role Id: 1) Finance Manager 2) Employee");
				int role_id = scan.nextInt(); //we need nextInt because ID is an int datatype in the database
				scan.nextLine(); //without any nextLine(), your enter keystroke will be grabbed as the next input
				//so we need nextLine() in order to actually move to the..... NEXT line!
				
				//Given all this information, we'll create a new Employee object to send to the service layer
				//then the service layer will send it to the repository layer.
				User newUser = new User(username, password, f_name, l_name, user_email, role_id);
				
				//Put the new Employee into the addEmployee() method in the EmployeeService Class
				us.addUser(newUser);
				break;
			}
			case "1" :{
				//get the List of employees from the repository layer
				List<User> users = eDAO.getUsers();
				
				//enhanced for loop to print out the Employees one by one
				for (User e : users) {
					System.out.println(e);
			}
				break;
			}
			case "6":{
				displayMenu = false;
				break;
			}
		
			}
			
		}
		
		
	}
	
}
