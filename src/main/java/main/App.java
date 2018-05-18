package main;

import java.util.Scanner;
import DTO.User;
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
						LoginView.view();
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
