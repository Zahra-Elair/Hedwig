package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UserDAO {
	static public int inserer(String username,String name,String lastname,String email,String password) {
		int a=0;
		String req="insert into users values (?,?,?,?,?)";
		try {
			PreparedStatement ps=ConnextionBD.con.prepareStatement(req);
			ps.setString(1,username);
			ps.setString(2,name); 
			ps.setString(3,lastname);
			ps.setString(4, email);
			ps.setString(5,encrypt(password));
			
			a=ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return a;
	}
	 
	 public static boolean getUser(String username) {
		 String req="select username from users where username=?";
		 	PreparedStatement st;
		 //Statement st;
			ResultSet rs = null;
			try {
				st =ConnextionBD.con.prepareStatement(req);
				st.setString(1,username);
				rs=st.executeQuery();
				
				if (!rs.next()) {
					return false;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return true;
	 }
	 
	 
	 
	 public static boolean authentification(String username,String password) {
		 String req="select username from users where username=? and passwd=?";
		 	PreparedStatement st;
		 	
		 	
		 //Statement st;
			ResultSet rs = null;
			try {
				st =ConnextionBD.con.prepareStatement(req);
				st.setString(1,username);
				st.setString(2,encrypt(password));
				rs=st.executeQuery();
				
				if (!rs.next()) {
					return false;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return true;
	 }
	 
	 
	 
	 public static int modifierEtud(int ide,String nom,String pren,String fil,int niv,int group) {
		 String req="update Etudiant  set nom=?  ,prenom=? , filiere=? , niveau=? , groupe=?  where id=?";
		 	PreparedStatement st;
		 	int a=0;
			try {
				st=ConnextionBD.con.prepareStatement(req);
				st.setString(1,nom);
				st.setString(2, pren);
				st.setString(3, fil);
				st.setInt(4, niv);
				st.setInt(5, group);
				st.setInt(6, ide);
				a=st.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			return a;
	 }
	 public static int suppetd(int ide) {
		 String req="delete from Etudiant  where id=?";
		 	PreparedStatement st;
		 	int a=0;
			try {
				st=ConnextionBD.con.prepareStatement(req);
				st.setInt(1 ,ide);
				a=st.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			return a;
	 }
	 
	 public static String encrypt(String password) {
		 String temp="";
		 for (int i = 0; i < password.length(); i++) {
			temp=temp+(char)(((int)password.charAt(i))+10);
		}
		 return temp;
	 }
	 
	 /*public static String decrypt(String password) {
		 String temp="";
		 for (int i = 0; i < password.length(); i++) {
			temp=temp+(char)(((int)password.charAt(i))-10);
		}
		 System.out.println(password+"=>"+temp);
		 return temp;
	 }*/
	 
}
