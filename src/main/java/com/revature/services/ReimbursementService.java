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

	public List<Reimbursement> getReimbursement() {
	
	//get the List of Employees by calling the DAO method that selects them from the database
	List<Reimbursement> reimbursement = rDAO.getReimbursement();
	
	//return the list of employees
	return reimbursement;
}
	
	public void addReimbursement(Reimbursement newReimbursement) {
		
		//take in the Reimbursement object sent from the menu and send it to the ReimbursementDAO to be inserted into the database
		
		//call the DAO method that inserts the new Reimbursement
		rDAO.insertReimbursement(newReimbursement);
	}
	public Reimbursement updateStatus(Reimbursement reimb_status_id) {
		
		rDAO.updateStatus(reimb_status_id);
		
		return reimb_status_id;
		
	}

	public List<Reimbursement> getReimbursementById(int id) {
		
		List<Reimbursement> reimbById= rDAO.getReimbursementById(id);
		
		return reimbById;
	}
    
}
