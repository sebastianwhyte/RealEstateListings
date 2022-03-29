package project01;

//import java.util.Scanner;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
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
	private Stage mainStage;
	
	public void start(Stage primaryStage)
	{
		System.out.println("Real Estate Listings Version 1.00"); 
		System.out.println("Copyright ©2022 Sebastian Whyte");
		
		// Create the main stage & add contents to it
		MainStageContainer.setStage(primaryStage, "Real Estate Listings V 1.0");
		mainStage = MainStageContainer.getStage();
		
		// Enable the GUI to be closed by using the top right X
		mainStage.setOnCloseRequest(new EventHandler <javafx.stage.WindowEvent>() 
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
		}
		catch(Exception e)
		{
			System.out.println("HouseListTestor:start - could not create HouseList object");
			e.printStackTrace();
		}
		
		// Place the stage in the center of the screen
		WindowPosition.placeCenter(mainStage);
		
		// Display the stage
		mainStage.show();
	
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
