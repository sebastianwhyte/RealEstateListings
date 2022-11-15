package project01;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
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
	// Instance variables
	private HouseList availableHouses;
	private static Stage mainStage;
	
	
	// ------------------------------------------------------------------
	
	/*
	 * Starts the application
	 * 
	 * @param a stage
	 */
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
	
		}
		catch(Exception e)
		{
			System.out.println("HouseListTestor:start - could not create HouseList object");
			e.printStackTrace();
		}
		
		
		WindowPosition.placeCenter(mainStage);
		
		mainStage.show();
		
	}
	
	// ------------------------------------------------------------------
	
	public static Stage getStage()
	{
		return mainStage;
	}
	
	
	// ------------------------------------------------------------------
	
	// Main method 
	public static void main(String[] args)
	{
		launch(args);
		
	}
}
