package com.revature.repositories;

import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

public List<User> getUsers() { //This will use SQL SELECT functionality
		
		try(Connection conn = ConnectionFactory.getConnection()){ //all of my SQL stuff will be within this try block
			
			//Initialize an empty ResultSet object that will store the results of our SQL query
			ResultSet rs = null;
			
			//write the query that we want to send to the database, and assign it to a String
			String sql = "SELECT * FROM users;";
			
			//Put the SQL query into a Statement object (The Connection object has a method for this!!)
			Statement statement = conn.createStatement();
			
			//EXECUTE THE QUERY, by putting the results of the query into our ResultSet object
			//The Statement object has a method that takes Strings to execute as a SQL query
			rs = statement.executeQuery(sql);
			
			//All the code above makes a call to your database... Now we need to store the data in an ArrayList.
			
			//create an empty ArrayList to be filled with the data from the database
			List<User> userList = new ArrayList<>();
			
			//while there are results in the resultset...
			while(rs.next()) {
				
				//Use the all args constructor to create a new Employee object from each returned row from the DB
				User e = new User(
						//we want to use rs.get for each column in the record
						rs.getInt("users_id"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("f_name"),
						rs.getString("l_name"),
						rs.getString("user_email"),
						rs.getString("user_role")
						);
				
				//and populate the ArrayList with each new Employee object
				userList.add(e); //e is the new Employee object we created above
		
			}
						
			//when there are no more results in rs, the while loop will break
			//then, return the populated ArrayList of Employees
			return userList;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong selecting users!");
			e.printStackTrace();
		}
		
		return null; //we add this after the try/catch block, so Java won't yell
		//(Since there's no guarantee that the try will run)
    }

public List<User> getUserById(int id) {
	
	try(Connection conn = ConnectionFactory.getConnection()) {
		
		ResultSet rs = null;
		
		String sql = "select * from users where users_id = ?";
		
		//when we need parameters we need to use a PREPARED Statement, as opposed to a Statement (seen above)
		PreparedStatement ps = conn.prepareStatement(sql); //prepareStatment() as opposed to createStatment()
		
		//insert the methods argument (int id) as the first (and only) variable in our SQL query
		ps.setInt(1, id); //the 1 here is referring to the first parameter (?) found in our SQL String
		
		rs = ps.executeQuery();
		
		//create an empty List to be filled with the data from the database
		List<User> userList = new ArrayList<>();
		
//we technically don't need this while loop since we're only getting one result back... see if you can refactor :)
		while(rs.next()) { //while there are results in the result set...
			
		//Use the all args Constructor to create a new Employee object from each returned row...
		User e = new User(
				//we want to use rs.getXYZ for each column in the record
				rs.getInt("users_id"),
				rs.getString("username"),
				rs.getString("password"),
				rs.getString("f_name"),
				rs.getString("l_name"),
				rs.getString("user_email"),
				rs.getString("user_role")
				);
		
		//and populate the ArrayList with each new Employee object
		userList.add(e); //e is the new Employee object we created above
		}
		
		//when there are no more results in the ResultSet the while loop will break...
		//return the populated List of Employees
		return userList;
		
	} catch (SQLException e) {
		System.out.println("Something went wrong with your database!"); 
		e.printStackTrace();
	}
	return null;
}




public void insertUser(User newUser) { //This is INSERT functionality 
	
	try(Connection conn = ConnectionFactory.getConnection()){
		
		//we'll create a SQL statement using parameters to insert a new Employee
		String sql = "INSERT INTO users (username, PASSWORD, f_name, l_name, user_email, user_role ) " //creating a line break for readability
				    + "VALUES (?, ?, ?, ?, ?, ?); "; //these are parameters!! We have to specify the value of each "?"
		
		PreparedStatement ps = conn.prepareStatement(sql); //we use PreparedStatements for SQL commands with variables
		
		//use the PreparedStatement objects' methods to insert values into the query's ?s
		//the values will come from the Employee object we send in.
		ps.setString(1, newUser.getUsername());
		ps.setString(2, newUser.getPassword());
		ps.setString(3, newUser.getF_name()); //1 is the first ?, 2 is the second, etc.
		ps.setString(4, newUser.getL_name());
		ps.setString(5, newUser.getUser_email());
		ps.setString(6, newUser.getUser_role());
		
		//this executeUpdate() method actually sends and executes the SQL command we built
		ps.executeUpdate(); //we use executeUpdate() for inserts, updates, and deletes. 
		//we use executeQuery() for selects
		
		//send confirmation to the console if successul.
		System.out.println("User " + newUser.getF_name() + " created. Welcome aboard!");
		
		
	} catch(SQLException e) {
		System.out.println("Add user failed! :(");
		e.printStackTrace();
	}
}
public List<User> getUserByRole(String role) {
	
	try(Connection conn = ConnectionFactory.getConnection()) {
		
		ResultSet rs = null;
		
		String sql = "select * from users inner join roles "
			     + "on users.user_roles_id = roles.role_id where roles.user_role = ?";
		
		//when we need parameters we need to use a PREPARED Statement, as opposed to a Statement (seen above)
		PreparedStatement ps = conn.prepareStatement(sql); //prepareStatment() as opposed to createStatment()
		
		//insert the methods argument (int id) as the first (and only) variable in our SQL query
		ps.setString(1, role); //the 1 here is referring to the first parameter (?) found in our SQL String
		
		rs = ps.executeQuery();
		
		//create an empty List to be filled with the data from the database
		List<User> userList = new ArrayList<>();
		
		while(rs.next()) { //while there are results in the result set...
			
		//Use the all args Constructor to create a new Employee object from each returned row...
		User e = new User(
				//we want to use rs.getXYZ for each column in the record
				rs.getInt("users_id"),
				rs.getString("username"),
				rs.getString("password"),
				rs.getString("f_name"),
				rs.getString("l_name"),
				rs.getString("user_email"),
				rs.getString("user_role")
				);
		
		//and populate the ArrayList with each new Employee object
		userList.add(e); //e is the new Employee object we created above
		}
		
		//when there are no more results in the ResultSet the while loop will break...
		//return the populated List of Employees
		return userList;
		
	} catch (SQLException e) {
		System.out.println("Something went wrong with your database!"); 
		e.printStackTrace();
	}
	return null;
}
public User updateUser(User user) {
	try(Connection conn  = ConnectionFactory.getConnection()) {
		String sql = "UPDATE users SET username= ?, password = ?, f_name = ?, l_name = ?, user_email = ?, user_role = ?, WHERE users_id  = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getF_name());
		ps.setString(4, user.getL_name());
		ps.setString(5, user.getUser_email());
		ps.setString(6, user.getUser_role());
		ps.setInt(7, user.getUsers_id());
		
		ps.executeUpdate();
		
		String sqlCheck = "SELECT * FROM users WHERE users_id = ?";
		PreparedStatement psc = conn.prepareStatement(sqlCheck);
		
		psc.setInt(1, user.getUsers_id());
		
		ResultSet rs = psc.executeQuery();
		
		while(rs.next()) {
		
		User updatedUser = new User(
					rs.getInt("users_id"),
					rs.getString("username"),
					rs.getString("password"),
					rs.getString("f_name"),
					rs.getString("l_name"),
					rs.getString("user_email"),
					rs.getString("user_role")
				);
		return updatedUser;
		}
		
		
		
		} catch(SQLException e) {
			System.out.println("Updating has failed.");
			e.printStackTrace();
		}
	return null;
}

	public boolean deleteUser(int id) {
		try(Connection conn  = ConnectionFactory.getConnection()) {
		String sql = "delete from users WHERE users_id  = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
	
		ps.setInt(1, id);
		
		ps.executeUpdate();
		
		return true;
		
		} catch(SQLException e) {
			System.out.println("Deleting has failed.");
			e.printStackTrace();
			return false;
		}
}

}
