package ConnectDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectPostgres {
	
	private final String url = "jdbc:postgresql://localhost:5432/Jogo";
	private final String user = "vinicius";
	private final String password = "binivini12";
	private Connection conn;
	
	public Connection getConnection() throws SQLException {
		
		this.conn = DriverManager.getConnection(url, user,password);
		
		return conn;
	}
	
}
