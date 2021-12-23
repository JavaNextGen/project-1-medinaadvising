package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.util.ConnectionFactory;

public class Driver {

    public static void main(String[] args) {
    	
    	try(Connection conn = ConnectionFactory.getConnection()){
			System.out.println("Connection Successful :)");
		} catch(SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
    	
    	
    	Menu menu = new Menu();
    	
    	menu.displayMenu();
    	
    	
    }
}
