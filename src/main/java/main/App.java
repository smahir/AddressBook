package main;

import java.util.Scanner;
import DTO.User;
import DAO.Contacts;
import DAO.Login;
import DAO.Register;

public class App {

	public static void main(String[] args) {
		// Exit boolean for console
		boolean checker = true;

		while (checker) {
			try {
				Scanner input = new Scanner(System.in);

				System.out.println("Welcome! \n1. Login \n2. Register \n3. Exit");
				int answer = input.nextInt();

				input.nextLine();
				
				switch (answer) {
				case 1:
					User user = new User();
					System.out.println("Enter username: ");
					user.setUsername(input.nextLine());
					System.out.println("Enter password: ");
					user.setPassword(input.nextLine());
					
					boolean logged = Login.login(user);
					
					
					if (logged) {
						Contacts contact = new Contacts();
						System.out.println("You are logged in now!");
						System.out.println("1. Add new contact \n2. See all contacts \n3.Exit");
						int answer2 = input.nextInt();
						boolean checker2 = true;
						while (checker2) {

							switch (answer2) {
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
					
					break;
				case 2:
					System.out.println("Enter new username: ");
					String username = input.nextLine();
					System.out.println("Enter new passwrod: ");
					String password = input.nextLine();
					Register.registerUser(username, password);
					
					break;
				case 3:
					checker = false;
				default:
					System.out.println("Error");
				}

			} catch (Exception e) {
				System.out.println(e);
			}
		} 
	}

}
