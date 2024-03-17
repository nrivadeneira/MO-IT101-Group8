package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class GetEmployeeDetails {
	
	public String [] empDetailsArray;
	
	public void employeeDetails(String inputEmpId) throws IOException {
		FileReader fr = new FileReader ("./data/EmployeeDetailsv3.csv");
		BufferedReader br = new BufferedReader (fr);
		String line;
		
		// if line is not null, split each row element by comma
		while (((line = br.readLine()) != null) && (empDetailsArray == null)){  
			//&& statement was added so the while loop will stop when it reaches the empId
			String[] cols = line.split(",");
			
			if (inputEmpId.equals(cols[0])){
				empDetailsArray = cols;
			} else continue;
		}
		br.close();
	}
	
	public void getEmployeeDetails(String inputEmpId) throws IOException, ParseException {
		employeeDetails(inputEmpId);

		CountWeeklyHours weeklyHours = new CountWeeklyHours();
		ComputeMonthlySalary monthlySalary = new ComputeMonthlySalary();
		CountMonthlyHours monthlyHours = new CountMonthlyHours();
		
		String [] empDetails = empDetailsArray;
	
		System.out.println();
		System.out.println("------------------------------------------------------");
		System.out.println();
		System.out.println("Employee Details:");
		System.out.println("Employee Number: " + empDetails[0]);
		System.out.println("Employee Name: " + empDetails[1] + ", "+ empDetails[2]);
		System.out.println("Birthday: " + empDetails[3]);
		System.out.println("Address: " + empDetails[4]);
		System.out.println("Phone#: " + empDetails[5]);
		System.out.println("SSS: " + empDetails[6]);
		System.out.println("PhilHealth: " + empDetails[7]);
		System.out.println("PagIbig: " + empDetails[9]);
		System.out.println("TIN: " + empDetails[8]);
		System.out.println("Status: " + empDetails[10]);
		System.out.println("Position: " + empDetails[11]);
		System.out.println("Immediate Supervisor: " + empDetails[12]);
		System.out.println("Basic Salary: " + empDetails[13]);
		System.out.println("Rice Subsidy: " + empDetails[14]);
		System.out.println("Phone Allowance: " + empDetails[15]);
		System.out.println("Clothing Allowance: " + empDetails[16]);
		System.out.println("Gross Semi-Monthly Rate: " + empDetails[17]);
		System.out.println("Hourly Rate: " + empDetails[18]);
		System.out.println();
		System.out.println("------------------------------------------------------");
		System.out.println();
		System.out.println(". . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .");
		System.out.println(".                                                                 .");
		System.out.println(".  Sub-Menu:                                                      .");
		System.out.println(".  1. Compute for this employee's Weekly Hours & Weekly Salary    .");
		System.out.println(".  2. Compute for this employee's Monthly Hours                   .");
		System.out.println(".  3. Compute Net Monthly Salary                                  .");
		System.out.println(".  4. Go back to Main menu to check for other employees           .");
		System.out.println(".  5. Exit                                                        .");
		System.out.println(".                                                                 .");
		System.out.println(". . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .");
		System.out.println();
		System.out.print("Please enter your choice: ");
		Scanner scanner = new Scanner (System.in);
		String userInputSubOption = scanner.nextLine();
		if (userInputSubOption.equals("1") == true) {
			weeklyHours.countWeeklyHours(inputEmpId);
		}else if (userInputSubOption.equals("2") == true) {
			monthlyHours.countMonthlyHours(inputEmpId);
		}else if (userInputSubOption.equals("3") == true) {
			monthlySalary.computeMonthlySalary(inputEmpId);
		} else if (userInputSubOption.equals("4") == true) {
			Main.main(null);
		}else  if (userInputSubOption.equals("5") == true) {
			System.out.println();
			System.out.println("------------------------------------");
			System.out.println("Thank you for using MotorPh Portal!");
		}
		
		scanner.close();
		
	}
	
	public double getHourlyRate(String inputEmpId) throws IOException {
		employeeDetails(inputEmpId);
		String [] empDetails = empDetailsArray;
		double hourlyRate = Double.parseDouble(empDetails[18]);
		return hourlyRate;
	}
	
	public double getRiceSubsidy(String inputEmpId) throws IOException {
		employeeDetails(inputEmpId);
		String [] empDetails = empDetailsArray;
		double riceSubsidy = Double.parseDouble(empDetails[14]);
		return riceSubsidy;
	}
	
	public double getPhoneAllowance(String inputEmpId) throws IOException {
		employeeDetails(inputEmpId);
		String [] empDetails = empDetailsArray;
		double phoneAllowance = Double.parseDouble(empDetails[15]);
		return phoneAllowance;
	}
	
	public double getClothingAllowance(String inputEmpId) throws IOException {
		employeeDetails(inputEmpId);
		String [] empDetails = empDetailsArray;
		double clothingAllowance = Double.parseDouble(empDetails[16]);
		return clothingAllowance;
	}
	
}
