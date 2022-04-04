package project01;

//import java.util.Scanner;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import user_interface.MainStageContainer;
import user_interface.WindowPosition;
import project01.HouseList;

/**
 * Tester class for Real Estate Listing project
 * 
 * @author Sebastian Whyte
 * @version 2.0 (03/28/2022)
 *
 */

public class HouseListTester extends Application
{
	private HouseList availableHouses;
	private static Stage mainStage;
	
	public void start(Stage primaryStage)
	{
		// Copyright and version info 
		System.out.println("Real Estate Listings Version 1.00"); 
		System.out.println("Copyright ©2022 Sebastian Whyte");
		
		// Set properties of the stage
		primaryStage.setTitle("Real Estate Listings V 1.0");
		primaryStage.setResizable(false);
		
		mainStage = primaryStage;
		
		// Enable the GUI to be closed by using the top right X
		primaryStage.setOnCloseRequest(new EventHandler<javafx.stage.WindowEvent>()
		{
			@Override
			public void handle(javafx.stage.WindowEvent event) 
			{
				System.exit(0);
						
			}
		});
		
		
		try
		{
			// Create a HouseList object
			availableHouses = new HouseList("houses.txt");
			// Test if houses from text file are being added to arraylist
			System.out.println();
			//availableHouses.printHouses();
		}
		catch(Exception e)
		{
			System.out.println("HouseListTestor:start - could not create HouseList object");
			e.printStackTrace();
		}
		
		
		WindowPosition.placeCenter(mainStage);
		
		mainStage.show();
		
		/*
		// Place stage in the center of the screen
		WindowPosition.placeCenter(primaryStage);
		
		// Show the stage
		primaryStage.show();
		*/
		
	}
	
	public static Stage getStage()
	{
		return mainStage;
	}
	
	
	public static void main(String[] args)
	{
		launch(args);
		
		/*
		Scanner sc = new Scanner (System.in);
		
		// Create HouseList object & pass file into it
		HouseList availableHouses = new HouseList("houses.txt");
		
		// -------------------------------------------------------
	
		{
			// Prompt user for their requirements & store them
			System.out.println("Enter your requirements: ");
			
			System.out.print("Enter minimum price: ");
			int minumumPrice = sc.nextInt();
			System.out.print("Enter maximum price: ");
			int maxiumumPrice = sc.nextInt();
			System.out.print("Enter minimum area: ");
			int minumumArea = sc.nextInt();
			System.out.print("Enter maximum area: ");
			int maxiumumArea = sc.nextInt();
			System.out.print("Enter minimum number of beds: ");
			int minumumNumberOfBedrooms = sc.nextInt();
			System.out.print("Enter maximum number of beds: ");
			int maxiumumNumberOfBedrooms = sc.nextInt();
			
			// Pass the variables as arguments into the Requirement object
			Requirement r = new Requirement(minumumPrice, maxiumumPrice, minumumArea, maxiumumArea, minumumNumberOfBedrooms, maxiumumNumberOfBedrooms);
			
			// Print out the results
			System.out.println("\nResults: ");
			availableHouses.printHouses(r);
			System.out.println();
		}
		*/
	}
}
