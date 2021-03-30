package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/crud?useSSL=false";
	private String user = "root";
	private String password = "";
	
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(this.url, this.user, this.password);
		return conn;
	}

}
