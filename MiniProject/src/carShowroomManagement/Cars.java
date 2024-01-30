package carShowroomManagement;

import java.util.*;

public class Cars extends Showrooms implements Utility {

	String car_name;
	String car_color;
	String car_fuel_type;
	int car_price;
	String car_type;
	String car_transmission;

	@Override
	public void getDetails() {

		System.out.println("\n================ 🚘🚘🚘 CAR LIST 🚘🚘🚘 ================ \n");
		System.out.println("CAR NAME : " + car_name);
		System.out.println("CAR COLOR : " + car_color);
		System.out.println("CAR FUEL TYPE : " + car_fuel_type);
		System.out.println("CAR PRICE : " + car_price);
		System.out.println("CAR TYPE : " + car_type);
		System.out.println("CAR TRANSMISSION : " + car_transmission);

	}

	@Override
	public void setDetails() {

		Scanner sc = new Scanner(System.in);

		System.out.println("\n================ 🚘🚘🚘 ENTER CAR DETAILS 🚘🚘🚘 ================ \n");

		try {
			System.out.print("CAR NAME : ");
			car_name = sc.nextLine();
			System.out.print("CAR COLOR : ");
			car_color = sc.nextLine();
			System.out.print("CAR FUEL TYPE : ");
			car_fuel_type = sc.nextLine();
			System.out.print("CAR PRICE : ");
			car_price = sc.nextInt();
			sc.nextLine();
			System.out.print("CAR TYPE : ");
			car_type = sc.nextLine();
			System.out.print("CAR TRANSMISSION : ");
			car_transmission = sc.nextLine();

			total_cars_in_stock++;
		} 
		
		catch (InputMismatchException e) {
			System.err.println("\nError : Please Enter Valid Input Format...");
		}
	}

}
