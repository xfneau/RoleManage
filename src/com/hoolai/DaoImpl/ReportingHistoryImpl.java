package com.hoolai.DaoImpl;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import JDBC.Cy_gameDBConn;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ReportingHistoryImpl {

	public List<Map<String, String>> getListHistory(String reportName) {
		
		List<Map<String, String>> listHistory = new ArrayList<Map<String, String>>();
		SimpleDateFormat forma = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis()-30*60*1000);//前半小时
		String sql = "select * from reporting_history where report_name='"+reportName+"'"
				+ " and report_status='Pending' and report_date<='"+forma.format(date)+"'  and delete_tag is NULL";
		System.out.println(sql);
		Connection conn = null;
		Statement sts = null;
		ResultSet result = null;
		try{
			Cy_gameDBConn dbconn = new Cy_gameDBConn();
			conn = dbconn.getConn();
			sts = (Statement) conn.createStatement();
			result = sts.executeQuery(sql);
			conn.commit();
			while( result.next() ){
				Map map = new HashMap();
				map.put("report_name", result.getString("report_name"));
				map.put("report_status", result.getString("report_status"));
				map.put("report_user", result.getString("report_user"));
				map.put("report_date", result.getString("report_date"));
				map.put("delete_tag", result.getString("delete_tag"));
				listHistory.add(map);
			}
			if( sts != null ){
				sts.close();
			}
			if( conn != null ){
				conn.close();
			}
			dbconn.closeConn();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return listHistory;
	}

	public void deleteReportHistory(String reportName) {
		Connection conn = null;
		Statement sts = null;
		ResultSet result = null;
		SimpleDateFormat forma = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis()-30*60*1000);//前半小时
		String sqlUpdate = "update reporting_history set delete_tag='admin' where report_name='"+reportName+"'";
		String sqlDlete = "delete from reporting_history where report_name='"+reportName+"'"
				+ " and report_status='Pending' and report_date<='"+forma.format(date)+"'";
		try{
			long t = System.currentTimeMillis();
			Cy_gameDBConn dbconn = new Cy_gameDBConn();
			conn = dbconn.getConn();
			sts = (Statement) conn.createStatement();
			sts.executeUpdate(sqlUpdate);
			conn.commit();
			System.out.println((System.currentTimeMillis()-t)/1000);
			if( sts != null ){
				sts.close();
			}
			if( conn != null ){
				conn.close();
			}
			dbconn.closeConn();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
