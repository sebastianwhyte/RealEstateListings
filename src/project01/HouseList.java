package project01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
		for (House h: houseList)
		{
			System.out.println(h);
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
			System.out.println(h.toString());
			/*
			{	
				System.out.println(h.toString());
			}
			*/
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

}
