package com.revature.models;

//This Class represents the employees table in our database
public class User {

	//fields for the employee class - must match those in your database
	private int users_id;
	private String username;
	private String password;
	private String f_name;
	private String l_name;
	private String user_email;
	private int user_roles_id;
	
	
	//boilerplate code below------------------------------
	
	//no args constructor
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all args constructor
	public User(int users_id, String username, String password, String f_name, String l_name, String user_email, int user_roles_id) {
		super();
		this.users_id = users_id;
		this.username = username;
		this.password = password;
		this.f_name = f_name;
		this.l_name = l_name;
		this.user_email = user_email;
		this.user_roles_id = user_roles_id;
	}

	//all args MINUS the employee_id primary key... WHY?
	//we will eventually want the capability to add employees... and the employee_id auto increments!!!
	public User(String username, String password, String f_name, String l_name, String user_email, int user_roles_id) {
		super();
		this.username = username;
		this.password = password;
		this.f_name = f_name;
		this.l_name = l_name;
		this.user_email = user_email;
		this.user_roles_id = user_roles_id;
	}

	//so our Employee objects can be printed out - returns a String describing the object
	@Override
	public String toString() {
		return "Users [users_id = " + users_id + ", username = " + username + ", password = " + password + ", f_name = " + f_name + ", l_name=" + l_name + ", user_email = " + user_email + ", user_roles_id = " + user_roles_id + "]";
	}

	//getters and setters so that we can access and change the private variables up above 
	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public int getUser_roles_id() {
		return user_roles_id;
	}

	public void setUser_roles_id(int user_roles_id) {
		this.user_roles_id = user_roles_id;
	}

	
	//hashcode and equals are necessary if we want to compare (test the equality of) our objects 
	//"Equals/hashcode/toString from the object class initially refer to default memory values
	//but you customize a class to describe and compare itself based off its implementation" - Peter 2021
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + users_id;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((f_name == null) ? 0 : f_name.hashCode());
		result = prime * result + ((l_name == null) ? 0 : l_name.hashCode());
		result = prime * result + ((user_email == null) ? 0 : user_email.hashCode());
		result = prime * result + user_roles_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (users_id != other.users_id)
			return false;
		if (f_name == null) {
			if (other.f_name != null)
				return false;
		} else if (!f_name.equals(other.f_name))
			return false;
		if (user_roles_id != other.user_roles_id)
			return false;
		return true;
	}
}