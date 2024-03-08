package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class GetEmployeeDetails {
	public  void getEmployeeDetails(String inputEmpId) throws IOException, ParseException {
		FileReader fr = new FileReader ("./data/EmployeeDetailsv3.csv");
		BufferedReader br = new BufferedReader (fr);
		CountWeeklyHours weeklyHours = new CountWeeklyHours();
		ComputeMonthlySalary monthlySalary = new ComputeMonthlySalary();
		CountMonthlyHours monthlyHours = new CountMonthlyHours();
		String line;
	
		//instantiate lists
		ArrayList<String> empNumList = new ArrayList<String>();
		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<String> birthdayList = new ArrayList<String>();
		ArrayList<String> addressList = new ArrayList<String>();
		ArrayList<String> phoneNumList = new ArrayList<String>();
		ArrayList<String> sssList = new ArrayList<String>();
		ArrayList<String> philHealthList = new ArrayList<String>();
		ArrayList<String> tinList = new ArrayList<String>();
		ArrayList<String> pagIbigList = new ArrayList<String>();
		ArrayList<String> statusList = new ArrayList<String>();
		ArrayList<String> positionList = new ArrayList<String>();
		ArrayList<String> immediateSupList = new ArrayList<String>();
		ArrayList<String> basicSalList = new ArrayList<String>();
		ArrayList<String> riceSubList = new ArrayList<String>();
		ArrayList<String> phoneAllowanceList = new ArrayList<String>();
		ArrayList<String> clothingAllowanceList = new ArrayList<String>();
		ArrayList<String> grossSemiMonthlyList = new ArrayList<String>();
		ArrayList<String> hourlyRateList = new ArrayList<String>();
		
		// if line is not null, split each row element by comma
		while ((line = br.readLine()) != null) {
			//comma as separators
			String[] cols = line.split(",");
			//System.out.println("Employee Number: " + cols[0]+" ; "+"Employee Name: "+cols[1]+", "+cols[2]+" ; "+"Birthday: "+cols[3]);

			//place all employee number in one list
			String empNum = cols[0];
			empNumList.add(empNum.trim());
			//place all employee name in one list
			String name = (cols[1]+", "+cols[2]);
			nameList.add(name.trim());
			//place all birthday in one list
			String birthday = cols[3];
			birthdayList.add(birthday.trim());
			//place all employee number in one list
			String address = cols[4];
			addressList.add(address.trim());
			//place all employee name in one list
			String phoneNum = cols[5];
			phoneNumList.add(phoneNum.trim());
			//place all sss number in one list
			String sssNum = cols[6];
			sssList.add(sssNum.trim());
			//place all philHealth number in one list
			String philHealthNum = cols[7];
			philHealthList.add(philHealthNum.trim());
			//place all pagIbig number in one list
			String pagIbigNum = cols[9];
			pagIbigList.add(pagIbigNum.trim());
			//place all tin in one list
			String tinNum = cols[8];
			tinList.add(tinNum.trim());
			//place all birthday in one list
			String status = cols[10];
			statusList.add(status.trim());
			//place all sss number in one list
			String position = cols[11];
			positionList.add(position.trim());
			//place all philHealth number in one list
			String immediateSup = cols[12];
			immediateSupList.add(immediateSup.trim());
			//place all pagIbig number in one list
			String basicSal = cols[13];
			basicSalList.add(basicSal.trim());
			//place all tin in one list
			String riceSub = cols[14];
			riceSubList.add(riceSub.trim());
			//place all sss number in one list
			String phoneAllowance = cols[15];
			phoneAllowanceList.add(phoneAllowance.trim());
			//place all philHealth number in one list
			String clothingAllowance = cols[16];
			clothingAllowanceList.add(clothingAllowance.trim());
			//place all pagIbig number in one list
			String grossSemiMonthly = cols[17];
			grossSemiMonthlyList.add(grossSemiMonthly.trim());
			//place all tin in one list
			String hourlyRate = cols[18];
			hourlyRateList.add(hourlyRate.trim());
			
			
		}
		//to show output of each list
		//System.out.println(empNumList);
		//System.out.println(nameList);
		//System.out.println(birthdayList);
		
		//search index of user input's employee number in the empNumList
	
		// ask for user input
		Scanner scanner = new Scanner (System.in);
		
		int empNumIndex = empNumList.indexOf(inputEmpId);
		System.out.println();
		System.out.println();
		System.out.println("------------------------------------");
		System.out.println();
		System.out.println("Employee Number: " + empNumList.get(empNumIndex));
		System.out.println("Employee Name: " + nameList.get(empNumIndex));
		System.out.println("Birthday: " + birthdayList.get(empNumIndex));
		System.out.println("Address: " + addressList.get(empNumIndex));
		System.out.println("Phone#: " + phoneNumList.get(empNumIndex));
		System.out.println("SSS: " + sssList.get(empNumIndex));
		System.out.println("PhilHealth: " + philHealthList.get(empNumIndex));
		System.out.println("PagIbig: " + pagIbigList.get(empNumIndex));
		System.out.println("TIN: " + tinList.get(empNumIndex));
		System.out.println("Status: " + statusList.get(empNumIndex));
		System.out.println("Position: " + positionList.get(empNumIndex));
		System.out.println("Immediate Supervisor: " + immediateSupList.get(empNumIndex));
		System.out.println("Basic Salary: " + basicSalList.get(empNumIndex));
		System.out.println("Rice Subsidy: " + riceSubList.get(empNumIndex));
		System.out.println("Phone Allowance: " + phoneAllowanceList.get(empNumIndex));
		System.out.println("Clothing Allowance: " + clothingAllowanceList.get(empNumIndex));
		System.out.println("Gross Semi-Monthly Rate: " + grossSemiMonthlyList.get(empNumIndex));
		System.out.println("Hourly Rate: " + hourlyRateList.get(empNumIndex));
		System.out.println();
		System.out.println(". . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .");
		System.out.println(".                                                                 .");
		System.out.println(".  Sub-Menu:                                                      .");
		System.out.println(".  1. Compute for this employee's Weekly Hours & Weekly Salary    .");
		System.out.println(".  2. Compute for this employee's Monthly Hours                   .");
		System.out.println(".  3. Compute Net Monthly Salary                                  .");
		System.out.println(".  4. Go back to Main menu                                        .");
		System.out.println(".  5. None                                                        .");
		System.out.println(".                                                                 .");
		System.out.println(". . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .");
		System.out.println();
		System.out.print("Please enter your choice: ");
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
//		System.out.println("SSS Number: " + sssList.get(empNumIndex));
//		System.out.println("PhilHealth Number: " + philHealthList.get(empNumIndex));
//		System.out.println("Pag-Ibig Number: " + pagIbigList.get(empNumIndex));
//		System.out.println("Tin Number: " + tinList.get(empNumIndex));
		

		scanner.close();
		br.close();
		
	}
	
}
