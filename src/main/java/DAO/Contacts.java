package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import DTO.User;
import db.ConnectionManager;

public class Contacts {

	private static Connection conn = ConnectionManager.getInstance().getConnection();

	public void addContact(User user) throws SQLException {
		Scanner input = new Scanner(System.in);

		String query = "INSERT INTO contacts(name, lastname, phonenumber, userID) VALUES(?, ?, ?, ?)";

		System.out.println("Enter contact name:	");
		String name = input.nextLine();
		System.out.println("Enter contact last name: ");
		String lastname = input.nextLine();
		System.out.println("Enter contact phonenumber: ");
		String phonenumber = input.nextLine();
		int userID = user.getUserID();
		
		
		try (PreparedStatement stm = conn.prepareStatement(query)) {
			stm.setString(1, name);
			stm.setString(2, lastname);
			stm.setString(3, phonenumber);
			stm.setInt(4, userID);

			stm.executeUpdate();

			System.out.println("Contact added!");
			
		}
		conn.close();

	}

	public void seeAll(User user) throws SQLException {

		String query = "SELECT * FROM contacts WHERE userID = ?";
		ResultSet rs = null;

		try (PreparedStatement stm = conn.prepareStatement(query)) {
			stm.setInt(1, user.getUserID());
			rs = stm.executeQuery();

			if (!rs.next()) {
				System.out.println("No contacts added.");
			} else {
				while (rs.next()) {
					System.out.println("Contact name: " + rs.getString("name") + "\n Contact last name: "
							+ rs.getString("lastname") + "\n Contact phone number: " + rs.getString("phonenumber"));
				}
			}
		}

	}
}
