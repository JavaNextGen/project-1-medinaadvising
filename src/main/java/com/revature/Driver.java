package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controller.AuthController;
import com.revature.controller.ReimbursementController;
import com.revature.controller.UsersController;
import com.revature.util.ConnectionFactory;

import io.javalin.Javalin;

public class Driver {

	
    public static void main(String[] args) {
    	
    	UsersController usc = new UsersController();
    	ReimbursementController rsc = new ReimbursementController();
    	AuthController ac = new AuthController();
    	
    	try(Connection conn = ConnectionFactory.getConnection()){
			System.out.println("Connection Successful :)");
		} catch(SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
    	
    	
    	//Menu menu = new Menu();
    	
    	//menu.displayMenu();
    	
    	Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins();
				}
			).start(3000);
    	
    	app.post("/login", ac.loginHandler);
		app.get("/user",  usc.getUsersHandler);
		app.post("/user", usc.insertUserHandler);
		app.get("/user/{users_id}", usc.getUsersByIdHandler);
		app.put("/user/{users_id}", usc.updateUsersHandler);
		app.delete("/user/{users_id}", usc.deleteUsersHandler);
		
		app.get("/reimbursement",  rsc.getReimbursementHandler);
		app.post("/reimbursement", rsc.insertReimbursementHandler);
		app.get("/reimbursement/{reimb_author}", rsc.getReimbursementByIdHandler);
		app.put("/reimbursement/{reimb_id}", rsc.updateReimbursementHandler);
	}
    }

