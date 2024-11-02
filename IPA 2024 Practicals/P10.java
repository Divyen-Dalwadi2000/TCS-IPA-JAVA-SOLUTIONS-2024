//
//IPA 10 
//Create a class called Employee with the below attributes:
//
//employeeld - int
//name - String
//branch - String
//rating - double
//company Transport - boolean
//The above attributes should be private. write getters, setters and parameterized constructor as required.
//
//Create class MyClass with main method.
//Implement two static methods findCountOfEmployeesUsingCompTransport and findEmployeeWithSecondHighestRating
//in MyClass class.
//
//findCountOfEmployeesUsingCompTransport method: 
//----------------------------------------------
//This method will take an array of Employee object and a String parameter as input parameters. 
//This method will calculate and return the count of Employees who are all using company transport 
//in the given branch (String parameter passed).
//If no Employee in the given branch using company transport in the array of Employee objects, then 
//the method should return 0.
//
//findEmployeeWithSecondHighestRating method: 
//--------------------------------------------
//This method will take an array of Employee objects as an input parameter. This method will return 
//the object of the second highest rating employee from the array of Employee objects who are not using 
//company transport.
//If all Employees using company transport in the array of Employee objects, then the method should return null.
//
//Note: All the searches should be case sensitive, companyTransport and rating combination of each Employee 
//is unique.
//For findCountOfEmployeesUsingCompTransport method, The main method should print the returned count as it 
//is if the returned value is greater than 0, else it should print "No such Employees".
//Ex: 2 , where 2 is the count
//For findEmployeeWithSecondHighestRating method: The main method should print the employeeld and name from 
//the returned object if the returned value is not null. If the returned value is null, then it should 
//print "All Employees using company transport".
//Ex: 1003
//    Uma
//where 1003 is the employeeld and Uma is the name.
//Before calling these static methods in main, use Scanner object to read the values of four Employee 
//objects referring attributes in the above mentioned attributes sequence. Next, read the value of String
//parameter for capturing branch.
//
//Input : 
//
//1001
//Ashwa
//IT
//5
//true
//1002
//Preeti
//IT
//4
//true
//1003
//Uma
//Admin
//3
//false
//1004
//Akash
//Hardware
//4.5
//false
//IT
//
//
//
//Output : 
//
//2
//1003
//Uma

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class P10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Employee> employees = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			int eId = sc.nextInt();
			sc.nextLine();
			String name = sc.nextLine();
			String branch = sc.nextLine();
			double rating = sc.nextDouble();
			sc.nextLine();
			boolean compTrans = sc.nextBoolean();
			sc.nextLine();

			employees.add(new Employee(eId, name, branch, rating, compTrans));
		}

		String branch = sc.nextLine();

		int count = findCountOfEmployeesUsingCompTransport(employees, branch);
		if (count == 0) {
			System.out.println("No Such employees");
		} else {
			System.out.println(count);
		}

		Employee obj = findEmployeeWithSecondHighestRating(employees);
		if (obj == null) {
			System.out.println("All Employees Using Company Transport");
		} else {
			System.out.println(obj.getEmployeeId());
			System.out.println(obj.getName());
		}

	}

	public static Employee findEmployeeWithSecondHighestRating(List<Employee> employees) {
		List<Employee> list = new ArrayList<>();
		for (Employee e : employees) {
			if (e.getComoTrans() == false) {
				list.add(e);
			}
		}

		if (list.size() < 2) {
			return null;
		}
		Collections.sort(list, Comparator.comparingInt(Employee::getEmployeeId).reversed());
		return list.isEmpty() ? null : list.get(1);

	}

	public static int findCountOfEmployeesUsingCompTransport(List<Employee> employees, String branch) {
		int count = 0;

		for (Employee e : employees) {
			if (e.getBranch().equalsIgnoreCase(branch) && e.getComoTrans() == true) {
				count++;
			}
		}
		return count;
	}
}

class Employee {
	private int employeeId;
	private String name;
	private String branch;
	private double rating;
	private boolean compTrans;

	public Employee(int employeeId, String name, String branch, double rating, boolean compTrans) {
		this.employeeId = employeeId;
		this.name = name;
		this.branch = branch;
		this.rating = rating;
		this.compTrans = compTrans;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getName() {
		return name;
	}

	public String getBranch() {
		return branch;
	}

	public double getRating() {
		return rating;
	}

	public boolean getComoTrans() {
		return compTrans;
	}
}
