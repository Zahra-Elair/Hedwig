package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnextionBD {
	static public Connection con=null;
	
	public ConnextionBD() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("erreur chargement driver");
		}
		//connexion a la base
		String url = "jdbc:mysql://localhost:3306/Hedwig";
		String user = "root" ;
		String mp = "0000"; 
		
		try {
			con=DriverManager.getConnection(url, user, mp);
			System.out.println("connected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("erreur de connexion");
		}
	}
	
	public static void main(String[] args) {
		new ConnextionBD();
	
	}
}
