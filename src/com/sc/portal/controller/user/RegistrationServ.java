package com.sc.portal.controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import com.sc.portal.controller.user.Tidgencheck;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServ
 */
@WebServlet("/RegistrationServ")
public class RegistrationServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id1 = request.getParameter("id1");
		String id2 = request.getParameter("id2");
		String id3 = request.getParameter("id3");
		String id4 = request.getParameter("id4");
		String id5 = request.getParameter("id5");
		String contact = request.getParameter("contact");
		String domain = request.getParameter("domain");
		String event = request.getParameter("event");
		String amt = request.getParameter("amt");
		int played = 0;
		
		List<String> res = new ArrayList<String>();
		
		
		Tidgencheck ob1 = new Tidgencheck();
		Tidgencheckcombo ob2 = new Tidgencheckcombo(); 
		//System.out.println(event.substring(event.indexOf(' ')));
//		if(event.substring(event.indexOf(' ')).equalsIgnoreCase(" Combo"))
//			res = ob2.getres(id1, id2, id3, id4, id5, contact, domain, event, amt, played);
	//	else
			res = ob1.getres(id1, id2, id3, id4, id5, contact, domain, event, amt, played);
		System.out.println(res);
		request.setAttribute("TID", res);
		request.getRequestDispatcher("web/tidshow.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
