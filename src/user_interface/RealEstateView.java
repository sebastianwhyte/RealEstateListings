package user_interface;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
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


/* An extension to Project 1
 * 
 * @author Sebastian Whyte
 * @version 03/25/2022
 *
 */

public class RealEstateView extends View
{
	// Instance variables
	VBox container = new VBox(10);
	TextField minPriceTextField;
	HouseList houseList;
	
	
	// Constructor
	public RealEstateView(HouseList houseList)
	{
		// Pass class name to constructor of parent class
		super("Real Estate Listings View");
		
		this.houseList = houseList;
		
		// Set the padding of the container
		container.setPadding(new Insets(15,5,5,5));
		
		// Create GUI components & add them
		container.getChildren().add(createTitle());
		container.getChildren().add(createFormContent());
	
		populateFields();
	}
	

	// ------------------------------------------------------------------
	
	/* Create the title of the app
	 * @return container that holds the title
	 */
	private Node createTitle() 
	{
		// Hold the title in a HBox
		HBox titleBox = new HBox();
		titleBox.setAlignment(Pos.CENTER);
		
		// Create the title
		Text title = new Text("Real Estate Listings");
		
		title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		title.setWrappingWidth(300);
		title.setTextAlignment(TextAlignment.CENTER);
		title.setFill(Color.DARKGREEN);
		
		// Add the title to the container/titleBox
		titleBox.getChildren().add(title);
		
		return titleBox;
	}


	// ------------------------------------------------------------------

	
	public VBox createFormContent()
	{
		// Create VBox to hold the scene contents
		VBox vbox = new VBox(10);
		
		// Create a grid layout
		GridPane grid = new GridPane();
		
		// Grid properties
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25,25,25,25));
		
		// Create Minimum Price label
		Label minPriceLabel = new Label("Minimum Price: ");
		minPriceLabel.setAlignment(Pos.CENTER);
		grid.add(minPriceLabel, 0, 0);
		
		// Create TextField for minimum price
		minPriceTextField = new TextField();
		minPriceTextField.setMinSize(100, 20);
		grid.add(minPriceTextField, 1, 0);
		
		
		return vbox;
		
	}
	
	
	// Method to populate the fields
	public void populateFields()
	{
		// Set default of TextFields to empty strings
		minPriceTextField.setText("");
	}
	
	
	@Override
	public void updateState(String key, Object value) 
	{
		// TODO Auto-generated method stub
		
	}
}
