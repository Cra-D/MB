package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOper {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public Connection getConn(String dbtype ,String host, String user, String pwd)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		String DRIVER =null;
		String JDBC = null;
		if(dbtype.equals("MySQL")){
		 DRIVER = "com.mysql.jdbc.Driver";
		JDBC="jdbc:mysql://";
		}
		else if(dbtype.equals("AS400/DB2")){
			 DRIVER = "com.mysql.jdbc.Driver";
			JDBC="jdbc:mysql://";
			}
		String URL = JDBC + host + "?user=" + user + "&password=" + pwd
				+ "&useUnicode=true&characterEncoding=utf8";
		
		System.out.println("URL="+URL);
		Class.forName(DRIVER).newInstance();
		conn = DriverManager.getConnection(URL);
		return conn;
	}
	public Connection getConn(Connection db)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
         this.conn = db;
		return this.conn;
	}
	public void closeAll() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ResultSet executeQuery(String preparedSql, String[] param) {
		try {
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setString(i + 1, param[i]);
				}
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public int executeUpdate(String preparedSql, String[] param) {
		int num = 0;
		try {
			pstmt = conn.prepareStatement(preparedSql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setString(i + 1, param[i]);
				}
			}
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

}
