package carShowroomManagement;

import java.util.*;

interface Utility {
	public void getDetails();

	public void setDetails();
}

public class Main {

	static void main_menu() {

		System.out.println(
				"\n\t================ 🚗🚗🚗 WELCOME TO CAR SHOWROOM MANAGEMENT SYSTEM 🚗🚗🚗 ================\n");
		System.out
				.println("\t=========================== CHOOSE ANY OF THE BELOW CHOICE ============================\n");
		System.out.println("\t      1] ADD SHOWROOM 🏢\t\t2] ADD EMPLOYEE 👨‍🏭\t\t3] ADD CAR 🚘\n");
		System.out.println("\t      4] GET SHOWROOM 🏢\t\t5] GET EMPLOYEE 👨‍🏭\t\t6] GET CAR 🚘\n");
		System.out.println("\t=================================== ENTER 0 TO EXIT ===================================");

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Showrooms[] showroom = new Showrooms[5];
		Employees[] employee = new Employees[5];
		Cars[] car = new Cars[5];
		int showroom_counter = 0;
		int employee_counter = 0;
		int car_counter = 0;

		int choice = 100;

		try {
			while (choice != 0) {
				main_menu();

				System.out.print("\n➡️ ENTER YOUR CHOICE : ");
				choice = sc.nextInt();

				while (choice != 9 && choice != 0) {
					switch (choice) {

					case 1:
						showroom[showroom_counter] = new Showrooms();
						showroom[showroom_counter].setDetails();
						showroom_counter++;
						do {
							System.out.println("\n1] ADD NEW SHOWROOM 🏢");
							System.out.println("9] GO BACK TO MAIN MENU");
							System.out.print("\n➡️ ENTER YOUR CHOICE : ");
							choice = sc.nextInt();
						} while (choice != 1 && choice != 9);
						break;

					case 2:
						employee[employee_counter] = new Employees();
						employee[employee_counter].setDetails();
						employee_counter++;
						do {
							System.out.println("\n2] ADD NEW EMPLOYEE 👨‍🏭");
							System.out.println("9] GO BACK TO MAIN MENU");
							System.out.print("\n➡️ ENTER YOUR CHOICE : ");
							choice = sc.nextInt();
						} while (choice != 1 && choice != 9);
						break;

					case 3:
						car[car_counter] = new Cars();
						car[car_counter].setDetails();
						car_counter++;
						do {
							System.out.println("\n3] ADD NEW CAR 🚘");
							System.out.println("9] GO BACK TO MAIN MENU");
							System.out.print("\n➡️ ENTER YOUR CHOICE : ");
							choice = sc.nextInt();
						} while (choice != 1 && choice != 9);
						break;

					case 4:
						if (showroom_counter == 0) {
							System.err.println("  🚫 SHOWROOM LIST IS EMPTY, PLEASE ADD SHOWROOM FIRST...");
							showroom_counter++;
						} else {
							for (int i = 0; i < showroom_counter; i++) {
								showroom[i].getDetails();
								System.out.println("\n");
							}
						}
						showroom_counter--;
						do {
							System.out.println("\n1] ADD NEW SHOWROOM 🏢");
							System.out.println("9] GO BACK TO MAIN MENU");
							System.out.println("0] EXIT");
							System.out.print("\n➡️ ENTER YOUR CHOICE : ");
							choice = sc.nextInt();
						} while (choice != 9 && choice != 0 && choice != 1);
						break;

					case 5:
						if (employee_counter == 0) {
							System.err.println("  🚫 EMPLOYEE LIST IS EMPTY, PLEASE ADD EMPLOYEE FIRST...");
							employee_counter++;
						} else {
							for (int i = 0; i < employee_counter; i++) {
								employee[i].getDetails();
								System.out.println("\n");
							}
						}
						employee_counter--;
						do {
							System.out.println("\n2] ADD NEW EMPLOYEE 👨‍🏭");
							System.out.println("9] GO BACK TO MAIN MENU");
							System.out.println("0] EXIT");
							System.out.print("\n➡️ ENTER YOUR CHOICE : ");
							choice = sc.nextInt();
						} while (choice != 9 && choice != 0 && choice != 2);
						break;

					case 6:
						if (car_counter == 0) {
							System.err.println("  🚫 CAR LIST IS EMPTY, PLEASE ADD CAR FIRST...");
							car_counter++;
						} else {
							for (int i = 0; i < car_counter; i++) {
								car[i].getDetails();
								System.out.println("\n");
							}
						}
						car_counter--;
						do {
							System.out.println("\n3] ADD NEW CAR 🚘");
							System.out.println("9] GO BACK TO MAIN MENU");
							System.out.println("0] EXIT");
							System.out.print("\n➡️ ENTER YOUR CHOICE : ");
							choice = sc.nextInt();
						} while (choice != 9 && choice != 0 && choice != 3);
						break;

					default:
						System.err.println("\n❌ ENTER VALID CHOICE...");
						System.out.print("\n➡️ ENTER YOUR CHOICE : ");
						choice = sc.nextInt();
						break;
					}
				}
			}
			System.out.println("\n\n\n\n\t\t\t\t\tTHANK YOU FOR VISITING... 🎉🤗🎉");
			System.out.println();
			
			// Heart Pattern ♥︎
			for (int i = 0; i < 6; i++) {
				System.out.print("\t\t\t\t\t\t");
				for (int j = 0; j <= 6; j++) {
					if ((i == 0 && j % 3 != 0) || (i == 1 && j % 3 == 0) || (i - j == 2) || (i + j == 8)) {
						System.out.print("♥︎ ");
					} else {
						System.out.print("  ");
					}
				}
				System.out.println();
			}
		}

		catch (InputMismatchException e) {
			System.err.println("\nError : Please Enter Valid Input Format...");
			main(args);
		}
	}

}
