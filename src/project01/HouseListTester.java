package project01;

import java.io.File;
import java.io.IOException;
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
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner (System.in);
		
		// Create HouseList object & pass file into it
		HouseList availableHouses = new HouseList("houses.txt");
		
		// -------------------------------------------------------
	
		for (int i = 0; i <= 6; i++)
		{
			System.out.println("Enter your requirements: ");
			
			int minumumPrice = sc.nextInt();
			int maxiumumPrice = sc.nextInt();
			int minumumArea = sc.nextInt();
			int maxiumumArea = sc.nextInt();
			int minumumNumberOfBedrooms = sc.nextInt();
			int maxiumumNumberOfBedrooms = sc.nextInt();
			
			Requirement r = new Requirement(minumumPrice, maxiumumPrice, minumumArea, maxiumumArea, minumumNumberOfBedrooms, maxiumumNumberOfBedrooms);
			
			System.out.println("\nResults: ");
			availableHouses.printHouses(r);
			System.out.println();
		}
		
	}
}
