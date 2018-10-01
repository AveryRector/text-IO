package lab10;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class LineNumbers {

	public static void parseData(File inputFile, File outputFile) {
		try {
		Scanner in = new Scanner(inputFile); // read input file
		PrintWriter out = new PrintWriter(outputFile); // write to output file
		
		ArrayList<String> lines = new ArrayList<String>();

		int totalSum = 0;
		while(in.hasNextLine()) { // loop through each line
			String line = in.nextLine(); // save line in memory
			int sumOfLine = line.length();

			lines.add(Integer.toString(sumOfLine)); // add total num of characters to ArrayList
			lines.add(line); // add the line to ArrayList
			
			totalSum += sumOfLine;
			
		}
		
		lines.add(0, Integer.toString(totalSum)); // add totalSum of characters to first index of ArrayList
		out.println("File contains " + lines.get(0) + " characters");  // prints the first line
		
		// for loop that will print correct format of ec line.
		// increments by two b.c they come in pairs     line length, line 
		for(int i = 1; i < lines.size() - 1; i += 2) {
			// if there are 0 characters
			if(lines.get(i).equals("0")) { 
				out.printf("%-10s%s%n", lines.get(i), "");
			}
			else {
			out.printf("%-10s%1s%n", lines.get(i), lines.get(i + 1)); 
			}
		}
		
		in.close();
		out.close();
		} 
		catch (IOException e) {
			System.out.println(e);
		}
	}
}
