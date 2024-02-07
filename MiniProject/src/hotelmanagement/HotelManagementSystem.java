package hotelmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.InputMismatchException;
//import java.sql.PreparedStatement;
import java.util.Scanner;

public class HotelManagementSystem {

	private static final String url = "jdbc:mysql://127.0.0.1:3306/mydb";
	private static final String username = "root";
	private static final String password = "root";

	public static void main(String[] args) {
		Connection conn = null;
		Statement statement = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(url, username, password);
			statement = conn.createStatement();
			Scanner sc = new Scanner(System.in);

			System.out.println("\n\t----------------- 🏨🏨🏨 HOTEL MANAGEMENT SYSTEM 🏨🏨🏨 -----------------");
			while (true) {
				System.out.println("\n\t-------------------- CHOOSE ANY OF THE BELOW CHOICE --------------------");
				System.out.println("\n\t   1] Reserve a room \t2] View Reservations \t3] Get Room Number");
				System.out.println("\n\t         4] Update Reservations \t5] Delete Reservations");
				System.out.println("\n\t---------------------------- ENTER 0 TO EXIT ---------------------------");

				System.out.print("\n➡️ Choose an option: ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					reserveRoom(conn, statement, sc);
					break;
				case 2:
					viewReservation(conn, statement, sc);
					break;
				case 3:
					getRoomnumber(conn, statement, sc);
					break;
				case 4:
					updateReservation(conn, statement, sc);
					break;
				case 5:
					deleteReservation(conn, statement, sc);
					break;
				case 0:
					exit();
					return;
				default:
					System.out.println("\nInvalid choice. Please try again.");
				}
			}
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		catch (InterruptedException e) {
			e.printStackTrace();
		}

		catch (InputMismatchException e) {
			e.printStackTrace();
			main(args);
		}

		finally {
			try {
				conn.close();
				statement.close();
			}

			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void reserveRoom(Connection conn, Statement statement, Scanner sc) {

		try {
			System.out.print("\nEnter guest name: ");
			String guestName = sc.next();
			sc.nextLine();
			System.out.print("Enter room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Enter contact number: ");
			String contactNumber = sc.next();

			String query = "INSERT INTO hotel_manage(guest_name, room_number, contact_number) VALUES ('" + guestName
					+ "','" + roomNumber + "','" + contactNumber + "')";

			int affectedRows = statement.executeUpdate(query);

			if (affectedRows > 0) {
				System.out.println("\nReservation Successful!");
			}

			else {
				System.out.println("\nReservation Failed.");
			}
		}

		catch (InputMismatchException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void viewReservation(Connection conn, Statement statement, Scanner sc) {

		try {
			String query = "SELECT * FROM hotel_manage";
			ResultSet resultSet = statement.executeQuery(query);

			System.out.println("\nCurrent Reservations:");
			System.out.println(
					"+----------------+-----------------+---------------+----------------------+-------------------------+");
			System.out.println(
					"| Reservation ID | Guest           | Room Number   | Contact Number       | Reservation Date & Time |");
			System.out.println(
					"+----------------+-----------------+---------------+----------------------+-------------------------+");

			while (resultSet.next()) {
				int reservationId = resultSet.getInt("reservation_id");
				String guestName = resultSet.getString("guest_name");
				int roomNumber = resultSet.getInt("room_number");
				String contactNumber = resultSet.getString("contact_number");
				String reservationDate = resultSet.getTimestamp("reservation_date").toString();

				System.out.printf("| %-14d | %-15s | %-13d | %-20s | %-19s   |\n", reservationId, guestName, roomNumber,
						contactNumber, reservationDate);
			}
			System.out.println(
					"+----------------+-----------------+---------------+----------------------+-------------------------+");
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void getRoomnumber(Connection conn, Statement statement, Scanner sc) {

		try {
			System.out.print("Enter reservation ID: ");
			int reservationId = sc.nextInt();
			System.out.print("Enter guest name: ");
			String guestName = sc.next();

			String query = "SELECT room_number FROM hotel_manage WHERE reservation_id = '" + reservationId
					+ "' AND guest_name = '" + guestName + "'";

			ResultSet resultSet = statement.executeQuery(query);

			if (resultSet.next()) {
				int roomNumber = resultSet.getInt("room_number");
				System.out.println("\nRoom number for Reservation ID " + reservationId + " and Guest " + guestName
						+ " is: " + roomNumber);
			}

			else {
				System.out.println("\nReservation not found for the given ID and guest name.");
			}
		}

		catch (InputMismatchException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static boolean reservationExists(Connection conn, Statement statement, int reservationId) {

		try {
			String query = "SELECT reservation_id FROM hotel_manage WHERE reservation_id = '" + reservationId + "'";

			ResultSet resultSet = statement.executeQuery(query);

			return resultSet.next();
		}

		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	private static void updateReservation(Connection conn, Statement statement, Scanner sc) {

		try {
			System.out.print("Enter reservation ID to update: ");
			int reservationId = sc.nextInt();
			sc.nextLine();

			if (!reservationExists(conn, statement, reservationId)) {
				System.out.println("\nReservation not found for the given ID.");
				return;
			}

			System.out.print("\nEnter new guest name: ");
			String newGuestName = sc.nextLine();
			System.out.print("Enter new room number: ");
			int newRoomNumber = sc.nextInt();
			System.out.print("Enter new contact number: ");
			String newContactNumber = sc.next();

			String query = "UPDATE hotel_manage SET guest_name = '" + newGuestName + "', room_number = '"
					+ newRoomNumber + "', contact_number = '" + newContactNumber
					+ "', reservation_date = CURRENT_TIMESTAMP WHERE reservation_id = '" + reservationId + "'";

			int affectedRows = statement.executeUpdate(query);

			if (affectedRows > 0) {
				System.out.println("\nReservation updated successfully!");
			}

			else {
				System.out.println("\nReservation update failed.");
			}
		}

		catch (InputMismatchException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void deleteReservation(Connection conn, Statement statement, Scanner sc) {

		try {
			System.out.print("\nEnter reservation ID to delete: ");
			int reservationId = sc.nextInt();

			if (!reservationExists(conn, statement, reservationId)) {
				System.out.println("\nReservation not found for the given ID.");
				return;
			}

			String query = "DELETE FROM hotel_manage WHERE reservation_id = '" + reservationId + "'";

			int affectedRows = statement.executeUpdate(query);

			if (affectedRows > 0) {
				System.out.println("\nReservation deleted successfully!");
			}

			else {
				System.out.println("\nReservation deletion failed.");
			}
		}

		catch (InputMismatchException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void exit() throws InterruptedException {
		System.out.print("\n\n\t\t\t\t   Exiting System");
		int i = 5;
		while (i != 0) {
			System.out.print(".");
			Thread.sleep(400);
			i--;
		}
		System.out.print("\n\n\t\t\t\tThank You For Visiting!!!");
	}

}
