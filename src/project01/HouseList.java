package project01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import user_interface.RealEstateScene;
import user_interface.WindowPosition;

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
	private ArrayList<House> alreadySeenHouses = new ArrayList<>();		// store the previously seen houses
	private int price;
	private int area;
	private int numBedrooms;
	private String address;
	private RealEstateScene rScene;
	private Stage stage;
	private Scene currentScene;

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
				
				stage = HouseListTester.getStage();
						
				// Call to set up the real estate view
				createAndShowRealEstateView();
		}
	}
	
	// ----------------------------------------------------------------
	

	// TESTING OUTPUT
	public void printHouses()
	{
		// Create a Random object
		Random random = new Random();
					
		// Assigns a random element from houseList to the House object
		House house = houseList.get(random.nextInt(houseList.size()));
			
		// TEST OUTPUT 
		System.out.println("Chosen Home: " + house);
		System.out.println();
		
		// Add already seen houses to list
		alreadySeenHouses.add(house);
		houseList.remove(house);
		
		// TEST OUTPUT for available houses
		System.out.println("Available Houses:");
		
		for (House h : houseList)
		{
			if (houseList.isEmpty())
			{
				System.out.println("No more available houses");
			}
			
			System.out.println(h);
		}
		
		// Print gap between the list outputs
		System.out.println();
		
		// TEST OUTPUT for already seen houses
		System.out.println("Houses already seen:");
		
		for (House h : alreadySeenHouses)
		{
			// Try to add house to already seen list
			try
			{
				System.out.println(h);
			}
			catch (Exception e)
			{
				System.out.println("No more houses to add");
			}
			
		}
		
		// Print gap are the list outputs
		System.out.println();
		
		//System.out.println(h.toString());	
		
		/*
		for (House h: houseList)
		{
			System.out.println(h);
		}
		*/
	}
	
	// ----------------------------------------------------------------
	
	/* Print all the houses that satisfy the requirement r 
	 * @param a Requirement object
	 */
	public void printHouses(Requirement r)
	{
		for (House h: houseList)
		{
			System.out.println(h.toString());
			
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
	
	
	// ----------------------------------------------------------------
	
	/*
	 * Creates and displays the Real Estate View
	 */
	private void createAndShowRealEstateView() 
	{
		// Create a new Real Estate Scene object 
		rScene = new RealEstateScene("Real Estate View", this);
		// Pass the Real Estate Scene into the current Scene;
		currentScene = new Scene(rScene);
		
		// Make the view visible by installing it into the stage 
		swapToView(currentScene);		
	}

	
	// ----------------------------------------------------------------
	
	/*
	 * Swaps to the current scence
	 * 
	 * @param current scene
	 */
	
	private void swapToView(Scene currentScene) 
	{
		// Check if the scene is null
		if (currentScene == null)
	      {
	    	  System.out.println("HouseList.swapToView(): Missing view for display"); 
	    	  return;
	      }
		
		// Swap the scene of the stage
		stage.setScene(currentScene);
		// Resize the stage to fit the scene size
		stage.sizeToScene();
		//Place in stage in center again 
		WindowPosition.placeCenter(stage);
		
	}

	/**
	 * @param props
	 */
	public void processListing(Properties props) 
	{
		// UPDATE THIS TO REFLECT HOUSE LIST / REAL ESTATE LISTINGS PROJECT	
		// Copy the flow of Invoice : processInvoice 
		int minPrice = Integer.parseInt(props.getProperty("Minimum Price")); 
		int maxPrice = Integer.parseInt(props.getProperty("Maximum Price")); 
		int minArea = Integer.parseInt(props.getProperty("Minimum Area"));
		int maxArea = Integer.parseInt(props.getProperty("Maximum Area"));
		int minBeds = Integer.parseInt(props.getProperty("Minimum Beds"));
		int maxBeds = Integer.parseInt(props.getProperty("Maximum Beds"));
					
		
		/*
		 * TAKE A RANDOM INDEX FROM THE HOUSE LIST ARRAYLIST, THEN ITERATE THROUGH THE
		 * LIST TO PICK A RANDOM ELEMENT. PASS THAT ELEMENT INTO PRINT HOUSES() METHOD TO TEST
		 * 
		 * 
			// Convert the parameters from String to int
			int minPrice = Integer.parseInt(minPriceValue);
			int maxPrice = Integer.parseInt(maxPriceValue);
			int minArea = Integer.parseInt(minAreaValue);
			int maxArea = Integer.parseInt(maxAreaValue);
			int minBeds = Integer.parseInt(minBedsValue);
			int maxBeds = Integer.parseInt(maxBedsValue);
			
		*/
		
		// Create a Requirement object
		Requirement r = new Requirement(minPrice, maxPrice, minArea, maxArea, minBeds, maxBeds);
		
		//THEN PASS THE REQUIREMENT OBJECT INTO PRINT HOUSES
		printHouses();
	
		
		
		/*			
		// Set default value to 0
		double totalBill = 0;
					
		// Add all the items in the order together
		double preTaxSum = dripCost + mochaCost + sconesCost + sandwichCost;
		// Now apply tax
		double totalTax = preTaxSum * (salesTax/100);
		totalBill = preTaxSum + totalTax;
					
					
		String formatTotalBill = String.format("%.2f", totalBill);
					
		invoiceView.updateState("Total Bill", formatTotalBill);
		*/		
	}

}
