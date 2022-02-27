package project01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Contains an ArrayList of House objects. Reads the data from a file called houses.txt and 
 * adds them to the array list. Allows for searching of houses that satisfy requirements.
 * 
 * @author Sebastian Whyte
 * @version February 5, 2022
 */


public class HouseList 
{
	// Instance variables
	private ArrayList<House> houseList = new ArrayList<>();
	private int price;
	private int area;
	private int numBedrooms;
	private String address;

	// ----------------------------------------------------------------
	
	// Constructor
	public HouseList(String filename)
	{
		// Scanner object to read file
		Scanner fileIn = null;
				
		// Try to open file
		try
		{
			fileIn = new Scanner(new File(filename));
			System.out.println("File uploaded successfully!");
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File " + filename + " was not found");
		}
		 
		int houseCount = 0;
		
		// While file has more data & line is not null, create House objects
		while (fileIn.hasNext())
		{
			// Take the line & save its length
			String line = fileIn.nextLine();
			int lineLength = line.length();
			
			// Read line & make a new House object
			for (int i = 0; i <= lineLength; i++)
			{
				// Temp variables to save data for each house
				// Use split method 
				// While hasNext, read string, and then numbers
				address = fileIn.next();
				price = fileIn.nextInt();
				area = fileIn.nextInt();
				numBedrooms = fileIn.nextInt();
			
				House house = new House(address, price, area, numBedrooms);
				
				// Testing output - Debugging
				System.out.println(house);
				
				// Add new house to houseList
				houseList.add(house);
				houseCount++;
				
				// Testing for houseCount
				System.out.println(houseCount);
				
			}
		}
	}
	
	// ----------------------------------------------------------------
	
	// Print all the houses that satisfy the requirement r 
	// @param a Requirement object
	public void printHouses(Requirement r)
	{
		for (House h: houseList)
		{
			System.out.println(h);
		}
	}
	
	// ----------------------------------------------------------------
	
	/* Returns concatenated string of the details of all houses that satisfy the requirement r 
	 * @param a Requirement object
	 * @return String: result of concatenated string of a description of the houses 
	 * 
	 */
	
	/*
	public String getHouses(Requirement r)
	{
		 
	}
	*/
}
