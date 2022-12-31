package user_interface;

import java.util.Properties;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
 * @version V2.0 (04/02/2022)
 *
 */


public class RealEstateScene extends Group
{
	// Instance variables
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
		
		// Container to hold the form
		VBox container = new VBox(10);
		container.setPadding(new Insets(15,5,5,5));
		
		container.getChildren().add(createTitle());
		container.getChildren().add(createFormContent());
		
		getChildren().add(container);
		
		// Pre-populate the fields
		populateFields();
	}


	// ------------------------------------------------------------------
	
	/*
	 * Creates the title & sets its properties
	 * 
	 * @return container that holds the title
	 */
	private Node createTitle() 
	{
		// Title container
		HBox container = new HBox();
	
		container.setAlignment(Pos.CENTER);

		// Label for inserting logo
		Label logo = new Label();

		// Image to use for the label
		Image img = new Image("Real-Estate-Logo-2.png");
		ImageView imageView = new ImageView(img);
		logo.setGraphic(imageView);


		container.getChildren().add(logo);

		return container;
	}
	
	
	// ------------------------------------------------------------------
	
	/* Creates the form content of the scene
	 * 
	 * @return container to hold the form
	 */
	
	private Node createFormContent() 
	{
		// Container to hold the main form
		VBox vbox = new VBox(20);

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25,25,25,25));
		
		
		Text minPriceLabel = new Text("Minimum Price: ");
		minPriceLabel.setWrappingWidth(150);
		minPriceLabel.setTextAlignment(TextAlignment.RIGHT); 
		grid.add(minPriceLabel, 0, 0);
		
		
		minPriceTextField = new TextField();
		minPriceTextField.setMinSize(100, 20);
		grid.add(minPriceTextField, 1, 0);
		
		
		Text maxPriceLabel = new Text("Maximum Price: ");
		maxPriceLabel.setWrappingWidth(150);
		maxPriceLabel.setTextAlignment(TextAlignment.RIGHT); 
		grid.add(maxPriceLabel, 0, 1);
				
		
		maxPriceTextField = new TextField();
		maxPriceTextField.setMinSize(100, 20);
		grid.add(maxPriceTextField, 1, 1);
		
		
		Text minAreaLabel = new Text("Minimum Area: "); 
		minAreaLabel.setWrappingWidth(150); 
		minAreaLabel.setTextAlignment(TextAlignment.RIGHT); 
		grid.add(minAreaLabel, 0, 2);
				
		
		minAreaTextField = new TextField();
		minAreaTextField.setMinSize(100, 20); 
		grid.add(minAreaTextField, 1, 2);
				
		
		Text maxAreaLabel = new Text("Maximum Area: "); 
		maxAreaLabel.setWrappingWidth(150); 
		maxAreaLabel.setTextAlignment(TextAlignment.RIGHT); 
		grid.add(maxAreaLabel, 0, 3);
				
		
		maxAreaTextField = new TextField(); 
		maxAreaTextField.setMinSize(100, 20);
		grid.add(maxAreaTextField, 1, 3);
				
		
		Text minBedsLabel = new Text("Minimum Beds: "); 
		minBedsLabel.setWrappingWidth(150); 
		minBedsLabel.setTextAlignment(TextAlignment.RIGHT); 
		grid.add(minBedsLabel, 0, 4);
					
		
		minBedsTextField = new TextField(); 
		minBedsTextField.setMinSize(100, 20);
		grid.add(minBedsTextField, 1, 4);
				
		
		Text maxBedsLabel = new Text("Maximum Beds: "); 
		maxBedsLabel.setWrappingWidth(150); 
		maxBedsLabel.setTextAlignment(TextAlignment.RIGHT); 
		grid.add(maxBedsLabel, 0, 5);
				
		
		maxBedsTextField = new TextField(); 
		grid.add(maxBedsTextField, 1, 5);
		
		
		Text chosenHomeLabel = new Text("Chosen Home: "); 
		chosenHomeLabel.setWrappingWidth(150); 
		chosenHomeLabel.setTextAlignment(TextAlignment.RIGHT); 
		grid.add(chosenHomeLabel, 0, 6);
						
		
		chosenHomeTextField = new TextField(); 
		grid.add(chosenHomeTextField, 1, 6);
				
				
		findDreamHouseButton = new Button("Find my dream house!"); 
		findDreamHouseButton.setAlignment(Pos.CENTER_LEFT);
		
		// Once the user clicks 'Find My Dream House' button, disable it and enable the 'Not My Dram House' button
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
		
		
		// Disable this button if the user hasn't clicked anything yet
		notMyDreamButton = new Button("Not my dream house - find me another!"); 
		notMyDreamButton.setDisable(true);
		
		notMyDreamButton.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent e) 
			{
				processAction(e);
			} 
		});
		
		
		resetButton = new Button("Reset"); 
		resetButton.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent e) 
			{
				processReset(e);
			} 
		});
				
		
		// HBox containers to hold the buttons
		HBox buttonContainer = new HBox(10);
		buttonContainer.setAlignment(Pos.CENTER);
		buttonContainer.setPadding(new Insets(5,20,5,20));
		buttonContainer.getChildren().add(findDreamHouseButton); 
		buttonContainer.getChildren().add(notMyDreamButton);
		
		HBox resetButtonContainer = new HBox();
		resetButtonContainer.setAlignment(Pos.CENTER);
		resetButtonContainer.getChildren().add(resetButton);
		
		
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
		 * The program should assume that that value of the field is 0 if its left blank
		 * for the “minimum fields” (price, area, beds). 
		 * 
		 * Assume that the value of a field is Integer.MAX_VALUE if the field is 
		 * one of the “maximum fields”
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
		// Clear already seen houses once the user clicks 'Reset'
		houseList.getAlreadySeenHouses().clear();
		
		notMyDreamButton.setDisable(true);
		findDreamHouseButton.setDisable(false);
		populateFields();
	}

	// ------------------------------------------------------------------
	
	/* Pre-populates the text fields with empty strings
	 */
	
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
