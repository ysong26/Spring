package org.zerock.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class MariaDBConnectionTest {
	private static final String DRIVER ="org.mariadb.jdbc.Driver";
	
	private static final String URL= "jdbc:mariadb://192.168.0.150:3307/book_ex";
	
	private static final String USER="java";
	
	private static final String PW="java";
	
	@Test
	public void testConnection() throws ClassNotFoundException {
		Class.forName(DRIVER);
		
		try {
			Connection con=DriverManager.getConnection(URL,USER,PW);
			System.out.println(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
}
