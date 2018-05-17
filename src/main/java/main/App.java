package main;

import java.util.Scanner;
import java.sql.SQLException;
import DTO.User;
import DAO.Register;

public class App {

	public static void main(String[] args) {
		// Exit boolean for console
		boolean checker = true;

		while (checker) {
			try {
				Scanner input = new Scanner(System.in);

				System.out.println("Welcome! \n1. Login \n2. Register");
				int answer = input.nextInt();

				input.nextLine();
	
				switch (answer) {
				case 1:

					User user = new User();
					System.out.println("Enter username: ");
					user.setUsername(input.nextLine());
					System.out.println("Enter password: ");
					user.setPassword(input.nextLine());

					break;
				case 2:
					Register.registerUser();
					break;
				default:
					System.out.println("Error");
				}

			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

}
