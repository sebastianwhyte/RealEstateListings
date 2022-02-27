package project01;

/*
 * This contains the requirements specified by the user to select houses.
 * 
 * @author Sebastian Whyte
 * @version February 5, 2022
 */


public class Requirement 
{
	// Instance variables
	private int minimumPrice;
	private int maximumPrice;
	private int minimumArea;
	private int maximumArea;
	private int minimumNumberOfBedrooms;
	private int maximumNumberOfBedrooms;
	
	// --------------------------------------------------------------
	
	/* Constructor 
	 * @param input from user regarding requirements for their house
	 * 
	 */
	public Requirement(int minimumPrice, int maximumPrice, int minimumArea, int maximumArea, int minimumNumberOfBedrooms, int maximumNumberOfBedrooms)
	{
		this.minimumPrice = minimumPrice;
		this.maximumPrice = maximumPrice;
		this.minimumArea = minimumArea;
		this.maximumArea = maximumArea;
		this.minimumNumberOfBedrooms = minimumNumberOfBedrooms;
		this.maximumNumberOfBedrooms = maximumNumberOfBedrooms;
		
		House house = new House();
		house.satisfies(this);
	}
	
	// ---------------------------------------------------------------
	
	/* Getter methods */
	public int getMinimumPrice()
	{
		return minimumPrice;
	}
	
	
	public int getMaximumPrice()
	{
		return maximumPrice;
	}
	
	
	public int getMinimumArea()
	{
		return minimumArea;
	}
	
	
	public int getMaximumArea()
	{
		return maximumArea;
	}
	
	
	public int getMinimumNumberBedrooms()
	{
		return minimumNumberOfBedrooms;
	}
	
	
	public int getMaximumNumberBedrooms()
	{
		return maximumNumberOfBedrooms;
	}
	
}
