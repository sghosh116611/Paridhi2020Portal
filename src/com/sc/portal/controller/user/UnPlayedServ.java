package com.sc.portal.controller.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sc.portal.dbcon.DBConnection;

/**
 * Servlet implementation class UnPlayedServ
 */
@WebServlet("/UnPlayedServ")
public class UnPlayedServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UnPlayedServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String tid = request.getParameter("tid");
		String event = request.getParameter("event");
		System.out.println(tid);
		PreparedStatement pstmt = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		java.sql.Statement st = null;
		Connection con = null;
		con = DBConnection.getConnection();
		String check_query1 = "select event1 from RD where tid=" + tid;
		String check_query2 = "select event2 from RD where tid=" + tid;
		String check_query3 = "select event3 from RD where tid=" + tid;
		try {
			st = con.createStatement();
			rs1 = st.executeQuery(check_query1);

			if (!rs1.next())
				System.out.println(" Event 1 Not there");
			else if (rs1.getString("event1").equalsIgnoreCase(event)) {
				String update_query = "update RD set played1 = 1 where tid=" + tid;
				st.executeUpdate(update_query);
				
			}
			rs1.close();
			
			rs2 = st.executeQuery(check_query2);
			if (!rs2.next())
				System.out.println(" Event 2 Not there");
			else if (rs2.getString("event2").equalsIgnoreCase(event)) {
				String update_query = "update RD set played2 = 1 where tid=" + tid;
				st.executeUpdate(update_query);
				
			}
			rs2.close();
			
			rs3 = st.executeQuery(check_query3);
			if (!rs3.next())
				System.out.println(" Event 3 Not there");
			else if (rs3.getString("event3").equalsIgnoreCase(event)) {
				String update_query = "update RD set played3 = 1 where tid=" + tid;
				st.executeUpdate(update_query);
				
			}
			rs3.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
