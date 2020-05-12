package com.sc.portal.controller.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;


import com.sc.portal.dbcon.DBConnection;

public class PlayersDBUtil {
	public ArrayList<HashMap<String, String>> getPlayers(String event, String type) throws Exception {
		HashMap<String, String> Players = new HashMap<>();
		ArrayList<HashMap<String, String>> list =new ArrayList<HashMap<String,String>>(); 

		int flag = 0;
		if (type.equalsIgnoreCase("played"))
			flag = 1;

		Connection myConn = null;
		java.sql.Statement myStm = null;
		ResultSet myRs = null;
		try {
			myConn = DBConnection.getConnection();
			String sql = "Select tid,contact from RD where event1='" + event + "' and played1 =" + flag + " or event2='"
					+ event + "' and played2 =" + flag + " or event3='" + event + "' and played3 =" + flag;

			myStm = myConn.createStatement();

			myRs = myStm.executeQuery(sql);

			System.out.println("query is executed!");

			while (myRs.next()) {
//				System.out.println("I am in loop");
				String tid = myRs.getString("tid");
				String contact = myRs.getString("contact");
				// boolean played = myRs.getBoolean("played");

				// Players tempPlayer = new Players(tid, played);

				// if(played == false)
				// {
				// Players.add(tempPlayer);
				//
				// }
				Players = new HashMap<String, String>();
				Players.put("tid",tid);
				Players.put("Contact", contact);
				list.add(Players);
				
				

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(list);
		
		return list;
		// finally {
		// close(myConn, myStm, myRs);
		// }
	}

	// private void close(Connection myConn, Statement myStm, ResultSet myRs) {
	// try {
	// if(myRs != null)
	// myRs.close();
	//
	// if(myStm != null)
	// myStm.close();
	//
	// if(myConn != null)
	// myConn.close();
	// }
	// catch(Exception exc){
	// exc.printStackTrace();
	// }
	//
	//
}
