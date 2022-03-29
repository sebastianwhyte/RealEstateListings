package user_interface;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

/*
 * This class provides a means of placing the main stage of the application * in the center of the screen, top left corner, bottom right
 * corner, top right corner, bottom left corner
 * 
 * @author Sebastian Whyte 
 * @version 03/22/2022
 *
 */


public class WindowPosition 
{
	// Instance variables
	private static Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

	
	//---------------------------------------------------------------
	
	/*
	* Used to place the stage in the center of the screen
	*
	* @param s Stage to place at the center of the screen
	*
	*/ 
	
	public static void placeCenter(Stage stage)
	{
		if (stage != null)
		{
			stage.centerOnScreen();
		} 
	}
	
	//--------------------------------------------------------------
	
	/*
	* Used to place a stage at the top left corner of the screen
	*
	* @param s Stage to place at the top left corner of the screen 
	* 
	*/
	
	public static void placeTopLeft(Stage stage)
	{
		if (stage != null)
		{
			stage.setX(primaryScreenBounds.getMinX()); stage.setY(primaryScreenBounds.getMinY());
		} 
	}
	
	//--------------------------------------------------------------
	
	/*
	* Used to place a stage at the top right corner of the screen
	*
	* @param s Stage to place at the top right corner of the screen
	* 
	*/
	
	public static void placeTopRight(Stage stage)
	{
		if (stage != null)
		{
			stage.setX(primaryScreenBounds.getMinX() + primaryScreenBounds.getWidth() - stage.getWidth());
			stage.setY(primaryScreenBounds.getMinY());
		} 	

	}
	
	//--------------------------------------------------------------
	
	/*
	* Used to place a stage at the bottom left corner of the screen
	*
	* @param s Stage to place at the bottom left corner of the screen
	* 
	*/
	
	public static void placeBottomLeft(Stage stage)
	{
		if (stage != null)
		{
			stage.setX(primaryScreenBounds.getMinX()); 
			stage.setY(primaryScreenBounds.getMinY() + primaryScreenBounds.getHeight() - stage.getHeight());
		} 	
	}
	
	//--------------------------------------------------------------
	
	/* 
	* Used to place a stage at the bottom right corner of the screen *
	* @param s Stage to place at the bottom-right corner of screen 
	* 
	*/
	
	public static void placeBottomRight(Stage stage)
	{
		if (stage != null)
		{
			stage.setX(primaryScreenBounds.getMinX() + primaryScreenBounds.getWidth() - stage.getWidth()); 
			stage.setY(primaryScreenBounds.getMinY() + primaryScreenBounds.getHeight() - stage.getHeight());
		}
	}


}
