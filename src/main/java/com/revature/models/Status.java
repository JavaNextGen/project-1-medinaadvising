package com.revature.models;


public class Status {
	
	private int reimb_status_id;
    private String reimb_status;
   
    
    
    //boilerplate code below-----------------------------------
    
    //no args
    public Status() {
        super();
        // TODO Auto-generated constructor stub
    }

    //all args
    public Status(int reimb_status_id, String reimb_status) {
        super();
        this.reimb_status_id = reimb_status_id;
        this.reimb_status = reimb_status;
      
    }
    @Override
    public String toString() {
        return "Status [reimb_status_id = " + reimb_status_id + ", reimb_status =" + reimb_status + "]";
    }

    public int getReimb_status_id() {
        return reimb_status_id;
    }

    public void setRole_id(int reimb_status_id) {
        this.reimb_status_id = reimb_status_id;
    }

    public String getReimb_status() {
        return reimb_status;
    }

    public void setUser_role(String reimb_status) {
        this.reimb_status = reimb_status;
    }

}

