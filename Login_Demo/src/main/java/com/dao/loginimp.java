package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pojo.Login;
import com.util.DBConnection;

public class Loginimp {

	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int row;
	
	public Login loginSuccess(String username){
		
		Login log = null;
		
		try {
			
			con = DBConnection.getConnection();
			
			ps = con.prepareStatement("Select * from login_form where username=?");
			
			ps.setString(1, username);
			rs = ps.executeQuery();
			
			while(rs.next()) {
					log = new Login();
					log.setUsername(rs.getString(1));
					log.setPassword(rs.getString(2));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return log;
		
	}
}
