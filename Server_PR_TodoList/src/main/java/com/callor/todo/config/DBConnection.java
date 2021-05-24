package com.callor.todo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection DBConn ;
	
	static {
		
		String dbDriver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "todoUser";
		String password= "todoUser";
		
		try {
			Class.forName(dbDriver);
			DBConn = DriverManager.getConnection(url, user, password);
			System.out.println("DB 접속 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("DB Driver를 찾을 수 없음");
		} catch (SQLException e) {
			System.out.println("DB 접속정보 찾을 수 없음");
		}
		
	}
	
	public static Connection getDBConnection() {
		return DBConn;
	}
	
	
}
