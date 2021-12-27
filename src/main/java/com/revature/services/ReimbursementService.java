package com.revature.services;

import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.repositories.ReimbursementDAO;
import com.revature.repositories.UserDAO;

import java.util.Collections;
import java.util.List;


public class ReimbursementService {

ReimbursementDAO rDAO = new ReimbursementDAO(); 
	
	public void addReimbursement(Reimbursement newReimbursement) {
		
		//take in the Reimbursement object sent from the menu and send it to the ReimbursementDAO to be inserted into the database
		
		//call the DAO method that inserts the new Reimbursement
		rDAO.insertReimbursement(newReimbursement);
	}
	public void updateStatus(String reimb_status) {
		
		rDAO.updateStatus(reimb_status);
		
	}
    
}
