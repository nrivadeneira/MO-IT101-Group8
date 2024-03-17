package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CheckInputDate {
	
	public String checkedInputDate (String inputDate) throws IOException {
		// identify the file directory
		String file = System.getProperty("user.dir") + "/data/AttendanceRecordv3.csv";
		FileReader fr = new FileReader (file);
//		FileReader fr = new FileReader ("./data/AttendanceRecordv3.csv");
		BufferedReader br = new BufferedReader (fr);
		Scanner scanner = new Scanner (System.in);
		String line;
		
		//instantiate variables
		ArrayList<String> availableDates = new ArrayList<String>();
		
		// if line is not null, split each row element by comma
		while ((line = br.readLine()) != null) {
			//comma as separators
			String[] cols = line.split(",");
			
			//place all available dates from attendance record in one list
			String availDate = cols[1];
			availableDates.add(availDate.trim());
			
		}
		
		String userInputDate = inputDate;
		
		// firstDate and lastDate is created only for the sysout "Choose from.." part
		String firstAvailDate = availableDates.get(1);
		String lastAvailDate = availableDates.get(availableDates.size()-1);

		while (availableDates.indexOf(userInputDate) < 0) {
//			userInputDate = inputDate;
			System.out.print("\nInput is not a valid Date from records\n** Available data are WEEKDAYS from: " + firstAvailDate+" - "+ lastAvailDate+" **\n(Enter date in this format dd/mm/yyyy): ");
			userInputDate = scanner.nextLine();
		} 
		
		return userInputDate;
		
	}
	

}
