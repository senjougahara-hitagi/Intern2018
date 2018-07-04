package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;


public class MySQLUtils {

	private static String classForName;
	private static String url;
	private static String username;
	private static String userpass;
	private static Stack<Connection> connPools;
	
	static {
		connPools = new Stack<Connection>();
		classForName = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost/intern";
		username = "root";
		userpass = "";
		
		try {
			Class.forName(classForName).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection connect() throws SQLException {
		Connection conn = null;
		
		if(connPools.empty()) {
			conn = DriverManager.getConnection(url, username, userpass);
		} else {
			conn = connPools.pop();
		}
		return conn;
	}

	public static void disconnect(Connection conn) {
		if(conn != null) {
			connPools.push(conn);
		}
	}
}
