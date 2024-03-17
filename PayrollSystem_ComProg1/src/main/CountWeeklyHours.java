package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CountWeeklyHours {

	public void countWeeklyHours(String inputEmpId) throws ParseException, IOException {
		// identify the file directory
		String file = System.getProperty("user.dir") + "/data/AttendanceRecordv3.csv";
		FileReader fr = new FileReader (file);
//		FileReader fr = new FileReader ("./data/AttendanceRecordv3.csv");
		BufferedReader br = new BufferedReader (fr);
		ComputeMonthlySalary monthlySalary = new ComputeMonthlySalary();
		GetCalendarDates calendarDates = new GetCalendarDates();
		GetEmployeeDetails employeeDetails = new GetEmployeeDetails();
		CountMonthlyHours monthlyHours = new CountMonthlyHours();
		String line;
		int totalHours = 0;
	
		//instantiate lists
		ArrayList<String> empNumList = new ArrayList<String>();
		ArrayList<String> dateList = new ArrayList<String>();
		ArrayList<Date> timeInList = new ArrayList<Date>();
		ArrayList<Date> timeOutList = new ArrayList<Date>();
		
		DateFormat sdfTime = new SimpleDateFormat("HH:mm");
		
		br.readLine();
		// if line is not null, split each row element by comma
		while ((line = br.readLine()) != null) {
			//comma as separators
			String[] cols = line.split(",");
			
			//place all employee number in one list
			String empNum = cols[0];
			empNumList.add(empNum.trim());
			//place all date in one list
			String dateString = cols[1];
//			Date date = sdfDate.parse(dateString);
			dateList.add(dateString.trim());
			//place all time in in one list
			String timeInString = cols[2];
			Date timeIn = sdfTime.parse(timeInString.trim());
			timeInList.add(timeIn);
			//place all timeout in one list
			String timeOutString = cols[3];
			Date timeOut  = sdfTime.parse(timeOutString.trim());
			timeOutList.add(timeOut);
			
		}
		
		Scanner scanner = new Scanner (System.in);
		System.out.println();
		System.out.println(". . . . . . . . . . . . . . . . . . .");
		System.out.println();
		System.out.print("Please enter the date you \nwant to be included (ex. 26/12/2022): ");
		String inputDate = scanner.nextLine();
		//validate input date versus available dates from database
		CheckInputDate checkInputDate = new CheckInputDate();
		String checkedInputDate = checkInputDate.checkedInputDate(inputDate);
		inputDate = checkedInputDate;
		
		ArrayList<String> weekDays = calendarDates.getDatesOfTheWeek(inputDate);
		
			System.out.println();
			int z = 0;
			int minutes = 0;
			int hours = 0;
			long dailyHoursRendered = 0;
			String remarks;
			Date timeInDefault = sdfTime.parse("08:00");

			System.out.println("|-----------------------------------------------------------------------------------------|");
			System.out.println("|   Employee ID     Date           Time In     Time Out     Hours Rendered      Remarks   |");
			System.out.println("|-----------------------------------------------------------------------------------------|");
			do {
			
				for ( int i = 0; i < empNumList.size() & z < 7; i++) {
					Boolean empIdBoolean = inputEmpId.equals(empNumList.get(i));
					Boolean dateBoolean = weekDays.get(z).equals(dateList.get(i));
					if (empIdBoolean == true && dateBoolean == true) {
						z++;
						
						Date timeOutChoice = timeOutList.get(i);
						Date timeInChoice = timeInList.get(i);
						if (timeInChoice.getTime() < 0 ) {
							dailyHoursRendered = 0;
							totalHours += 0;
							remarks = " - Absent  |";
						}
						else if (timeInChoice.getTime() > 900000 ) {
							dailyHoursRendered = (timeOutChoice.getTime() - timeInChoice.getTime());
							if (dailyHoursRendered > 18000000) {
								dailyHoursRendered -= 3600000;
							} else continue;
							totalHours += dailyHoursRendered;
							if ((dailyHoursRendered / (1000*60)) % 60 > 0) {
								remarks = "- Late    |";
							} else remarks = " - Late    |";
						} else {
							dailyHoursRendered = (timeOutChoice.getTime() - timeInDefault.getTime());
							if (dailyHoursRendered > 18000000) {
								dailyHoursRendered -= 3600000;
							} else continue;
							totalHours += dailyHoursRendered;
							remarks = " - OK      |";
						}
					
						long minutesRendered = (dailyHoursRendered / (1000*60)) % 60;
						long hoursRendered = (dailyHoursRendered / (1000*60*60));
						String timeOutChoiceString = sdfTime.format(timeOutChoice);
						String timeInChoiceString = sdfTime.format(timeInChoice);
						
						System.out.println("|   "+empNumList.get(i) + "           "+dateList.get(i)+"     "+timeInChoiceString+"       "+timeOutChoiceString+"        "+hoursRendered+"Hrs. "+minutesRendered+"mins.       "+remarks);
						
						
					} else continue;
					
				
			} 
			z++;
			continue;
			} while (dateList.indexOf(weekDays.get(0)) < 0 && (z <7));
		

		System.out.println("|                                                                                         |");
		System.out.println("|-----------------------------------------------------------------------------------------|");
		System.out.println();
		
		minutes = (totalHours / (1000*60)) % 60;
		hours = (totalHours / (1000*60*60));
		System.out.println("Total Weekly Hours:      "+hours+"Hrs. "+minutes+"mins. ");
		Double hourlyRate = employeeDetails.getHourlyRate(inputEmpId);
		System.out.println("Hourly Rate:             "+hourlyRate);
		
		double weeklySalary = (hours + (minutes/60))*hourlyRate;
		DecimalFormat formatter = new DecimalFormat("#,###.00");
		System.out.println("                       -------------");
		System.out.println("Total weekly salary:     "+formatter.format(weeklySalary));
			
		System.out.println();
		System.out.println();
		System.out.println(". . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .");
		System.out.println(".                                                                 .");
		System.out.println(".  Sub-Menu:                                                      .");
		System.out.println(".  1. View Basic Details                                          .");
		System.out.println(".  2. Compute for this employee's Monthly Hours                   .");
		System.out.println(".  3. Compute Net Monthly Salary                                  .");
		System.out.println(".  4. Go back to Main menu to check for other employees           .");
		System.out.println(".  5. Exit                                                        .");
		System.out.println(".                                                                 .");
		System.out.println(". . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .");
		System.out.println();	
		System.out.print("Please enter your choice: ");
		String userInputSubOption = scanner.nextLine();
		if (userInputSubOption.equals("1") == true) {
			employeeDetails.getEmployeeDetails(inputEmpId);
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
		br.close();
	}


	
}
