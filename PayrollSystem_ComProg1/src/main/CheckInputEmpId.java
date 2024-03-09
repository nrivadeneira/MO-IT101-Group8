package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class CheckInputEmpId {
	
	public String checkInputEmpId (String inputEmpId) throws IOException {
	
		FileReader fr = new FileReader ("./data/EmployeeDetails.csv");
		BufferedReader br = new BufferedReader (fr);
		CountWeeklyHours weeklyHours = new CountWeeklyHours();
		String line;
	
		//instantiate lists
		ArrayList<String> empNumList = new ArrayList<String>();
		
		// if line is not null, split each row element by comma
		while ((line = br.readLine()) != null) {
			//comma as separators
			String[] cols = line.split(",");
			//System.out.println("Employee Number: " + cols[0]+" ; "+"Employee Name: "+cols[1]+", "+cols[2]+" ; "+"Birthday: "+cols[3]);
	
			//place all employee number in one list
			String empNum = cols[0];
			empNumList.add(empNum.trim());
			
		}
		
		String userInput = inputEmpId;
		userInput = userInput.replaceAll("[^\\d.]", "0");
		int inputInt = Integer.parseInt(userInput);
		
		// firstEmpNum and lastEmpNum is created only for the sysout "Choose from.." part
		String firstEmpNum = empNumList.get(1);
		int firstEmpNumInt = Integer.parseInt(firstEmpNum);
		String lastEmpNum = empNumList.get(empNumList.size()-1);
		int lastEmpNumInt = Integer.parseInt(lastEmpNum);

		Scanner scanner = new Scanner (System.in);
		
		if (userInput.length() != 5) {
			while (userInput.length() != 5) {
				System.out.println();
				System.out.print("Please enter a five digit Employee number\n(Choose from: " + firstEmpNum+"-"+ lastEmpNum+"): ");
				userInput = scanner.nextLine();
				userInput = userInput.replaceAll("[^\\d.]", "0");
				inputInt = Integer.parseInt(userInput);
			} 
		} 
		
		if (userInput.length() == 5) {
			while ((inputInt < firstEmpNumInt) || inputInt > lastEmpNumInt) {
				System.out.println();
				System.out.print("Input is not a valid Employee Number\n(Choose from: " + firstEmpNum+"-"+ lastEmpNum+"): ");
				userInput = scanner.nextLine();
				userInput = userInput.replaceAll("[^\\d.]", "0");
				inputInt = Integer.parseInt(userInput);
			}
		}
		
		return userInput;
	
	}

}



