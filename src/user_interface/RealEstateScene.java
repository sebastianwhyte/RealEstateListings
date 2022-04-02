package user_interface;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import project01.HouseList;

/* This class provides the Scene for the main real estate view
 * 
 * @author Sebastian Whyte
 * @version 1.0, April 2 2022
 *
 */

public class RealEstateScene extends Group
{
	// Instance variables
	private String classname;
	TextField minPriceTextField;
	HouseList houseList;
	
	
	// ------------------------------------------------------------------
	
	/* 
	 * Constructor
	 * @param classname
	 */
	
	public RealEstateScene(String classname, HouseList houseList)
	{
		this.classname = classname;
		this.houseList = houseList;
		
		// Create a container
		VBox container = new VBox(10);
		container.setPadding(new Insets(15,5,5,5));
		
		// Create the GUI components and add them to the panel
		container.getChildren().add(createTitle());
		container.getChildren().add(createFormContent());
		
		// Add the Vbox as a child of the Group
		getChildren().add(container);
		
		// Pre-populate the fields
		populateFields();
	}


	// ------------------------------------------------------------------
	
	/*
	 * Creates the title & sets its properties
	 * 
	 * @return container to hold the title
	 */
	private Node createTitle() 
	{
		// Create a hbox (horizontal) container to hold the title
		HBox container = new HBox();
		// Set the hbox in the center
		container.setAlignment(Pos.CENTER);
		
		// Create the title and set its properties
		Text titleText = new Text("Real Estate Listings");
		titleText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		titleText.setWrappingWidth(300);
		titleText.setTextAlignment(TextAlignment.CENTER);
		titleText.setFill(Color.DARKGREEN);
		container.getChildren().add(titleText);	
		
		return container;
	}
	
	
	// ------------------------------------------------------------------
	
	/* Creates the form content of the scene
	 * 
	 * @return container to hold the form
	 */
	
	private Node createFormContent() 
	{
		// Create a vbox (vertical) container to hold the form
		VBox vbox = new VBox(100);
		
		// Create a grid layout
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25,25,25,25));
		
		// Create minimum price text label then add it to the grid
		Text minPriceLabel = new Text("Minimum Price: ");
		minPriceLabel.setWrappingWidth(150);
		minPriceLabel.setTextAlignment(TextAlignment.RIGHT); 
		grid.add(minPriceLabel, 0, 0);
		
		// Create TextField for minimum price
		minPriceTextField = new TextField();
		minPriceTextField.setMinSize(100, 20);
		grid.add(minPriceTextField, 1, 0);
		
		// Add the grid to the vbox
		vbox.getChildren().add(grid);
		
		return vbox;
	}

	
	/**
	 * 
	 */
	private void populateFields() 
	{
		// Set the default value as an empty string
		minPriceTextField.setText("");
		
	}


}
