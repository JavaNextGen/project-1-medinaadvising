--This schema 

CREATE TABLE roles(
	role_id serial PRIMARY KEY,
	user_role varchar(100)
);

CREATE TABLE users(
	users_id serial PRIMARY KEY,
	username varchar(50) UNIQUE,
	PASSWORD varchar(50),
	f_name varchar(100),
	l_name varchar(100),
	user_email varchar(150) UNIQUE,
	user_role TEXT,
	user_roles_id int REFERENCES roles (role_id) --FOREIGN KEY: note the REFERENCES key
);

CREATE TABLE reimbursement_type(
	reimb_type_id serial PRIMARY KEY,
	reimb_type varchar(100)
);

CREATE TABLE reimbursement_status(
	reimb_status_id serial PRIMARY KEY,
	reimb_status varchar(100)
);

CREATE TABLE reimbursement(
	reimb_id serial PRIMARY KEY,
	reimb_amount int,
	reimb_submitted TEXT,
	reimb_description varchar(250),
	reimb_receipt TEXT,
	reimb_type TEXT,
	reimb_author int REFERENCES users(users_id),
	reimb_resolver int REFERENCES users(users_id),
	reimb_status_id int REFERENCES reimbursement_status(reimb_status_id),
	reimb_type_id int REFERENCES reimbursement_type(reimb_type_id) 
);

DROP TABLE reimbursement CASCADE;

INSERT INTO 

INSERT INTO roles (user_role)
VALUES ('Employee'),
	   ('Finance Manager');
	   
	   
SELECT * FROM reimbursement;

INSERT INTO users (username, PASSWORD, f_name, l_name, user_email, user_role)
VALUES ('jose.medina', 'password', 'Jose', 'Medina', 'jose.medina@revature.com', 'Employee');
	  
	   
SELECT * FROM users;

INSERT INTO reimbursement_type (reimb_type)
VALUES ('LODGING'),
		('TRAVEL'),
		('FOOD'),
		('OTHER');

INSERT INTO reimbursement_status (reimb_status)
VALUES ('PENDING'),
		('APPROVED'),
		('DENIED');
	
SELECT * FROM reimbursement_type;

INSERT INTO reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_receipt, reimb_type, reimb_author)
VALUES (25.50, '2016-06-22 19:10:25-07', 'Eating out', 1, 1);


