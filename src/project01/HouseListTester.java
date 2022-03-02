package project01;

import java.util.Scanner;

/**
 * Tester class for Real Estate Listing project
 * 
 * @author Sebastian Whyte
 * @version February 5, 2022
 *
 */

public class HouseListTester 
{
	public static void main(String[] args)
	{
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
		
	}
}
