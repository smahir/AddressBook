package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import db.ConnectionManager;

public class Register {

	private static Connection conn = ConnectionManager.getInstance().getConnection();
	
	public static void registerUser(String username, String password) throws SQLException {
		String query = "INSERT INTO users(username, password) VALUES(?, ?)";
		
		try(PreparedStatement stm = conn.prepareStatement(query);) {
			stm.setString(1, username);
			stm.setString(2, password);
			
			stm.executeUpdate();
			System.out.println("Registration succes!");
		}
		conn.close();
		
	}
	
}
