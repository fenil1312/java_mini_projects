package carShowroomManagement;

import java.util.*;

public class Showrooms implements Utility {

	String showroom_name;
	String showroom_address;
	String manager_name;
	int total_employees;
	int total_cars_in_stock = 0;

	@Override
	public void getDetails() {

		System.out.println("\n================ 🏢🏢🏢 SHOWROOM LIST 🏢🏢🏢 ================ \n");
		System.out.println("SHOWROOM NAME : " + showroom_name);
		System.out.println("SHOWROOM ADDRESS : " + showroom_address);
		System.out.println("MANAGER NAME : " + manager_name);
		System.out.println("TOTAL EMPLOYEES : " + total_employees);
		System.out.println("TOTAL CARS IN STOCK : " + total_cars_in_stock);
	}

	@Override
	public void setDetails() {

		Scanner sc = new Scanner(System.in);
		System.out.println("\n================ 🏢🏢🏢 ENTER SHOWROOM DETAILS 🏢🏢🏢 ================ \n");

		try {
			System.out.print("SHOWROOM NAME : ");
			showroom_name = sc.nextLine();
			System.out.print("SHOWROOM ADDRESS : ");
			showroom_address = sc.nextLine();
			System.out.print("MANAGER NAME : ");
			manager_name = sc.nextLine();
			System.out.print("TOTAL EMPLOYEES : ");
			total_employees = sc.nextInt();
			System.out.print("TOTAL CARS IN STOCK : ");
			total_cars_in_stock = sc.nextInt();
		}

		catch (InputMismatchException e) {
			System.err.println("\nError : Please Enter Valid Input Format...");
		}
	}

}
