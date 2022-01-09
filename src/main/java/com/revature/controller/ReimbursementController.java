package com.revature.controller;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.services.ReimbursementService;

import io.javalin.http.Handler;

public class ReimbursementController {

	ReimbursementService rs = new ReimbursementService();
	
	public Handler getReimbursementHandler = (ctx) -> {
		if(ctx.req.getSession() !=null) {
			List<Reimbursement> allReimbursement = rs.getReimbursement();
			
			Gson gson = new Gson();
			
			String JSONReimbursement = gson.toJson(allReimbursement);
			
			ctx.result(JSONReimbursement);
			ctx.status(200);
			
		} else {
			ctx.result("Oh no you failed to get the reimbursements!!!");
			ctx.status(404);
		}
	};
	
	public Handler insertReimbursementHandler = (ctx) ->{
		if(ctx.req.getSession() !=null) {
			
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			Reimbursement reimb = gson.fromJson(body, Reimbursement.class);
			
			rs.addReimbursement(reimb);
			
			ctx.result("Reimbursement was successfully added!");
			ctx.status(201);
			
		} else {
			ctx.result("Oh no you failed to add the reimbursement!!!");
			ctx.status(404);
		}
	};
	
	public Handler updateReimbursementHandler = (ctx) -> {
		if(ctx.req.getSession() !=null) {
			
			
			int reimb_id = Integer.parseInt(ctx.pathParam("reimb_id"));
			
			Gson gson = new Gson();
			
			String body = ctx.body();
			
			Reimbursement reimb_status = gson.fromJson(body, Reimbursement.class);
			
			Reimbursement UpdateStatus = rs.updateStatus(reimb_status);
			
			String JSONStatus = gson.toJson(UpdateStatus);
			
			
			ctx.result(JSONStatus);
			ctx.status(200);
			
		} else {
			ctx.result("Oh no you failed to update the status!!!");
			ctx.status(404);
		}
	};
	
	public Handler getReimbursementByIdHandler = (ctx) -> {
		if(ctx.req.getSession() !=null) {
			
			int reimb_author = Integer.parseInt(ctx.pathParam("reimb_author"));
			
			List<Reimbursement> ReimbById = rs.getReimbursementById(reimb_author);
			
			Gson gson = new Gson();
			
			
			String JSONReimbursement = gson.toJson(ReimbById);
			
			
			ctx.result(JSONReimbursement);
			ctx.status(200);
			
		} else {
			ctx.result("Oh no you failed to get your reimbursements!!!");
			ctx.status(404);
		}
	};
}
