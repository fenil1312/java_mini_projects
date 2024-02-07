package employeePayrollSystem;

import java.util.ArrayList;

abstract class Employee {

	private String name;
	private int id;

	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public Employee() {

	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	abstract public double calculateSalary();

	@Override
	public String toString() {
		return "Employee -> [ Name: " + name + ", Id: " + id + ", Salary: " + calculateSalary() + " ]";
	}
}

class FulltimeEmployee extends Employee {

	private double salary;

	public FulltimeEmployee(String name, int id, double salary) {
		super(name, id);
		this.salary = salary;
	}

	public FulltimeEmployee() {

	}

	@Override
	public double calculateSalary() {
		return salary;
	}
}

class ParttimeEmployee extends Employee {

	private double hours_worked;
	private double hourly_rate;

	public ParttimeEmployee(String name, int id, double hours_worked, double hourly_rate) {
		super(name, id);
		this.hours_worked = hours_worked;
		this.hourly_rate = hourly_rate;
	}

	@Override
	public double calculateSalary() {
		return hours_worked * hourly_rate;
	}
}

class PayrollSystem {

	private ArrayList<Employee> employeeList;

	public PayrollSystem() {
		employeeList = new ArrayList<Employee>();
	}

	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}

	public void removeEmployee(int id) {
		Employee toRemoveEmployee = null;
		for (Employee employee : employeeList) {
			if (employee.getId() == id) {
				toRemoveEmployee = employee;
				break;
			}
		}
		if (toRemoveEmployee != null) {
			employeeList.remove(toRemoveEmployee);
		}
	}

	public void displayEmployee() {
		for (Employee employee : employeeList) {
			System.out.println(employee);
		}
	}
}

public class Main {

	public static void main(String[] args) {

		PayrollSystem p = new PayrollSystem();

		FulltimeEmployee emp1 = new FulltimeEmployee("Fenil", 101, 100000);
		ParttimeEmployee emp2 = new ParttimeEmployee("Ram", 102, 40, 1000);

		p.addEmployee(emp1);
		p.addEmployee(emp2);

		System.out.println("Dislay before removal :\n");
		p.displayEmployee();

		p.removeEmployee(101);

		System.out.println("\nDislay after removal :\n");
		p.displayEmployee();
	}

}
