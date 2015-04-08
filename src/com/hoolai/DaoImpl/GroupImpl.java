package com.hoolai.DaoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import JDBC.ReportingDBConn;
import JDBC.WarehouseDBConn;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class GroupImpl {
	
	int count;
	
	/**
	 * 
	 * @param sql
	 */
	public void updateRecord(String sql){
		 Connection conn;
		 ResultSet res=null;
		 Statement st = null;
		 try {
			 WarehouseDBConn dbconn = new WarehouseDBConn();
			 conn = dbconn.getConn();
			 st = (Statement)conn.createStatement();
			 st.executeUpdate(sql);
			 conn.commit();  
			
			 if( st!=null ){//
				 st.close();
			 }
			 if( conn!=null ){//�
				 conn.close();
			 }
			 dbconn.closeConn();
		 }catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 */
	public List<Map<String,String>> selectAllGame(String sql){
		 Connection conn;
		 ResultSet res=null;
		 Statement st = null;
		 List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		 try {
			 WarehouseDBConn dbconn = new WarehouseDBConn();
			 conn = dbconn.getConn();
			 st = (Statement)conn.createStatement();
			 res =  st.executeQuery(sql);
			 conn.commit();  
			 while( res.next() ){
					Map map = new HashMap();
					map.put("game_alias", res.getString("alias"));
					map.put("game_level", res.getString("level"));
					map.put("game_img", res.getString("img"));
					map.put("game_name", res.getString("game_name"));
					map.put("game_id",res.getString("game_id"));
					list.add(map);
				}
			 
			 if( st!=null ){//
				 st.close();
			 }
			 if( conn!=null ){//
				 conn.close();
			 }
			 dbconn.closeConn();
		 }catch (Exception e) {
			e.printStackTrace();
		}
		 return list;
	}
	

	/**
	 * 
	 */
	public List<Map<String,String>> selectAllSN(String sql){
		 Connection conn;
		 ResultSet res=null;
		 Statement st = null;
		 List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		 try {
			 WarehouseDBConn dbconn = new WarehouseDBConn();
			 conn = dbconn.getConn();
			 st = (Statement)conn.createStatement();
			 res =  st.executeQuery(sql);
			 conn.commit();  
			 while( res.next() ){
					Map map = new HashMap();
					map.put("sn_level", res.getInt("level"));
					map.put("sn_img", res.getString("img"));
					map.put("sn_name", res.getString("sn_name"));
					map.put("sn_id",res.getString("sn_id"));
					list.add(map);
				}
			 
			 if( st!=null ){
				 st.close();
			 }
			 if( conn!=null ){//
				 conn.close();
			 }
			 dbconn.closeConn();
		 }catch (Exception e) {
			e.printStackTrace();
		}
		 return list;
	}
	/**
	 * 
	 */
	public List<Map<String,String>> selectAllGroup(String sql){
		 Connection conn;
		 ResultSet res=null;
		 Statement st = null;
		 List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		 try {
			 ReportingDBConn dbconn = new ReportingDBConn();
			 conn = dbconn.getConn();
			 st = (Statement)conn.createStatement();
			 res =  st.executeQuery(sql);
			 conn.commit();  
			 while( res.next() ){
					Map map = new HashMap();
					map.put("group_name", res.getString("group_name"));
					map.put("group_id",res.getString("group_id"));
					list.add(map);
				}
			 
			 if( st!=null ){
				 st.close();
			 }
			 if( conn!=null ){
				 conn.close();
			 }
			 dbconn.closeConn();
		 }catch (Exception e) {
			e.printStackTrace();
		}
		 return list;
	}
	/**
	 * 
	 */
	public List<Map<String,String>> selectAllUser(String sql){
		 Connection conn;
		 ResultSet res=null;
		 Statement st = null;
		 List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		 try {
			 ReportingDBConn dbconn = new ReportingDBConn();
			 conn = dbconn.getConn();
			 st = (Statement)conn.createStatement();
			 res =  st.executeQuery(sql);
			 conn.commit();  
			 while( res.next() ){
					Map map = new HashMap();
					map.put("game_name", res.getString("game_name"));
					map.put("game_id",res.getString("game_id"));
					list.add(map);
				}
			 
			 if( st!=null ){//
				 st.close();
			 }
			 if( conn!=null ){//
				 conn.close();
			 }
			 dbconn.closeConn();
		 }catch (Exception e) {
			e.printStackTrace();
		}
		 return list;
	}

	public String selectGroupNameById(String sql) {
		Connection conn;
		ResultSet res=null;
		Statement st=null;
		String name="";
		try{
			ReportingDBConn dbconn = new ReportingDBConn();
			conn = dbconn.getConn();
			st = (Statement)conn.createStatement();
			res = st.executeQuery(sql);
			conn.commit();  
			while( res.next() ){
				name = res.getString("group_name");
			}
			if( st!=null ){
				st.close();
			}
			if( conn!=null ){
				conn.close();
			}
			dbconn.closeConn();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}

	
	public int selectMaxId(String sql) {
		Connection conn;
		ResultSet res=null;
		Statement st=null;
		int maxId = 0;
		try{
			ReportingDBConn dbconn = new ReportingDBConn();
			conn = dbconn.getConn();
			st = (Statement)conn.createStatement();
			res = st.executeQuery(sql);
			conn.commit();  
			while( res.next() ){
				maxId = res.getInt("group_id");
			}
				
			if( st!=null ){
				st.close();
			}
			if( conn!=null ){
				conn.close();
			}
			dbconn.closeConn();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return maxId;
	}

	public Boolean insertGroup(String sql) {
		Connection conn;
		Boolean res=false;
		Statement st=null;
		int maxId = 0;
		try{
			ReportingDBConn dbconn = new ReportingDBConn();
			conn = dbconn.getConn();
			st = (Statement)conn.createStatement();
			 st.executeUpdate(sql);
			 conn.commit();  
			if( st!=null ){
				st.close();
			}
			if( conn!=null ){
				conn.close();
			}
			dbconn.closeConn();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public String selectGroupSNById(String sql) {
		String str = "";
		Connection conn;
		ResultSet res = null;
		Statement st=null;
		int maxId = 0;
		try{
			ReportingDBConn dbconn = new ReportingDBConn();
			conn = dbconn.getConn();
			st = (Statement)conn.createStatement();
			res = st.executeQuery(sql);
			conn.commit();  
			try{
				while(res.next()){
					String s = res.getString("sn_id");
					str = str+s+",";
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			if( st!=null ){
				st.close();
			}
			if( conn!=null ){
				conn.close();
			}
			dbconn.closeConn();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	public String selectGroupGameById(String sql) {
		String str = "";
		Connection conn;
		ResultSet res = null;
		Statement st=null;
		int maxId = 0;
		try{
			ReportingDBConn dbconn = new ReportingDBConn();
			conn = dbconn.getConn();
			st = (Statement)conn.createStatement();
			res = st.executeQuery(sql);		
			conn.commit();  
			try{
				while(res.next()){
					String s = res.getString("game_id");
					str = str+s+",";
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			if( st!=null ){
				st.close();
			}
			if( conn!=null ){
				conn.close();
			}
			dbconn.closeConn();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	/**
	 * 批量插入
	 * @param maxId
	 * @param group_SN
	 */
	public void insertGroupSN(int maxId, String[] group_SN) {
		Connection conn;
		Boolean res=false;
		Statement st=null;
		try{
			ReportingDBConn dbconn = new ReportingDBConn();
			conn = dbconn.getConn();
			st = (Statement)conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);  
			 for(int x = 0; x < group_SN.length; x++){  
				   st.addBatch("insert into tbl_group_sn_bind(group_id,sn_id) values ("+maxId+","+Integer.parseInt(group_SN[x])+")");  
				 }  
			st.executeBatch();  
			conn.commit();  
			if( st!=null ){
				st.close();
			}
			if( conn!=null ){
				conn.close();
			}
			dbconn.closeConn();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param maxId
	 * @param group_Game
	 */
	public void insertGroupGame(int maxId, String[] group_Game) {
		Connection conn;
		Statement st=null;
		try{
			ReportingDBConn dbconn = new ReportingDBConn();
			conn = dbconn.getConn();
			st = (Statement)conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);  
			 for(int x = 0; x < group_Game.length; x++){  
				   st.addBatch("insert into tbl_group_game_bind(group_id,game_id) values ("+maxId+","+Integer.parseInt(group_Game[x])+")");  
				 }  
			st.executeBatch();  
			conn.commit();  
			if( st!=null ){
				st.close();
			}
			if( conn!=null ){
				conn.close();
			}
			dbconn.closeConn();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
