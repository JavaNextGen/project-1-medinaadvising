package com.revature.repositories;

import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ReimbursementDAO {

public List<Reimbursement> getReimbursement() { //This will use SQL SELECT functionality
		
		try(Connection conn = ConnectionFactory.getConnection()){ //all of my SQL stuff will be within this try block
			
			//Initialize an empty ResultSet object that will store the results of our SQL query
			ResultSet rs = null;
			
			//write the query that we want to send to the database, and assign it to a String
			String sql = "SELECT * FROM reimbursement;";
			
			//Put the SQL query into a Statement object (The Connection object has a method for this!!)
			Statement statement = conn.createStatement();
			
			//EXECUTE THE QUERY, by putting the results of the query into our ResultSet object
			//The Statement object has a method that takes Strings to execute as a SQL query
			rs = statement.executeQuery(sql);
			
			//All the code above makes a call to your database... Now we need to store the data in an ArrayList.
			
			//create an empty ArrayList to be filled with the data from the database
			List<Reimbursement> reimbursementList = new ArrayList<>();
			
			//while there are results in the resultset...
			while(rs.next()) {
				
				//Use the all args constructor to create a new Employee object from each returned row from the DB
				Reimbursement e = new Reimbursement(
						//we want to use rs.get for each column in the record
						rs.getInt("reimb_id"),
						rs.getDouble("reimb_amount"),
						rs.getTimestamp("reimb_submitted"),
						rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_receipt"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id")
						);
				
				//and populate the ArrayList with each new Employee object
				reimbursementList.add(e); //e is the new Employee object we created above
		
			}
						
			//when there are no more results in rs, the while loop will break
			//then, return the populated ArrayList of Employees
			return reimbursementList;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong selecting reimbursements!");
			e.printStackTrace();
		}
		
		return null; //we add this after the try/catch block, so Java won't yell
		//(Since there's no guarantee that the try will run)
    }
public void insertReimbursement(Reimbursement newReimbursement) { //This is INSERT functionality 
	
	try(Connection conn = ConnectionFactory.getConnection()){
		
		//we'll create a SQL statement using parameters to insert a new Employee
		String sql = "INSERT INTO reimbursement (reimb_amount, reimb_description, reimb_receipt, reimb_type_id) " //creating a line break for readability
				    + "VALUES (?, ?, ?, ?); "; //these are parameters!! We have to specify the value of each "?"
		
		PreparedStatement ps = conn.prepareStatement(sql); //we use PreparedStatements for SQL commands with variables
		
		//use the PreparedStatement objects' methods to insert values into the query's ?s
		//the values will come from the Employee object we send in.
		ps.setDouble(1, newReimbursement.getReimb_amount());
		ps.setString(2, newReimbursement.getReimb_description());
		ps.setInt(3, newReimbursement.getReimb_receipt()); //1 is the first ?, 2 is the second, etc.
		ps.setInt(4, newReimbursement.getReimb_type_id());
		
		
		//this executeUpdate() method actually sends and executes the SQL command we built
		ps.executeUpdate(); //we use executeUpdate() for inserts, updates, and deletes. 
		//we use executeQuery() for selects
		
		//send confirmation to the console if successul.
		System.out.println("Reimbursement " + newReimbursement.getReimb_amount() + " submitted!");
		
		
	} catch(SQLException e) {
		System.out.println("Add reimbursement failed! :(");
		e.printStackTrace();
	}
}

public void updateStatus(String reimb_status) {
	
	try(Connection conn = ConnectionFactory.getConnection()){
		
		String sql = "update reimbursement_status set reimb_status = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		
		ps.setString(1, reimb_status);
		
		ps.executeUpdate();
		
		System.out.println(reimb_status + " status has been updated to: " + reimb_status);
		
	} catch (SQLException e) {
		System.out.println("You can't update status!!!");
		e.printStackTrace();
	}

}
}
