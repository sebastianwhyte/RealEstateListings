package project01;

/**
 * It represents the details of a house for sale.
 * 
 * @author Sebastian Whyte
 * @version February 5, 2022
 */


public class House 
{	
	// Instance variables
	private String address;		
	private int price;			
	private int area;			
	private int numBedrooms;
	
	// ----------------------------------------------------------------
	
	/* Constructor 
	 * @param information about the houses
	 */
	
	public House()
	{
		
	}
	
	public House(String address, int price, int area, int numBedrooms)
	{
		this.address = address;
		this.price = price;
		this.area = area;
		this.numBedrooms = numBedrooms;
	}
	
	// ----------------------------------------------------------------
	
	/* Getter methods */
	public String getAddress()
	{
		return address;
	}
	
	
	public int getPrice()
	{
		return price;
	}
	
	
	public int getArea()
	{
		return area;
	}
	
	public int getNumBedrooms()
	{
		return numBedrooms;
	}
	
	// ----------------------------------------------------------------
	
	/* Checks to see if this house meets the requirements specified by r 
	 * @param a Requirement object
	 */
	public boolean satisfies(Requirement r)
	{
		// If house meets all the criteria, return true
		if ((price >= r.getMinimumPrice() && price <= r.getMaximumPrice()) 
				&& (area >= r.getMinimumArea() && area <= r.getMaximumPrice()) 
				&& (numBedrooms >= r.getMinimumNumberBedrooms() && numBedrooms <= r.getMaximumNumberBedrooms()))
		{
			return true;
		}
		
		return false;
	}
	
	// ----------------------------------------------------------------
	
	/* Print to describe the House data 
	 * @return String that describes the house
	 * 
	 */
	public String toString()
	{
		return "Address: " + address + ", Price: " + price + ", Area: " + area + ", Bedrooms: " + numBedrooms;
	}
}
