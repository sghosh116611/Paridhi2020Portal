package com.sc.portal.controller.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;
import com.sc.portal.dbcon.DBConnection;




/**
 * Servlet implementation class UserAddServ
 */
@WebServlet("/UserAddServ")
public class UserAddServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAddServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String first_name =  request.getParameter("first_name");
		String middle_name =  request.getParameter("middle_name");
		String last_name =  request.getParameter("last_name");
		String contact =  request.getParameter("contact");
		String email =  request.getParameter("email");
		String dob =  request.getParameter("dob");
		String year =  request.getParameter("year");
		String sex =  request.getParameter("optradio");
		
		Connection con = null;

		boolean flag = false;

		try {
			con = DBConnection.getConnection();
		} catch (Exception ee) {
			System.out.println("Connection not made!");
		}

		PreparedStatement pstmt = null;
		java.sql.Statement st = null;
		String gid = "";
		try {
			pstmt = con.prepareStatement("insert into MRD(first_name,middle_name,last_name,contact1,email,year,dob)values(?,?,?,?,?,?,?)");
			//pstmt.setInt(1, 8);
			pstmt.setString(1, first_name);
			pstmt.setString(2, middle_name);
			pstmt.setString(3, last_name);
			pstmt.setString(4, contact);
			pstmt.setString(5, email);
			pstmt.setString(6, year);
			pstmt.setString(7, dob);

			pstmt.executeUpdate();
			System.out.println("Executed insertion");
			
			String query = "SELECT gid FROM MRD WHERE email = '"+email+"' ORDER BY gid DESC LIMIT 0,1";
			System.out.println(query);
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				gid = rs.getString("gid");
				System.out.println(gid);
			}
			
			flag = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (flag) {
			request.setAttribute("gid", gid);
			request.getRequestDispatcher("web/gidshow.jsp").forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("web/mrd.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
