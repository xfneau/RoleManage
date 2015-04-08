package com.hoolai.DaoImpl;

import java.sql.ResultSet;

import JDBC.ReportingDBConn;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class LoginImpl {

	public Boolean logincheck(String sql) {
		Connection conn;
		ResultSet res=null;
		Statement st=null;
		String str = null;
		int maxId = 0;
		try{
			ReportingDBConn dbconn = new ReportingDBConn();
			conn = dbconn.getConn();
			st = (Statement)conn.createStatement();
			res = st.executeQuery(sql);
			conn.commit();  
			if( res.next() ){
				return true;
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
		return false;
		
	}
	

}
