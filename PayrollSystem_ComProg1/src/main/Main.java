package main;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException, IOException {
		Scanner scanner = new Scanner (System.in);
		GetEmployeeDetails employeeDetails = new GetEmployeeDetails();
		CountWeeklyHours weeklyHours = new CountWeeklyHours();
		ComputeMonthlySalary computeMonthlySalary = new ComputeMonthlySalary();
		CountMonthlyHours monthlyHours = new CountMonthlyHours();
		CheckInputEmpId checkInputEmpId = new CheckInputEmpId();
//		Main main = new Main();
		
		System.out.println();
		System.out.println("||===========================================||");
		System.out.println("||    Welcome to MotorPh Employee Portal!    ||");
		System.out.println("||===========================================||");
		System.out.println();
		System.out.println("Main Menu:");
		System.out.println("1. View Basic Employee Details");
		System.out.println("2. Get Weekly Hours & Weekly Salary");
		System.out.println("3. Get Monthly Hours");
		System.out.println("4. Compute Net Monthly Salary");
		System.out.println("5. None");
		System.out.println();
		System.out.print("Please enter your choice: ");
		String userInput = scanner.nextLine();
		
		
		
		if (userInput.equals("1") == true) {
			System.out.println();
			System.out.println("------------------------------------");
			System.out.println(">>> View Basic Employee Details <<<");
			System.out.println();
			System.out.print("Enter the Employee Number: ");
			String inputEmpId = scanner.nextLine();
			String checkedInput = checkInputEmpId.checkInputEmpId(inputEmpId);
			inputEmpId = checkedInput;
			employeeDetails.getEmployeeDetails(inputEmpId);
		} else if (userInput.equals("2") == true) {
			System.out.println();
			System.out.println("------------------------------------");
			System.out.println(">>> Get Weekly Hours & Weekly Salary <<<");
			System.out.println();
			System.out.print("Enter Employee Number: ");
			String inputEmpId = scanner.nextLine();
			String checkedInput = checkInputEmpId.checkInputEmpId(inputEmpId);
			inputEmpId = checkedInput;
			weeklyHours.countWeeklyHours(inputEmpId);
		} else if (userInput.equals("3") == true) {
			System.out.println();
			System.out.println("------------------------------------");
			System.out.println(">>> Get Monthly Hours <<<");
			System.out.println();
			System.out.print("Enter Employee Number: ");
			String inputEmpId = scanner.nextLine();
			String checkedInput = checkInputEmpId.checkInputEmpId(inputEmpId);
			inputEmpId = checkedInput;
			monthlyHours.countMonthlyHours(inputEmpId);
		} else if (userInput.equals("4") == true) {
			System.out.println();
			System.out.println("------------------------------------");
			System.out.println(">>> Compute Monthly Salary <<<");
			System.out.println();
			System.out.print("Enter Employee Number: ");
			String inputEmpId = scanner.nextLine();
			String checkedInput = checkInputEmpId.checkInputEmpId(inputEmpId);
			inputEmpId = checkedInput;
			computeMonthlySalary.computeMonthlySalary(inputEmpId);
		} else if (userInput.equals("5") == true) {
			System.out.println();
			System.out.println("------------------------------------");
			System.out.println("Thank you for using MotorPh Portal!");
		}
		
		scanner.close();
	}

}
