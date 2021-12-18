package model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Customer;

public class JdbcCustomerDao implements CustomerDao{
	JdbcManager db;	
	public JdbcCustomerDao(){		
	db = new JdbcManager();
	}
	
	@Override
	public void create(Customer customer){
		//connect to the database
		Connection con=db.getConn();
		//Create new customer object
		Customer newCustomer=customer;
		if (con!=null) {
			try {
			  Statement S1=con.createStatement();	
			  //Need to update addquery to handle password hash rather than plain text
			  String addQuery=
			"insert into customer(email, firstName, lastName, passwd,loyalty)values('"+newCustomer.getEmail()+"', '"+newCustomer.getFirstName()+"', '"+newCustomer.getLastName()+"', '"+newCustomer.getPassword()+"',0)";
	
			try {
				S1.executeUpdate(addQuery);
			}
			finally {
				S1.close();
			}
			}
			catch(Exception e) {
				System.out.println(e);
			}
				
			}
	}
	@Override
	public boolean login(String email, String password){
		Connection con=db.getConn();
		boolean isValidUser = false;
		if(con != null) {
			try {
				Statement S1=con.createStatement();
				String addQuery=
					"SELECT * FROM customer where email='" + email + "' and passwd = '" + password+"'";
				try {
					ResultSet result=S1.executeQuery(addQuery);
					try {
						if (result.next()) {
							isValidUser = true;
						}
					} finally { 
						result.close();
					}
					
				} finally {
					S1.close();
				} 
			} catch (Exception e) {
				System.out.println(e);
			} 
		}
		return isValidUser;
	}
	
	@Override
	public int findId(String email) {
		Connection con=db.getConn();
		int id = 0;
		try {
			Statement S1=con.createStatement();
			String findQuery="Select cust_id from customer where email ='"+email+"'";
			try {
				ResultSet result=S1.executeQuery(findQuery);
				try {
					if (result.next()) {
						id = result.getInt(1);
					}
				}finally {
					result.close();
				}
			} finally {
				S1.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return id;
	}
	
	
}
