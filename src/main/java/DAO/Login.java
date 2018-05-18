package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DTO.User;
import db.ConnectionManager;

public class Login {

	private static Connection conn = ConnectionManager.getInstance().getConnection();

	public static boolean login(User user) throws Exception {
		String query = "SELECT * FROM users WHERE username = ? AND password = ?";

		try (PreparedStatement stm = conn.prepareStatement(query)) {
			stm.setString(1, user.getUsername());
			stm.setString(2, user.getPassword());

			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				if (user.getUsername().equals(rs.getString("username"))
						&& user.getPassword().equals(rs.getString("password"))) {
					rs.close();
					return true;
				}
			} else {
				System.out.println("Login failed, please try again!");
				return false;
			}
		} return true;
	}
	
}
