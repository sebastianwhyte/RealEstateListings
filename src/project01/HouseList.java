package project01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javafx.scene.Scene;
import javafx.stage.Stage;
import user_interface.RealEstateScene;
import user_interface.WindowPosition;

/*
 * Contains an ArrayList of House objects. Reads the data from a file called houses.txt and 
 * adds them to the array list. Allows for searching of houses that satisfy requirements.
 * 
 * @author Sebastian Whyte
 * @version V2.0 (04/05/2022)
 * 
 */


public class HouseList 
{

	private List<House> houseList = new ArrayList<>();
	private List<House> validHouses = new ArrayList<>();
	private Set<House> seen = new HashSet<>();
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
	
	/* Process the properties that are passed in
	 * 
	 * @param props from RealEstateScene : setPropertyValues
	 */
	
	public void processListing(Properties props) 
	{
		int minPrice = Integer.parseInt(props.getProperty("Minimum Price")); 
		int maxPrice = Integer.parseInt(props.getProperty("Maximum Price")); 
		int minArea = Integer.parseInt(props.getProperty("Minimum Area"));
		int maxArea = Integer.parseInt(props.getProperty("Maximum Area"));
		int minBeds = Integer.parseInt(props.getProperty("Minimum Beds"));
		int maxBeds = Integer.parseInt(props.getProperty("Maximum Beds"));
					
		
		// Create a Requirement object
		Requirement r = new Requirement(minPrice, maxPrice, minArea, maxArea, minBeds, maxBeds);
		
		// Pass in the requirement object & check if it satisfies the requirement
		printHouses(r);
		
	}


	// ----------------------------------------------------------------
	
	/* Print all the houses that satisfy the requirement r 
	 * 
	 * @param a Requirement object
	 */
	public void printHouses(Requirement r)
	{		
		if (validHouses.isEmpty())
		{
			// If a house meets the user requirements, then add it to valid houses list
			for (House h : houseList)
			{
				if (h.satisfies(r))
				{
					validHouses.add(h);
					
				}		
			}
		}
		
		
		// Create a Random object
		Random random = new Random();
		
		
		// Assigns a random element from houseList to the House object
		int randomHouse = random.nextInt(validHouses.size());
						
		// Get a random house from the valid house list
		House house = validHouses.get(randomHouse);

		rScene.updateState(house.toString());
		
		
		seen.add(house);
		validHouses.remove(house);
}
	
	// ----------------------------------------------------------------
	
	/* Returns concatenated string of the details of all houses that satisfy the requirement r 
	 * 
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
	
	public Set<House> getAlreadySeenHouses()
	{
		return seen;
	}
	
	
	// ----------------------------------------------------------------
	
	/*
	 * Creates and displays the Real Estate View
	 */
	private void createAndShowRealEstateView() 
	{
		// Create a new Real Estate Scene object 
		rScene = new RealEstateScene(this);
		// Pass the Real Estate Scene into the current Scene;
		currentScene = new Scene(rScene);
		
		// Make the scene visible by installing it into the stage 
		swapToView(currentScene);		
	}

	
	// ----------------------------------------------------------------
	
	/*
	 * Swaps to the current scene
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

}
