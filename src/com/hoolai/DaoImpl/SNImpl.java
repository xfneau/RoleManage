package com.hoolai.DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import JDBC.ReportingDBConn;
import JDBC.WarehouseDBConn;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class SNImpl {


	public int updateSn(String sql) {
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
			return -1;
		}
		return 1;
	}

	public static void deleteSN(String sql,int id) {
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
			 if( id > 0 ){
				 SNImpl.deleteGroupBySnId(id);
			 }
		 }catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void deleteGroupBySnId(int id){
		String sql = "delete from tbl_group_sn_bind where sn_id="+id;
		 Connection conn;
		 ResultSet res=null;
		 Statement st = null;
		 try {
			 ReportingDBConn dbconn = new ReportingDBConn();
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

	public boolean newSn(String sql) {
		Connection conn;
		 ResultSet res=null;
//		 Statement st = null;
		 int gameid = 0;
		 try {
			 WarehouseDBConn dbconn = new WarehouseDBConn();
			 conn = dbconn.getConn();
			 PreparedStatement st = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			 st.executeUpdate();
			 conn.commit();
			 res = st.getGeneratedKeys();//insert的id
			 res.next();
			gameid = res.getInt(1);
			if( !checkRepeat(gameid) ){  //检查sn-id重复
				SNImpl.deleteSN(sql,-1);
				return false;
			}else{
				SNImpl.updateSnId(gameid);
			}
			 if( st!=null ){//
				 st.close();
			 }
			 if( conn!=null ){//�
				 conn.close();
			 }
			 if( res!=null ){//�
				 res.close();
			 }
			 dbconn.closeConn();
		 }catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	private static void updateSnId(int id) {
		Connection conn;
		 ResultSet res=null;
		 Statement st = null;
		 String sql = "update d_network set sn_id="+id +" where id="+id;
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

	public boolean checkRepeat(int id){
		String sql = "select count(*) from d_network where sn_id="+id;
		 Connection conn;
		 ResultSet res=null;
		 Statement st = null;
		 int i;
		 try {
			 WarehouseDBConn dbconn = new WarehouseDBConn();
			 conn = dbconn.getConn();
			 st = (Statement)conn.createStatement();
			 res = st.executeQuery(sql);
			 conn.commit();  
			 res.next();
			 i = res.getInt(1);
			 if( st!=null ){//
				 st.close();
			 }
			 if( conn!=null ){//�
				 conn.close();
			 }
			 dbconn.closeConn();
		 }catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		 if ( i > 0 ){
			 return false;
		 }
		return true;
	}
	

}
