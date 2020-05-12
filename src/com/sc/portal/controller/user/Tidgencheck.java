package com.sc.portal.controller.user;

import java.sql.Connection;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.mysql.jdbc.Statement;

import com.sc.portal.dbcon.DBConnection;

public class Tidgencheck {

	public List<String> getres(String id1, String id2, String id3, String id4, String id5, String contact,
			String domain, String event, String amt, int played) {

		List<String> res = new ArrayList<String>();
		List<String> participants = new ArrayList<String>();
		String tid = "";

		Map<String, List<String>> combo = new HashMap<String, List<String>>();
		List<String> coding = new ArrayList<String>();
		List<String> robotics1 = new ArrayList<String>();
		List<String> robotics2 = new ArrayList<String>();
		List<String> civil = new ArrayList<String>();
		List<String> general = new ArrayList<String>();
		
		robotics1.add("Irons Heart");
		robotics1.add("Dawn of Justice");
		robotics1.add("Quatro Claw Fight");
		
		robotics2.add("Robo Clash Royale(onspot)");
		robotics2.add("Coloured Stack");
		robotics2.add("Optimus Line");
		
		civil.add("Track O Treasure");
		civil.add("Setu Bandhan");
		civil.add("NULL");
		
		combo.put(domain, coding);
		combo.put(domain,civil);
		combo.put("Robotics1", robotics1);
		combo.put("Robotics2", robotics2);
		
		
		
		boolean row_present = true;
		boolean is_present1 = true;
		boolean is_present2 = true;
		boolean is_present3 = true;
		boolean is_present4 = true;
		boolean is_present5 = true;
		
		if(id1.equalsIgnoreCase("null") || id1.equalsIgnoreCase(" "))
			is_present1 = false;
		if(id2.equalsIgnoreCase("null")|| id2.equalsIgnoreCase(" "))
			is_present2 = false;
		if(id3.equalsIgnoreCase("null") || id3.equalsIgnoreCase(" "))
			is_present3 = false;
		if(id4.equalsIgnoreCase("null") || id4.equalsIgnoreCase(" "))
			is_present4 = false;
		if(id5.equalsIgnoreCase("null") || id5.equalsIgnoreCase(" "))
			is_present5 = false;
		
		Connection con = null;
		try {
			con = DBConnection.getConnection();
		} catch (Exception ee) {
			System.out.println(ee);
		}

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		java.sql.Statement st = null;
		String query = "";
		if (event.substring(event.indexOf(' ') + 1).equalsIgnoreCase("Combo")) {
			// System.out.println("True");
			if(domain.equalsIgnoreCase("Robotics"))
				if(event.equalsIgnoreCase("Robotics1 Combo"))
					domain+="1";
				else 
					if(event.equalsIgnoreCase("Robotics2 Combo"))
						domain+="2";
			query = "select exists(select * from RD where event1='" + combo.get(domain).get(0) + "')";
		} else
			query = "select exists(select * from RD where event1='" + event + "' or event2='" + event + "' event3='"
					+ event + "')";
		 System.out.println(query);

		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next())
				if (rs.getString(query.substring(7)).equals("1"))
					System.out.println("Row is there");
				else {
					row_present = false;
					System.out.println("Row is not there");
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean combo_val = true;
		try {
			if (row_present == false) {
				String insert_query = "";
				if (event.substring(event.indexOf(' ') + 1).equalsIgnoreCase("Combo")) {
					insert_query = "insert into RD(gid1,gid2,gid3,gid4,gid5,contact,domain,event1,event2,event3,amt,played1,played2,played3) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				}

				else {
					combo_val = false;
					insert_query = "insert into RD(gid1,gid2,gid3,gid4,gid5,contact,domain,event1,amt,played1) values(?,?,?,?,?,?,?,?,?,?)";
				}

				if (combo_val) {
					pstmt = con.prepareStatement(insert_query);
					pstmt.setString(1, id1);
					pstmt.setString(2, id2);
					pstmt.setString(3, id3);
					pstmt.setString(4, id4);
					pstmt.setString(5, id5);
					pstmt.setString(6, contact);
					pstmt.setString(7, domain);
					int k = 8;
					for (int i = 0; i < combo.get(domain).size(); i++) {
						pstmt.setString(k, combo.get(domain).get(i));
						k++;
					}

					pstmt.setString(11, amt);
					pstmt.setInt(12, 0);
					pstmt.setInt(13, 0);
					pstmt.setInt(14, 0);

					pstmt.executeUpdate();
					System.out.println("Values inserted for the first domain event under combo!!");

					String sql = "select tid from RD where gid1='" + id1 + "' and gid2='" + id2 + "'and gid3='" + id3
							+ "'and gid4='" + id4 + "'and gid5='" + id5 + "'and event1='" + combo.get(domain).get(0)
							+ "'";
					try {
						st = con.createStatement();
						rs2 = st.executeQuery(sql);
						while (rs2.next()) {
							tid = rs2.getString("tid");
							System.out.println(tid);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					System.out.println("TID IS RETURNED FOR combo!!");
					res.add(tid);
				} else {
					pstmt = con.prepareStatement(insert_query);
					pstmt.setString(1, id1);
					pstmt.setString(2, id2);
					pstmt.setString(3, id3);
					pstmt.setString(4, id4);
					pstmt.setString(5, id5);
					pstmt.setString(6, contact);
					pstmt.setString(7, domain);
					pstmt.setString(8, event);
					pstmt.setString(9, amt);
					pstmt.setInt(10, 0);

					pstmt.executeUpdate();
					System.out.println("Values inserted for the first domain event!!");

					// String tid = getTeamID(id1, id2, id3, id4, id5, event);
					String sql = "select tid from RD where gid1='" + id1 + "' and gid2='" + id2 + "'and gid3='" + id3
							+ "'and gid4='" + id4 + "'and gid5='" + id5 + "'and event1='" + event + "'";
					try {
						st = con.createStatement();
						rs2 = st.executeQuery(sql);
						while (rs2.next()) {
							tid = rs2.getString("tid");
							System.out.println(tid);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					System.out.println("TID IS RETURNED!!");
					res.add(tid);
				}
			} else {
				System.out.println(event);
				boolean combo_selection = true;
				String select_query = "";
				if (event.substring(event.indexOf(' ') + 1).equalsIgnoreCase("Combo"))
					select_query = "select gid1,gid2,gid3,gid4,gid5 from RD where event1='" + combo.get(domain).get(0)
							+ "' or event2='"+combo.get(domain).get(1)+"' or event3='"+combo.get(domain).get(2)+"'";
				else {
					select_query = "select gid1,gid2,gid3,gid4,gid5 from RD where event1='" + event + "' or event2='"
							+ event + "' or event3='" + event + "'";
					combo_selection = false;
				}
				System.out.println("Not combo");
				st = con.createStatement();
				rs2 = st.executeQuery(select_query);
				System.out.println("query executed!");
				while (rs2.next()) {
					String gid1 = rs2.getString("gid1");
					String gid2 = rs2.getString("gid2");
					String gid3 = rs2.getString("gid3");
					String gid4 = rs2.getString("gid4");
					String gid5 = rs2.getString("gid5");

					participants.add(gid1);
					participants.add(gid2);
					participants.add(gid3);
					participants.add(gid4);
					participants.add(gid5);
					System.out.println("I am in Participants part");
					System.out.println(participants);
				}
				if (id1.equalsIgnoreCase("null") == false) {
					boolean pr1 = participants.contains(id1);
					System.out.println(pr1);
					if (pr1 == true) {
						res.add("GID 1 is present");
						System.out.println("Added to res");
					} else {
						is_present1 = false;
						System.out.println("false");
					}
				}
				if (id2.equalsIgnoreCase("null") == false) {
					boolean pr2 = participants.contains(id2);
					if (pr2 == true)
						res.add("GID 2 is present");
					else
						is_present2 = false;
				}
				if (id3.equalsIgnoreCase("null") ==  false) {
					boolean pr3 = participants.contains(id3);
					if (pr3 == true)
						res.add("GID 3 is present");
					else
						is_present3 = false;
				}
				if (id4.equalsIgnoreCase("null") ==  false) {
					boolean pr4 = participants.contains(id4);
					if (pr4 == true)
						res.add("GID 4 is present");
					else
						is_present4 = false;
				}
				if (id5.equalsIgnoreCase("null") ==  false) {
					boolean pr5 = participants.contains(id5);
					if (pr5 == true)
						res.add("GID 5 is present");
					else
						is_present5 = false;
				}
				if (is_present1 == false && is_present2 == false && is_present3 == false && is_present4 == false
						&& is_present5 == false) {
					if (combo_selection == false) {
						System.out.println("Done");
						pstmt = con.prepareStatement(
								"insert into RD(gid1,gid2,gid3,gid4,gid5,contact,domain,event1,amt,played1) values (?,?,?,?,?,?,?,?,?,?)");
						pstmt.setString(1, id1);
						pstmt.setString(2, id2);
						pstmt.setString(3, id3);
						pstmt.setString(4, id4);
						pstmt.setString(5, id5);
						pstmt.setString(6, contact);
						pstmt.setString(7, domain);
						pstmt.setString(8, event);
						pstmt.setString(9, amt);
						pstmt.setInt(10, 0);
						pstmt.executeUpdate();
						System.out.println("Done");
						String sql = "select tid from RD where gid1='" + id1 + "' and gid2='" + id2 + "'and gid3='"
								+ id3 + "'and gid4='" + id4 + "'and gid5='" + id5 + "'and event1='" + event + "'";
						try {
							st = con.createStatement();
							rs = st.executeQuery(sql);
							while (rs.next()) {
								tid = rs.getString("tid");
								System.out.println(tid);
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						System.out.println("TID IS RETURNED WAFTER CHECKING!!");
						res.add(tid);
					} else {
						pstmt = con.prepareStatement(
								"insert into RD(gid1,gid2,gid3,gid4,gid5,contact,domain,event1,event2,event3,amt,played1,played2,played3) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
						pstmt.setString(1, id1);
						pstmt.setString(2, id2);
						pstmt.setString(3, id3);
						pstmt.setString(4, id4);
						pstmt.setString(5, id5);
						pstmt.setString(6, contact);
						pstmt.setString(7, domain);
						int k = 8;
						for (int i = 0; i < combo.get(domain).size(); i++) {
							pstmt.setString(k, combo.get(domain).get(i));
							k++;
						}

						pstmt.setString(11, amt);
						pstmt.setInt(12, 0);
						pstmt.setInt(13, 0);
						pstmt.setInt(14, 0);

						pstmt.executeUpdate();
						// System.out.println("Values inserted for the first domain event under
						// combo!!");

						String sql = "select tid from RD where gid1='" + id1 + "' and gid2='" + id2 + "'and gid3='"
								+ id3 + "'and gid4='" + id4 + "'and gid5='" + id5 + "'and event1='"
								+ combo.get(domain).get(0) + "'";
						try {
							st = con.createStatement();
							rs = st.executeQuery(sql);
							while (rs.next()) {
								tid = rs.getString("tid");
								System.out.println(tid);
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						System.out.println("TID IS RETURNED WAFTER CHECKING!!");
						res.add(tid);
					}

				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Reached the end");
		return res;// finally {
//			try {
//				pstmt.close();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			try {
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}

	}

}
