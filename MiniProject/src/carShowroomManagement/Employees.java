package carShowroomManagement;

import java.util.*;

public class Employees extends Showrooms implements Utility {

	int emp_id = (int) (Math.random() * 1000000);
	String emp_name;
	int emp_age;
	String emp_department;

	@Override
	public void getDetails() {

		System.out.println("\n================ 👨‍🏭👨‍🏭👨‍🏭 EMPLOYEE LIST 👨‍🏭👨‍🏭👨‍🏭 ================ \n");
		System.out.println("EMPLOYEE ID : " + emp_id);
		System.out.println("EMPLOYEE NAME : " + emp_name);
		System.out.println("EMPLOYEE AGE : " + emp_age);
		System.out.println("EMPLOYEE DEPARTMENT : " + emp_department);
		System.out.println("SHOWROOM NAME : " + showroom_name);

	}

	@Override
	public void setDetails() {

		Scanner sc = new Scanner(System.in);

		System.out.println(
				"\n================= 👨‍🏭👨‍🏭👨‍🏭 ENTER EMPLOYEE DETAILS 👨‍🏭👨‍🏭👨‍🏭 ================ \n");

		try {
			System.out.print("EMPLOYEE NAME : ");
			emp_name = sc.nextLine();
			System.out.print("EMPLOYEE AGE : ");
			emp_age = sc.nextInt();
			sc.nextLine();
			System.out.print("EMPLOYEE DEPARTMENT : ");
			emp_department = sc.nextLine();
			System.out.print("SHOWROOM NAME : ");
			showroom_name = sc.nextLine();
		} 
		
		catch (InputMismatchException e) {
			System.err.println("\nError : Please Enter Valid Input Format...");
		}
	}
}
