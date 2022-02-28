package project01;

import java.io.File;
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
		// Create Scanner object
		//Scanner sc = new Scanner(System.in);
		
		
		// Create HouseList object & pass file into it
		HouseList availableHouses = new HouseList("houses.txt");
		
		// -------------------------------------------------------
		
		// Read in seven different Requirement objects with varying upper and lower limits 
		// for price, area and number of bedrooms.
		
		// Create 7 Requirement objects
		Requirement r1 = new Requirement(1000000, 7000000, 100, 5000, 0, 10);
		Requirement r2 = new Requirement(1000, 100000, 500, 1200, 0, 3);
		Requirement r3 = new Requirement(100000, 200000, 1000, 2000, 2, 3);
		Requirement r4 = new Requirement(200000, 300000, 1500, 4000, 3, 6);
		Requirement r5 = new Requirement(100000, 5000000, 2500, 5000, 3, 6);
		Requirement r6 = new Requirement(150000, 200000, 1500, 4000, 3, 6);
		Requirement r7 = new Requirement(100000, 500000, 2500, 5000, 4, 6);
		
		availableHouses.printHouses(r1);
		availableHouses.printHouses(r2);
	}
}
