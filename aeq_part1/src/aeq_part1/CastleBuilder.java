package aeq_part1;

import java.util.Scanner;

public class CastleBuilder {
	private static int totalCastlesBuilt, totalCastlesOnPeaks, totalCastlesInValleys;
	private static int[] landForBuilding;
	private static int landSkipped;
	
	private static int[] createLandmass() {
		
		System.out.print("Enter land to have castles built on as a string of integers separated by one space\n");
		
	    	Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		    
		String[] parts = input.split(" ");
		int[] userInput = new int[parts.length];
		
		for (int i = 0; i < parts.length; i++) {
			userInput[i] = Integer.parseInt(parts[i]);
		}
	    sc.close();
		return userInput;
	}
	
	public static void main(String[] args) {
		
	    		// Here is our land for castle building: hard coded input
	    //int[] theEmptyLand = {1, 6, 6, 6, 1, 2, 3, 1, 1, 1, 1, 1, 5, 2, 4, 7, 3, 6, 3, 3, 6, 8, 8, 9, 4, 0, 4, 1, 6};
	    //landForBuilding = theEmptyLand;
	    
	    		// use this section for console input
	    int[] userInput = createLandmass();

	    landForBuilding = userInput;
	    
	    letsBuild();
	    printResults();
	}
	
	/**
	 * Checks if the land being assessed is either a peak or a valley, in order to 
	 * determine if a castle shall be built.
	 * @param previous
	 * @param current
	 * @param next
	 */
	private static void checkLandViability(int previous, int current, int next) {
        // if the middle land section is lower than one before and after it
		if ( (previous > current) && (next > current) ) {
        // have a valley; build a castle
			totalCastlesInValleys = totalCastlesInValleys + 1;
		} 
        // if the middle land is higher than the one before and after it
		else if ( (previous < current) && (next < current) ) {
			// we have a peak, build a castle
			totalCastlesOnPeaks = totalCastlesOnPeaks + 1;
		}
		else {
			landSkipped = landSkipped + 1;
		}
	}

	/**
	 * Function that will iterate through the empty land, building the castles 
	 * if that land is a peak or a valley.
	 */
	public static void letsBuild() {
		
		int previousLand, currentLand, nextLand;
		int i = 1;

		do {
			previousLand = landForBuilding[i-1];
			currentLand = landForBuilding[i];
			nextLand = landForBuilding[i+1];
      
				// this part will move the iterator to the next land mass if the integers 
					// are equal; we have a larger "peak" or "valley"
			if ( currentLand == nextLand ) {

				do {
					i++;
					currentLand = landForBuilding[i];
					nextLand = landForBuilding[i+1];

				} while ( currentLand == nextLand );

				checkLandViability(previousLand, currentLand, nextLand);
				i++;

			} else {

				checkLandViability(previousLand, currentLand, nextLand);
				i++;
			}
			
		} while (i < ((landForBuilding.length) - 1));
    
		totalCastlesBuilt = totalCastlesOnPeaks + totalCastlesInValleys;
      
	}

	/**
	 * Function that shows the results
	 */
	public static void printResults() {
	    System.out.print("Total landmass for building: " + (landForBuilding.length - 2) + "\n");
	    System.out.print("Total land mass not suitable for building: " + landSkipped + "\n\n");
	
	    System.out.print("Initial castle built at beginning of array: 1\n");
	    System.out.print("Total castles to be built on peaks: " + totalCastlesOnPeaks + "\n");
	    System.out.print("Total castles to be built in valleys: " + totalCastlesInValleys + "\n\n");
	    
	    System.out.print("Total castles AEQ should build: " + (totalCastlesBuilt + 1) + "\n");
	}
}
