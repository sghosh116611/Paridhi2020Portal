package com.sc.portal.controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * Servlet implementation class CrdServ
 */
@WebServlet("/CrdServ")
public class CrdServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrdServ() {
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
		String event = request.getParameter("event");
		String type = request.getParameter("type");
		PlayersDBUtil ob = new PlayersDBUtil();
		String html = "";
		String table_structure = "";
		ArrayList<HashMap<String, String>> Players = new ArrayList<HashMap<String, String>>();
		try {
			Players = ob.getPlayers(event, type);
			table_structure += "<table> <tr> <th>TID</th> <th>CONTACT</th> <th> PLAYED/UNPLAYED </th> </tr>";
//			if(type.equalsIgnoreCase("played"))
//			{
//				for(int i = 0; i < Players.size() ; i++)
//					html +="<tr><td>"+Players.get(i).get("tid")+"</td> <td>"+Players.get(i).get("Contact")+"</td> </tr>";
//			}
//			else
				for(int i = 0; i < Players.size() ; i++) {
					html +="<tr><td>"+Players.get(i).get("tid")+"</td> <td>"+Players.get(i).get("Contact")+"</td> <td> <button class='unplayedbutton' name='check' id='"+i+"' onclick='checked(this.id)' value='"+Players.get(i).get("tid")+"'>Click me to unplay! </button></td></tr>";
				}
				html = table_structure + html;
				
					
//			json = JSONValue.toJSONString(Players);
//			json = json.substring(1, json.length()-1);
//			json = json.replaceAll(",", " ");
//			System.out.println(json.replaceAll(":", " "));
//			response.setContentType("application/json");
//			response.getWriter().write(json);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(html);
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().write(html);
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
