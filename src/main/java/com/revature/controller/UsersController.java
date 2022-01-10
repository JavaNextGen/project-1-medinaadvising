package com.revature.controller;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.User;
import com.revature.services.UserService;

import io.javalin.http.Handler;

public class UsersController {
	
		UserService us = new UserService();
		
		public Handler getUsersHandler = (ctx) -> {
			if(ctx.req.getSession(true) !=null) {
				List<User> allUsers = us.getUsers();
				
				Gson gson = new Gson();
				
				String JSONUsers = gson.toJson(allUsers);
				
				ctx.result(JSONUsers);
				ctx.status(200);
				
			} else {
				ctx.result("Oh no you failed to get the users!!!");
				ctx.status(404);
			}
		};

		public Handler insertUserHandler = (ctx) ->{
			if(ctx.req.getSession(true) !=null) {
				
				String body = ctx.body();
				
				Gson gson = new Gson();
				
				User user = gson.fromJson(body, User.class);
				
				us.addUser(user);
				
				ctx.result("User was successfully added!");
				ctx.status(201);
				
			} else {
				ctx.result("Oh no you failed to add the user!!!");
				ctx.status(404);
			}
		};

		
		
		public Handler getUsersByIdHandler = (ctx) -> {
			if(ctx.req.getSession(true) !=null) {
				
				int users_id = Integer.parseInt(ctx.pathParam("users_id"));
				
				List<User> UsersById = us.getUserById(users_id);
				
				Gson gson = new Gson();
				
				
				String JSONEmployees = gson.toJson(UsersById);
				
				
				ctx.result(JSONEmployees);
				ctx.status(200);
				
			} else {
				ctx.result("Oh no you failed to get the employees!!!");
				ctx.status(404);
			}
		};

		
		
		public Handler updateUsersHandler = (ctx) -> {
			if(ctx.req.getSession(true) !=null) {
				
				
				int users_id = Integer.parseInt(ctx.pathParam("users_id"));
				
				Gson gson = new Gson();
				
				String body = ctx.body();
				
				User user = gson.fromJson(body, User.class);
				
				User UpdateUser = us.updateUser(user);
				
				String JSONEmployees = gson.toJson(UpdateUser);
				
				
				ctx.result(JSONEmployees);
				ctx.status(200);
				
			} else {
				ctx.result("Oh no you failed to update the employee!!!");
				ctx.status(404);
			}
		};
		public Handler deleteUsersHandler = (ctx) -> {
			if(ctx.req.getSession(true) !=null) {
				
				int users_id = Integer.parseInt(ctx.pathParam("users_id"));
				
				boolean DeleteUser = us.deleteUser(users_id);
				
				Gson gson = new Gson();
				
				
				String JSONUsers = gson.toJson(DeleteUser);
				
				
				ctx.result(JSONUsers);
				ctx.status(200);
				
			} else {
				ctx.result("Oh no you failed to delete the employee!!!");
				ctx.status(404);
			}
		};

	}