package com.kitri.visitor.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
//	private static DBconnect singleton = null;
	private static Connection conn;
	
	
	public static Connection getConnection() {
		String user = "kitri64";
		String password = "kitri64";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		try {
			if(conn !=null && !conn.isClosed()) {
				return conn;
			}
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc.jar 확인필요");
//			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("url,user,password 확인필요");
//			e.printStackTrace();
		}
		System.out.println("DB연결");
		return conn;
	}
	
}
