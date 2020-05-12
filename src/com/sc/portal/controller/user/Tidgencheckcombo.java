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

public class Tidgencheckcombo {

	public List<String> getres(String id1, String id2, String id3, String id4, String id5, String contact,
			String domain, String event, String amt, int played) {
		
		List<String> res = new ArrayList<String>();
	
		Map<String , List<String>> combo = new HashMap<String, List<String>>();
		
		// Manual Robotics
		List<String> robotics1 = new ArrayList<String>();
		robotics1.add("Irons Heart");
		robotics1.add("Dawn of Justice");
		robotics1.add("Quatro Claw Fight");
		
		//Autonomous  Robotics
		List<String> robotics2 = new ArrayList<String>();
		robotics2.add("Robo Clash Royale(onspot)");
		robotics2.add("Coloured Stack");
		robotics2.add("Optimus Line");
		
		//Civil
		List<String> civil = new ArrayList<String>();
		civil.add("Setu Bandhan");
		civil.add("Track O Treasure");
		civil.add("NULL");
		
		//General
		List<String> general = new ArrayList<String>();
		general.add("Vagapinups");
		general.add("Videography");
		general.add("NULL");
		
		//K V for combo
		combo.put("Robotics1",robotics1);
		combo.put("Robotics2",robotics2);
		combo.put("Civil",civil);
		combo.put("General",general);
		
		if(domain.equalsIgnoreCase("Robotics"))
			domain = event.substring(0,event.indexOf(' '));
		List<String> participants = new ArrayList<String>();
		String tid = "";
		
		boolean row_present = true;
		boolean is_present1 = true;
		boolean is_present2 = true;
		boolean is_present3 = true;
		boolean is_present4 = true;
		boolean is_present5 = true;
		int combo_count = 0;
		
		if(domain.equalsIgnoreCase("Civil"))
			combo_count = civil.size();
		else
			combo_count = 3;
		System.out.println(combo_count);
		
		Connection con = null;
		try {
			con = DBConnection.getConnection();
		} catch (Exception ee) {
			System.out.println(ee);
		}

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		java.sql.Statement st = null;
		String query = "select exists(select * from RD where event1='"+combo.get(domain).get(0)+"')";
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next())
				if(rs.getString(query.substring(7)).equals("1"))
					System.out.println("Row is there");
				else
				{
					row_present = false;
					System.out.println("Row is not there");
				}
					
//				participants.add(rs.getString("gid1"));
//			System.out.println("Query  Executed!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		java.sql.Statement st2 = null;
		String last_tid = "";
		String tid_check = "select count(tid) from RD";
		boolean tid_present = true;
		try
		{
			st2 = con.createStatement();
			rs3 = st2.executeQuery(tid_check);
			while(rs3.next())
				if(rs3.getString("count(tid)").equals("0"))
				{
					tid_present = false;
				}
					
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			
			
			//when DB is full empty
			if(tid_present == false)
			{
				
				for(int i = 0; i < combo_count; i++)
				{
					System.out.println("No record present!");
					pstmt = con.prepareStatement("insert into RD(gid1,gid2,gid3,gid4,gid5,contact,domain,event,amt,played) values (?,?,?,?,?,?,?,?,?,?)");
					pstmt.setString(1, id1);
					pstmt.setString(2, id2);
					pstmt.setString(3, id3);
					pstmt.setString(4, id4);
					pstmt.setString(5, id5);
					pstmt.setString(6, contact);
					pstmt.setString(7, domain);
					pstmt.setString(8, combo.get(domain).get(i));
					pstmt.setString(9, amt);
					pstmt.setInt(10, played);
					pstmt.executeUpdate();
					
				}
				String sql = "select tid from RD where gid1='" + id1 + "' and gid2='" + id2 + "'and gid3='" + id3
						+ "'and gid4='" + id4 + "'and gid5='" + id5 + "'and event1='" + combo.get(domain).get(0) + "'";
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
			
			else
			{
//				if (row_present == false) {
//				for(int i = 0;i < combo_count; i++)
//				{
//					pstmt = con.prepareStatement("insert into RD(tid,gid1,gid2,gid3,gid4,gid5,contact,domain,event,amt,played) values (?,?,?,?,?,?,?,?,?,?,?)");
//					pstmt.setString(1, Integer.toString(Integer.parseInt(last_tid)+1));
//					pstmt.setString(2, id1);
//					pstmt.setString(3, id2);
//					pstmt.setString(4, id3);
//					pstmt.setString(5, id4);
//					pstmt.setString(6, id5);
//					pstmt.setString(7, contact);
//					pstmt.setString(8, domain);
//					pstmt.setString(9, combo.get(domain).get(i));
//					pstmt.setString(10, amt);
//					pstmt.setInt(11, played);
//					pstmt.executeUpdate();
//				}
//
//				System.out.println("Values inserted for the first domain event!!");
//
//				// String tid = getTeamID(id1, id2, id3, id4, id5, event);
//				String sql = "select tid from RD where gid1='" + id1 + "' and gid2='" + id2 + "'and gid3='" + id3
//						+ "'and gid4='" + id4 + "'and gid5='" + id5 + "'and event='" + combo.get(domain).get(combo_count-1) + "'";
//				try {
//					st = con.createStatement();
//					rs2 = st.executeQuery(sql);
//					while (rs2.next()) {
//						tid = rs2.getString("tid");
//						System.out.println(tid);
//					}
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//				System.out.println("TID IS RETURNED!!");
//				res.add(tid);
//			} else {
//				System.out.println(event);
//				String select_query = "select gid1,gid2,gid3,gid4,gid5 from RD where event='"+combo.get(domain).get(0)+"'";
//				st = con.createStatement();
//				rs2 = st.executeQuery(select_query);
////				System.out.println("query executed!");
//				while (rs2.next()) {
//					String gid1 = rs2.getString("gid1");
//					String gid2 = rs2.getString("gid2");
//					String gid3 = rs2.getString("gid3");
//					String gid4 = rs2.getString("gid4");
//					String gid5 = rs2.getString("gid5");
//
//					participants.add(gid1);
//					participants.add(gid2);
//					participants.add(gid3);
//					participants.add(gid4);
//					participants.add(gid5);
//					System.out.println("I am in Participants part");
//					System.out.println(participants);
//				}
//				if (id1 != null) {
//					boolean pr1 = participants.contains(id1);
//					System.out.println(pr1);
//					if (pr1 == true)
//					{	
//						res.add("GID 1 is present");
//						System.out.println("Added to res");
//					}
//					else
//					{
//						is_present1 = false;
//						System.out.println("false");
//					}
//				}
//				if (id2 != null) {
//					boolean pr2 = participants.contains(id2);
//					if (pr2 == true)
//						res.add("GID 2 is present");
//					else
//						is_present2 = false;
//				}
//				if (id3 != null) {
//					boolean pr3 = participants.contains(id3);
//					if (pr3 == true)
//						res.add("GID 3 is present");
//					else
//						is_present3 = false;
//				}
//				if (id4 != null) {
//					boolean pr4 = participants.contains(id4);
//					if (pr4 == true)
//						res.add("GID 4 is present");
//					else
//						is_present4 = false;
//				}
//				if (id5 != null) {
//					boolean pr5 = participants.contains(id5);
//					if (pr5 == true)
//						res.add("GID 5 is present");
//					else
//						is_present5 = false;
//				}
//				if (is_present1 == false && is_present2 == false && is_present3 == false && is_present4 == false
//						&& is_present5 == false) {
//
//					for(int i = 0;i < combo_count; i++)
//					{
//						pstmt = con.prepareStatement("insert into RD(tid,gid1,gid2,gid3,gid4,gid5,contact,domain,event,amt,played) values (?,?,?,?,?,?,?,?,?,?,?)");
//						pstmt.setString(1, Integer.toString(Integer.parseInt(last_tid)+1));
//						pstmt.setString(2, id1);
//						pstmt.setString(3, id2);
//						pstmt.setString(4, id3);
//						pstmt.setString(5, id4);
//						pstmt.setString(6, id5);
//						pstmt.setString(7, contact);
//						pstmt.setString(8, domain);
//						pstmt.setString(9, combo.get(domain).get(i));
//						pstmt.setString(10, amt);
//						pstmt.setInt(11, played);
//						pstmt.executeUpdate();
//					}
//					String sql = "select tid from RD where gid1='" + id1 + "' and gid2='" + id2 + "'and gid3='" + id3
//							+ "'and gid4='" + id4 + "'and gid5='" + id5 + "'and event='" + event + "'";
//					try {
//						st = con.createStatement();
//						rs = st.executeQuery(sql);
//						while (rs.next()) {
//							tid = rs.getString("tid");
//							System.out.println(tid);
//						}
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//					System.out.println("TID IS RETURNED WAFTER CHECKING!!");
//					res.add(tid);
//				}
//			}
			
		} 
	}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Reached the end");
		return res;
	}

}
