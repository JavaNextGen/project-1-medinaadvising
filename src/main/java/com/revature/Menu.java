package com.revature;

import java.util.List;
import java.util.Scanner;

import com.revature.models.User;
import com.revature.repositories.UserDAO;

public class Menu {
	
	UserDAO eDAO = new UserDAO();

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
			System.out.println("OTHER");
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
			case "OTHER":{
				System.out.println("Please enter the amount");
				String amount3 = scan.nextLine();
				System.out.println(amount3 + " to be submitted");
				System.out.println("Please give a description of reimbursement");
				String other = scan.nextLine();
				System.out.println(other + " is the reimbursement");
				break;
			}
			case "USERS" :{
				//get the List of employees from the repository layer
				List<User> users = eDAO.getEmployees();
				
				//enhanced for loop to print out the Employees one by one
				for (User e : users) {
					System.out.println(e);
			}
			}
			case "EXIT":{
				displayMenu = false;
				break;
			}
		
			}
			scan.close();
		}
		
		
	}
	
}
