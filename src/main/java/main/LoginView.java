package main;

import java.sql.SQLException;
import java.util.Scanner;
import DAO.Contacts;
import DTO.User;
public class LoginView {

	public static void view() throws SQLException {
		Scanner input = new Scanner(System.in);
		Contacts contact = new Contacts();
		User user = new User();
		System.out.println("You are logged in now!");
		System.out.println("1. Add new contact \n2. See all contacts \n3.Exit");
		int answer = input.nextInt();
		boolean checker = true;
		while (checker) {

			switch (answer) {
			case 1:
				contact.addContact(user);
				break;
			case 2:
				contact.seeAll(user);
				break;
			case 3:
				checker = false;
			}

		}
	}
}
