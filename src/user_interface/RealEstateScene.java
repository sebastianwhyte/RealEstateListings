package user_interface;

import java.util.Properties;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
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
import project01.Requirement;


/* This class provides the Scene for the main real estate view
 * 
 * @author Sebastian Whyte
 * @version v1.0, April 2 2022
 *
 */


public class RealEstateScene extends Group
{
	// Instance variables
	//private String classname;
	private HouseList houseList;
	private TextField minPriceTextField;
	private TextField maxPriceTextField;
	private TextField minAreaTextField;
	private TextField maxAreaTextField;
	private TextField minBedsTextField;
	private TextField maxBedsTextField;
	private TextField chosenHomeTextField;
	private Button findDreamHouseButton;
	private Button notMyDreamButton;
	private Button resetButton;
	
	
	// ------------------------------------------------------------------
	
	/* 
	 * Constructor
	 * @param classname
	 */
	
	public RealEstateScene(HouseList houseList)
	{
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
		titleText.setFill(Color.BLACK);
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
		VBox vbox = new VBox(20);
		
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
		
		// Create max price text label then add it to the grid
		Text maxPriceLabel = new Text("Maximum Price: ");
		maxPriceLabel.setWrappingWidth(150);
		maxPriceLabel.setTextAlignment(TextAlignment.RIGHT); 
		grid.add(maxPriceLabel, 0, 1);
				
		// Create TextField for max price
		maxPriceTextField = new TextField();
		maxPriceTextField.setMinSize(100, 20);
		grid.add(maxPriceTextField, 1, 1);
		
		// Create minimum area label then add it to grid
		Text minAreaLabel = new Text("Minimum Area: "); 
		minAreaLabel.setWrappingWidth(150); 
		minAreaLabel.setTextAlignment(TextAlignment.RIGHT); 
		grid.add(minAreaLabel, 0, 2);
				
		// Create Text Field for minimum price 
		minAreaTextField = new TextField();
		minAreaTextField.setMinSize(100, 20); 
		grid.add(minAreaTextField, 1, 2);
				
		// Create max area label then add it to grid
		Text maxAreaLabel = new Text("Maximum Area: "); 
		maxAreaLabel.setWrappingWidth(150); 
		maxAreaLabel.setTextAlignment(TextAlignment.RIGHT); 
		grid.add(maxAreaLabel, 0, 3);
				
		// Create text field for max area
		maxAreaTextField = new TextField(); 
		maxAreaTextField.setMinSize(100, 20);
		grid.add(maxAreaTextField, 1, 3);
				
		// Create minimum beds label then add it to grid
		Text minBedsLabel = new Text("Minimum Beds: "); 
		minBedsLabel.setWrappingWidth(150); 
		minBedsLabel.setTextAlignment(TextAlignment.RIGHT); 
		grid.add(minBedsLabel, 0, 4);
					
		// Create text field for minimum beds
		minBedsTextField = new TextField(); 
		minBedsTextField.setMinSize(100, 20);
		grid.add(minBedsTextField, 1, 4);
				
		// Create max beds label then add it to grid
		Text maxBedsLabel = new Text("Maximum Beds: "); 
		maxBedsLabel.setWrappingWidth(150); 
		maxBedsLabel.setTextAlignment(TextAlignment.RIGHT); 
		grid.add(maxBedsLabel, 0, 5);
				
		// Create text field for max beds
		maxBedsTextField = new TextField(); 
		grid.add(maxBedsTextField, 1, 5);
		
		// Create chosen home label then add it to grid
		Text chosenHomeLabel = new Text("Chosen Home: "); 
		chosenHomeLabel.setWrappingWidth(150); 
		chosenHomeLabel.setTextAlignment(TextAlignment.RIGHT); 
		grid.add(chosenHomeLabel, 0, 6);
						
		// Create text field for max beds
		chosenHomeTextField = new TextField(); 
		grid.add(chosenHomeTextField, 1, 6);
				
				
		
		// Create "find dream house" button & add event handler to it
		findDreamHouseButton = new Button("Find my dream house!"); 
		findDreamHouseButton.setAlignment(Pos.CENTER_LEFT);
		
		findDreamHouseButton.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent e) 
			{
				notMyDreamButton.setDisable(false);
				
				// Process the event
				processAction(e);
				
				findDreamHouseButton.setDisable(true);
			}
		});
		
		
		// Create "not my dream house" button & add event handler to it
		notMyDreamButton = new Button("Not my dream house - find me another!"); 
		notMyDreamButton.setDisable(true);
		
		notMyDreamButton.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent e) 
			{
				// Process the event 
				processAction(e);
			} 
		});
		
		
		// Create a reset button & add event handler to it
		resetButton = new Button("Reset"); 
		resetButton.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent e) 
			{
				processReset(e);
			} 
		});
				
		
		// Create hbox container to hold the buttons
		HBox buttonContainer = new HBox(10);
		buttonContainer.setAlignment(Pos.CENTER);
		buttonContainer.setPadding(new Insets(5,20,5,20));
		buttonContainer.getChildren().add(findDreamHouseButton); 
		buttonContainer.getChildren().add(notMyDreamButton);
		
		// Create hbox container to hold rest button
		HBox resetButtonContainer = new HBox();
		resetButtonContainer.setAlignment(Pos.CENTER);
		resetButtonContainer.getChildren().add(resetButton);
		
		
		// Add the grid and button container to the vbox
		vbox.getChildren().add(grid);
		vbox.getChildren().add(buttonContainer);
		vbox.getChildren().add(resetButtonContainer);
		
		return vbox;
	}

	
	// ------------------------------------------------------------------
	
	/*
	 *  Process events from the GUI components
	 *  
	 *  @param event to process
	 */
	private void processAction(ActionEvent e) 
	{
		// Get the values from the TextFields
		String minPriceValue = minPriceTextField.getText();
		String maxPriceValue = maxPriceTextField.getText();
		String minAreaValue = minAreaTextField.getText();
		String maxAreaValue = maxAreaTextField.getText();
		String minBedsValue = minBedsTextField.getText();
		String maxBedsValue = maxBedsTextField.getText();
		
		
		/* Check if the user leaves the TextFields empty
		 * 
		 * The program should assume the value of a field is 0 if the field is left blank 
		 * for the “minimum fields” (price, area, beds). 
		 * 
		 * It should assume the value of a field is Integer.MAX_VALUE if the field is 
		 * one of the “maximum fields” (again, for price, area or number of bedrooms)
		 *
		 */
		
		if (minPriceValue == null || minPriceValue.length() == 0)
		{
			minPriceValue = "0";
		}
		if (minAreaValue == null || minAreaValue.length() == 0)
		{
			minAreaValue = "0";
		}
		if (minBedsValue == null || minBedsValue.length() == 0)
		{
			minBedsValue = "0";
		}		
		if (maxPriceValue == null || maxPriceValue.length() == 0)
		{
			int maxPrice = Integer.MAX_VALUE;
			
			maxPriceValue = Integer.toString(maxPrice);
		}
		if (maxAreaValue == null || maxAreaValue.length() == 0)
		{
			int maxArea = Integer.MAX_VALUE;
			
			maxAreaValue = Integer.toString(maxArea);
		}
		if (maxBedsValue == null || maxBedsValue.length() == 0)
		{
			int maxBeds = Integer.MAX_VALUE;
			
			maxBedsValue = Integer.toString(maxBeds);
		}
		
		// Pass arguments into the method
		setPropertyValues(minPriceValue, maxPriceValue, minAreaValue, maxAreaValue, minBedsValue, maxBedsValue);
	} 
	
	
	// ------------------------------------------------------------------
	
	/* 
	 * Assign the data selected and entered by user into properties/props
	 * 
	 * @param minPriceValue
	 * @param maxPriceValue
	 * @param minAreaValue
	 * @param maxAreaValue
	 * @param minBedsValue
	 * @param maxBedsValue
	 */
	private void setPropertyValues(String minPriceValue, String maxPriceValue, String minAreaValue, String maxAreaValue,
			String minBedsValue, String maxBedsValue) 
	{
		Properties props = new Properties(); 
		props.setProperty("Minimum Price", minPriceValue); 
		props.setProperty("Maximum Price", maxPriceValue); 
		props.setProperty("Minimum Area", minAreaValue); 
		props.setProperty("Maximum Area", maxAreaValue); 
		props.setProperty("Minimum Beds", minBedsValue);
		props.setProperty("Maximum Beds", maxBedsValue);
		
		houseList.processListing(props);
		
	}

	
	// ------------------------------------------------------------------
	
	public void processReset(ActionEvent e)
	{
		// Clear the already seen houses list
		houseList.getAlreadySeenHouses().clear();
		
		notMyDreamButton.setDisable(true);
		findDreamHouseButton.setDisable(false);
		populateFields();
	}

	// ------------------------------------------------------------------
	
	private void populateFields() 
	{
		// Set the default values as empty strings
		minPriceTextField.setText("");
		minAreaTextField.setText("");
		minBedsTextField.setText("");
		maxPriceTextField.setText("");
		maxAreaTextField.setText("");
		maxBedsTextField.setText("");
		chosenHomeTextField.setText("");
	}
	
	
	// ------------------------------------------------------------------
	
	/* Updates the chosen home Text Field
	 * 
	 * @param house
	 */
	public void updateState(Object house)
    {
        chosenHomeTextField.setText((String)house);
        
    }
	
	// ------------------------------------------------------------------
	
	/* Updates the chosen home Text Field
	 * 
	 * @param house
	 */
	public void updateState(String updatedHouse)
	{
	  chosenHomeTextField.setText(updatedHouse);
	        
	}
	

}
