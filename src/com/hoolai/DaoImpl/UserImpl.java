package com.hoolai.DaoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import JDBC.ReportingDBConn;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class UserImpl {

	int count;

	public List<Map<String, String>> selectAllUser(String sql) {
		Connection conn;
		ResultSet res = null;
		Statement st = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			ReportingDBConn dbconn = new ReportingDBConn();
			conn = dbconn.getConn();
			st = (Statement) conn.createStatement();
			res = st.executeQuery(sql);
			conn.commit();
			while (res.next()) {
				Map map = new HashMap();
				map.put("username", res.getString("username"));
				map.put("userid", res.getString("userid"));
				list.add(map);
			}

			if (st != null) {//
				st.close();
			}
			if (conn != null) {//
				conn.close();
			}
			dbconn.closeConn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Map<String, String> selectUserNameById(String sql) {
		Connection conn;
		ResultSet res = null;
		Statement st = null;
		String name = "";
		Map<String, String> map = new HashMap();
		try {
			ReportingDBConn dbconn = new ReportingDBConn();
			conn = dbconn.getConn();
			st = (Statement) conn.createStatement();
			res = st.executeQuery(sql);
			conn.commit();
			while (res.next()) {
				map.put("userid", res.getString("userid"));
				map.put("username", res.getString("username"));
				map.put("email", res.getString("email"));
				map.put("role_id", res.getString("role_id"));
				map.put("realname", res.getString("realname"));
				map.put("exclude", res.getString("exclude"));
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
			dbconn.closeConn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public int selectMaxId(String sql) {
		Connection conn;
		ResultSet res = null;
		Statement st = null;
		String str = null;
		int maxId = 0;
		try {
			ReportingDBConn dbconn = new ReportingDBConn();
			conn = dbconn.getConn();
			st = (Statement) conn.createStatement();
			res = st.executeQuery(sql);
			conn.commit();
			while (res.next()) {
				str = res.getString("userid");
			}

			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
			dbconn.closeConn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Integer.parseInt(str);
	}

	public String selectGroupSNById(String sql) {
		String str = "";
		Connection conn;
		ResultSet res = null;
		Statement st = null;
		int maxId = 0;
		try {
			ReportingDBConn dbconn = new ReportingDBConn();
			conn = dbconn.getConn();
			st = (Statement) conn.createStatement();
			res = st.executeQuery(sql);
			conn.commit();
			try {
				while (res.next()) {
					String s = res.getString("sn_id");
					str = str + s + ",";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
			dbconn.closeConn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	public String selectGroupGameById(String sql) {
		String str = "";
		Connection conn;
		ResultSet res = null;
		Statement st = null;
		int maxId = 0;
		try {
			ReportingDBConn dbconn = new ReportingDBConn();
			conn = dbconn.getConn();
			st = (Statement) conn.createStatement();
			res = st.executeQuery(sql);
			conn.commit();
			try {
				while (res.next()) {
					String s = res.getString("game_id");
					str = str + s + ",";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
			dbconn.closeConn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	public List<Map<String, String>> selectAllGroup(String sql) {
		Connection conn;
		ResultSet res = null;
		Statement st = null;
		String name = "";
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			ReportingDBConn dbconn = new ReportingDBConn();
			conn = dbconn.getConn();
			st = (Statement) conn.createStatement();
			res = st.executeQuery(sql);
			conn.commit();
			while (res.next()) {
				Map<String, String> map = new HashMap();
				map.put("group_id", res.getString("group_id"));
				map.put("group_name", res.getString("group_name"));
				list.add(map);
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
			dbconn.closeConn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String selectRole_id(String sql) {
		Connection conn;
		ResultSet res = null;
		Statement st = null;
		String str = "";
		try {
			ReportingDBConn dbconn = new ReportingDBConn();
			conn = dbconn.getConn();
			st = (Statement) conn.createStatement();
			res = st.executeQuery(sql);
			conn.commit();
			while (res.next()) {
				str = res.getString("role_id");
			}

			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
			dbconn.closeConn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	public void updateUser(String sql) {
		Connection conn;
		Boolean res = false;
		Statement st = null;
		int maxId = 0;
		try {
			ReportingDBConn dbconn = new ReportingDBConn();
			conn = dbconn.getConn();
			st = (Statement) conn.createStatement();
			st.execute(sql);
			conn.commit();
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
			dbconn.closeConn();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
