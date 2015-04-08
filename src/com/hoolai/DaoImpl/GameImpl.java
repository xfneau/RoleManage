package com.hoolai.DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import JDBC.ReportingDBConn;
import JDBC.WarehouseDBConn;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class GameImpl {

	/**
	 * 删除游戏
	 * @param gameid
	 */
	public void deleteGame(int gameid) {
		String sql = "delete from d_game where game_id="+gameid;
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
			 GameImpl.deleteGroupByGameId(gameid);
		 }catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除游戏byid
	 * 
	 */
	public static void deleteGameById(int id) {
		String sql = "delete from d_game where id="+id;
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

	public static void deleteGroupByGameId(int gameid){
		String sql = "delete from tbl_group_game_bind where game_id="+gameid;
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
	
	public int newGame(Map gameMap) {
		String sql = "insert into d_game (game_name,img,level,alias) values " +
					"('"+gameMap.get("gamename")+"','"+gameMap.get("gameimg")+"','"+gameMap.get("gamelevel")
						+"','"+gameMap.get("gamealias")+"')";
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
			if( !checkRepeat(gameid) ){  //检查gameid重复
				GameImpl.deleteGameById(gameid);
				return 0;
			}
			sql = "update d_game set game_id="+gameid+" where id="+gameid;
			 st.executeUpdate(sql);
			 conn.commit();  
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
		return gameid;
	}

	/**
	 * 检查gameid重复
	 * @param gameMap
	 * @return
	 */
	public boolean checkRepeat(int id){
		String sql = "select count(*) from d_game where game_id="+id;
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
	
	public int editGame(Map gameMap) {

		String sql = "update d_game set game_name='"+gameMap.get("gamename")+"',img='"+gameMap.get("gameimg")+
				"',level="+gameMap.get("gamelevel")+",alias='"+gameMap.get("gamealias")+"' where game_id="+gameMap.get("gameid");
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
	
}
