package aeq_part2;

import java.util.ArrayList;

public class BattleArena {

	public static void main(String[] args) {
		
		  // Step 1: Create master list of transformers
	    ArrayList<Transformer> transformersRoster = createTransformers();
	    
	      // Step 2: separate the master list into arrays (teams) for Autobots vs Decepticons
	    ArrayList<Transformer> autobotList = new ArrayList<Transformer>();
	    ArrayList<Transformer> decepticonList = new ArrayList<Transformer>();

	    for (int i = 0; i < 9; i++) {
	    		Transformer checkTransformerTeam = transformersRoster.get(i);

	    		if (checkTransformerTeam.getTeam() == "A") {
	    			autobotList.add(checkTransformerTeam);
	    		} else {
	    			decepticonList.add(checkTransformerTeam);
	    		}
	    }
	    
	    // Step 3: sort both arrays (team) based on the attribute of rank, a variable 
	    			// within the Transformer class
	    int dynamicAbListSize = autobotList.size();
	    int dynamicDcListSize = decepticonList.size();
	    
	    ArrayList<Transformer> rankedAutobotsList = sortByRank(dynamicAbListSize, autobotList);
	    ArrayList<Transformer> rankedDecepticonsList = sortByRank(dynamicDcListSize, decepticonList);

	    battle(rankedAutobotsList, rankedDecepticonsList);
	}
	
	/**
	 * Creates Transformer objects and adds to an ArrayList
	 * @return ArrayList<Transformer> roster with both Autobots and Decepticons, unsorted
	 */
	private static ArrayList<Transformer> createTransformers() {
		
	    ArrayList<Transformer> transformersRoster = new ArrayList<Transformer>();

	    		// Create Transformer objects
	    Transformer optimisPrime = new Transformer("Optimis Prime", "A", 10, 10, 8, 10, 10, 10, 8, 10);
	    Transformer omegaSupreme = new Transformer("Omega Supreme", "A", 10, 5, 3, 10, 7, 10, 10, 6);
	    Transformer bumblebee = new Transformer("Bumblebee", "A", 2, 8, 4, 7, 7, 10, 1, 7);
	    Transformer smokescreen = new Transformer("Smokescreen", "A", 4, 9, 7, 6, 6, 8, 7, 9);
	    Transformer silverbolt = new Transformer("Silverbolt", "A", 6, 8, 9, 8, 8, 8, 8, 5);
	    
	    Transformer megatron = new Transformer("Megatron", "D", 10, 10, 4, 8, 10, 9, 10, 9);
	    Transformer starscream = new Transformer("Starscream", "D", 7, 9, 10, 7, 9, 9, 8, 8);
	    Transformer galvatron = new Transformer("Galvatron", "D", 10, 9, 9, 10, 9, 9, 9, 10);
	    Transformer sixshot = new Transformer("Sixshot", "D", 10, 9, 4, 9, 7, 8, 9, 8);
	    
	    Transformer predaking = new Transformer("Predaking", "D", 10, 5, 10, 8, 7, 9, 9, 8);
	    Transformer overkill = new Transformer("Overkill", "D", 8, 5, 2, 8, 5, 6, 6, 5);
	    Transformer blot = new Transformer("Blot", "D", 9, 2, 2, 10, 4, 10, 6, 5); 
	    Transformer frenzy = new Transformer("Frenzy", "D", 3, 6, 3, 6, 5, 10, 9, 6);
	    

	    		// Add objects to ArrayList
	    transformersRoster.add(optimisPrime);
	    transformersRoster.add(omegaSupreme);
	    transformersRoster.add(bumblebee);
	    transformersRoster.add(smokescreen);
	    transformersRoster.add(silverbolt);
	    
	    transformersRoster.add(overkill);
	    //transformersRoster.add(starscream);
	    //transformersRoster.add(galvatron);
	    transformersRoster.add(blot);
	    transformersRoster.add(frenzy);
	    //transformersRoster.add(megatron);
	    //transformersRoster.add(sixshot);
	    transformersRoster.add(predaking);

	    return transformersRoster;
	}

	/**
	 * Sorts the list of Transformers based on their rank
	 * @param listSize: The list size of the autobots or decepticons
	 * @param unsortedTeam: Unsorted ArrayList of autobots or decepticons
	 * @return a sorted ArrayList of autobots or decepticons
	 */
	private static ArrayList<Transformer> sortByRank(int listSize, ArrayList<Transformer> unsortedTeam) {
		int dynamicAbListSize = listSize;
	    ArrayList<Transformer> sortedTeam = new ArrayList<Transformer>();

	    while (!unsortedTeam.isEmpty()) {       
	    
	    		Transformer currentBot = unsortedTeam.get(0);
	    		int currentMaxRank = currentBot.getRank();
	    		int currentIndex = unsortedTeam.indexOf(currentBot);
	      
	    		for (int a = 0; a < dynamicAbListSize; a++) {
	        
		        Transformer tempAb = unsortedTeam.get(a);
		        int tempRank = tempAb.getRank();

		        if (tempRank > currentMaxRank) {
		          currentMaxRank = tempRank;
		          currentIndex = unsortedTeam.indexOf(tempAb);
		        }
	    		}
	      
		      sortedTeam.add(unsortedTeam.get(currentIndex));
		      unsortedTeam.remove(currentIndex);
		      dynamicAbListSize = unsortedTeam.size();
		}

	    return sortedTeam;
	}

	/**
	 * The Battle between Autobots and Decepticons have begun!
	 * @param autobots
	 * @param decepticons
	 */
	private static void battle(ArrayList<Transformer> autobots, ArrayList<Transformer> decepticons) {
		// Step 1: Determine the shorter list, if any; this determines number of battles
		ArrayList<Transformer> autoList = autobots;
		ArrayList<Transformer> deceList = decepticons;
		
		int autoListSize = autobots.size();
		int deceListSize = deceList.size();
		int numBattles = 0;
		
		if ((autoListSize - deceListSize) < 0) {
			// autobots have smaller team
			numBattles = autoListSize;
		} else {
			// decepticons have smaller team
			numBattles = deceListSize;
		}
			
		// Step 2: For loop, create matches based on their indices since they're sorted by rank
		
		Transformer opponentA;
		Transformer opponentD;
		ArrayList<Transformer> survivingMembers = new ArrayList<Transformer>();
		
		for (int b = 0; b < numBattles; b++) {
			opponentA = autobots.get(b);
			opponentD = decepticons.get(b);
			
			if (opponentA.getName() == "Optimis Prime" && opponentD.getName() == "Predaking") {
			
				displayBattleResults(numBattles, "All bots perished.", survivingMembers);
			}
		}
		
		// Step 3: Determine victor via various requirements
				// vs Optimis Prime or PredaKing --> opponent is always destroyed
				// >= 4 for Courage or >=3 for strength
				// >= 3 points for Skill
				// highest overall rating is the winner
				// both destroyed if a tie ensues
		// if OP or Predaking fight >>> everyone dies
		
		// return numBattles
		// return winning team (most battles won/opponents destroyed)
		// return survivors of losing team
	    
	}
	
	private static void displayBattleResults(int numberOfBattles, String winningTeam, ArrayList<Transformer> survivors) {
		System.out.print("There were a total of " + numberOfBattles + " battles." + "\n");
		System.out.print(winningTeam + "\n");
		
		if (survivors.isEmpty()) {
			System.out.print("There were no survivors");
		} else {
			for (int i = 0; i < survivors.size(); i++) {
				System.out.print(survivors.get(i).getName());
			}
		}
	}
}
