package com.szafranski.springsecurity.demo.testConn;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConn {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/spring_security_demo_plaintext?useSSL=false&serverTimezone=UTC";
		String user = "springstudent";
		String pass = "springstudent";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
		
			
			System.out.println("Connection succesful!!!");
			
		} catch(Exception e) {
			System.out.println("Connection NOT succesful!!!");
			e.printStackTrace();
		}

	}


}
