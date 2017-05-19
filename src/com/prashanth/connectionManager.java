package com.prashanth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionManager {
	
	private static connectionManager instance=null;
	private final String USERNAME="root";
	private final String PASSWORD="password";
	private final String CONN_STRING="jdbc:mysql://localhost/userlogindb";
	private Connection conn=null;
	private connectionManager(){
		
		
	}
	public static connectionManager getInstance(){
		if(instance==null)
		{
			instance=new connectionManager();
			
		}
		return instance;
		
	}


	public Connection openConnection(){
		try{	
			System.out.println("Connection opened");
		conn=DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
		}
		catch(SQLException e)
		{ e.printStackTrace();
			}
		
return conn;
		} 


public void close(){
	
	try{
		System.out.println("Closing connection");
		conn.close();
	}catch(SQLException e){
		e.printStackTrace();
	}
	
}

}
