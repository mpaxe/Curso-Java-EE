package mian;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/recursos_humanos","root","root");
			System.out.println("Conexión realizada");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
