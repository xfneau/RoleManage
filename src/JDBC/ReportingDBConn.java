package JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;

public class ReportingDBConn {
	
	Connection conn = null;
	public Connection getConn(){	 
		try{
			try {
				ResourceBundle b = ResourceBundle.getBundle("db_reporting");
				Class.forName(b.getString("driver"));
				conn = (Connection) DriverManager.getConnection(b.getString("url"),b.getString("username"),b.getString("password"));
				conn.setAutoCommit(false);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(!conn.isClosed()){
				//System.out.println("reporting连接成功");
			}
			if( conn == null ){
				System.out.println("连接失败");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeConn(){
		
		if( conn!=null ){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
