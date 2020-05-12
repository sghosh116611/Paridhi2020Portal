package com.sc.portal.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBConnection {
	
	private static Connection conn = null;
	
	static {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded!");
		}
		catch (Exception e) {
			System.out.println("Driver not found");
		}
	}
	
	public static Connection getConnection()
	{
		String url = "jdbc:mysql://localhost:3306/portal";
		String admin = "root";
		String password = "Redhat1234#";
		
		try {
			conn = DriverManager.getConnection(url, admin, password);
			System.out.println("Data Base connection is done!!");
		}
		catch (Exception e) {
			System.out.println("Data Base COnnection Not done");
		}
		return conn;
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public static void close(PreparedStatement pstmt) {
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	

}

/*public class DBConnection {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// System.out.println("Driver is loaded");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = null;
		Statement st = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/saree", "root", "Redhat1234#");
			System.out.println("database connection is done");
			String query = "select * from Vendor";
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				String name = rs.getString("name");
				System.out.println(name);
			}
			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// return con;
	}

}*/

