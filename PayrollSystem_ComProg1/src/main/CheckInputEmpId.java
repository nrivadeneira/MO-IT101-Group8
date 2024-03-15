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
		String line;
	
		//instantiate lists
		ArrayList<String> empNumList = new ArrayList<String>();
		
		// if line is not null, split each row element by comma
		while ((line = br.readLine()) != null) {
			//comma as separators
			String[] cols = line.split(",");
			
			//place all employee number in one list
			String empNum = cols[0];
			empNumList.add(empNum.trim());
			
		}
		
		String userInput = inputEmpId;
		
		// firstEmpNum and lastEmpNum is created only for the sysout "Choose from.." part
		String firstEmpNum = empNumList.get(1);
		int firstEmpNumInt = Integer.parseInt(firstEmpNum);
		String lastEmpNum = empNumList.get(empNumList.size()-1);
		int lastEmpNumInt = Integer.parseInt(lastEmpNum);

		Scanner scanner = new Scanner (System.in);
		
		
		while (empNumList.indexOf(userInput) < 0) {
			System.out.print("\nInput is not a valid Employee Number\n(Choose from: " + firstEmpNum+"-"+ lastEmpNum+"): ");
			userInput = scanner.nextLine();
		}
		
		return userInput;
	
	}

}



