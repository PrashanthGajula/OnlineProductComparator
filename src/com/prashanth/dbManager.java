package com.prashanth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbManager {
	
	public static void Insert(GettersSetters set)throws ClassNotFoundException,SQLException{ 
		Connection conn= connectionManager.getInstance().openConnection();
		Class.forName("com.mysql.jdbc.Driver");
		String sql="INSERT INTO regusers(email,password,name,gender,age,contact) VALUES(?,?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, set.getEmail());
		pstmt.setString(2, set.getPassword());
		pstmt.setString(3,set.getName());		
		pstmt.setString(4, set.getGender());
		pstmt.setString(5, set.getAge());
		pstmt.setString(6, set.getContact());
		
		pstmt.executeUpdate();
		connectionManager.getInstance().close();
		
	}
	
	public static int checkUser(GettersSetters get) throws ClassNotFoundException,SQLException{
		Connection conn= connectionManager.getInstance().openConnection();
		Class.forName("com.mysql.jdbc.Driver");
		String sql="Select count(*) FROM regusers where email=? and password=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,get.getEmail());
		pstmt.setString(2, get.getPassword());
		ResultSet rs=pstmt.executeQuery();
		int count=0;
		while(rs.next()){
			count=rs.getInt(1);
			
		}
		connectionManager.getInstance().close();
		return count;
		
	}

}
