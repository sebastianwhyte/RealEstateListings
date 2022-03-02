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
	
	/* Constructor
	 * @param name of the file 
	 */
	public HouseList(String filename)
	{
		// Scanner object to read file
		Scanner fileIn = null;
				
		// Try to open file
		try
		{
			fileIn = new Scanner(new File(filename));
			
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File " + filename + " was not found");
		}
		 
		
		// While file has more data, create House objects
		while (fileIn.hasNext())
		{
				// Temp variables to save data for each house
				address = fileIn.next();
				price = fileIn.nextInt();
				area = fileIn.nextInt();
				numBedrooms = fileIn.nextInt();
			
				// Create a House object and pass in the temp variables as arguments
				House house = new House(address, price, area, numBedrooms);
				
				// Add new house to houseList
				houseList.add(house);	
		}
	}
	
	// ----------------------------------------------------------------
	
	/* Print all the houses that satisfy the requirement r 
	 * @param a Requirement object
	 */
	public void printHouses(Requirement r)
	{
		for (House h: houseList)
		{
			
			if (h.satisfies(r))
			{	
				System.out.println(h.toString());
			}
		}
	}
	
	// ----------------------------------------------------------------
	
	/* Returns concatenated string of the details of all houses that satisfy the requirement r 
	 * @param a Requirement object
	 * @return String: result of concatenated string of a description of the houses 
	 * 
	 */	
	public String getHouses(Requirement r)
	{	
		for (House h: houseList)
		{
			if (h.satisfies(r))
			{
				return h.toString();
			}
		}
		
		return "No results";
	}

}
