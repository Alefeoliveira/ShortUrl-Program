package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/url?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "";
	
	Connection con = null;
	
	// M�todo de conex�o
	private Connection connection() {
		try {
			// driver utilizado para conectar com o banco
			Class.forName(driver);
			// DriverManager gerencia a conex�o com o banco de dados;
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Connection getConnection() {
		try {
			con = connection();
			System.out.println(con);
			return con;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	public void closeConnection(){
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
