package JDBC;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;

public class Cy_gameDBConn {

	Connection conn = null;

	public Connection getConn() {
		try {
			ResourceBundle res = ResourceBundle.getBundle("cy_game");
			Class.forName(res.getString("driver"));
			conn = (Connection) DriverManager.getConnection(
					res.getString("url"), res.getString("username"),
					res.getString("password"));
			conn.setAutoCommit(false);
			if (conn == null) {
				System.out.println("连接失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void closeConn() {

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
