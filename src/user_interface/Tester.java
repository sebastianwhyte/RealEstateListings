package user_interface;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;


/**
 * @author Sebastian Whyte
 * @version 03/26/2022
 *
 */
public class Tester extends Application
{
	// Instance variables
	private RealEstateView rv;
	private MainStageContainer m;
	private MainScene ms;
	private Stage mainStage;
	

	@Override
	public void start(Stage stage)
	{
		System.out.println("Real Estate Listings Version 1.00"); 
		System.out.println("Copyright ©2022 Sebastian Whyte");
		
		m.setStage(stage, "Real Estate Listings Version 1.00");
		
		// Get the stage from MainContainer & assign it to this main stage
		mainStage = m.getStage();
		
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
	        rv = new RealEstateView();
	    }
		catch(Exception e) 
		{
			// Print error 
			System.err.println("Tester:start - could not create " + "Real Estate View!"); 
			e.printStackTrace();
		}
		
		ms.placeCenter(mainStage);
		
		m
}
	

	/*
	public static void main(String[] args) 
	{
		launch(args);

	}
	*/
}
