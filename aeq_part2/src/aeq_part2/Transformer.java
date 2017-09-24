package aeq_part2;

public class Transformer {
	
	private String name;
	private String team;
	private int strength, intelligence, speed, endurance, rank, courage, firepower, skill;
	private boolean destroyed;

    // Constructor
  	public Transformer(String name, String team, int str, int intelligence, int speed, int endurance, 
  			int rank, int courage, int firepower, int skill) {
	
	    this.name = name;
	    this.team = team;
	    this.strength = str;
	    this.intelligence = intelligence;
	    this.speed = speed;
	    this.endurance = endurance;
	    this.rank = rank;
	    this.courage = courage;
	    this.firepower = firepower;
	    this.skill = skill;
	    this.destroyed = false;
  	}

  	public int returnTransformerRating() {
  		return this.strength + this.intelligence + this.speed + this.endurance + this.firepower;
  	}

  	public String getTeam() {
  		return this.team;
  	}

  	public String getName() {
  		return this.name;
  	}

  	public int getCourage() {
	  	return this.courage;
  	}

  	public int getStrength() {
	  	return this.strength;
  	}

  	public int getSkill() {
  		return this.skill;
  	}

  	public int getRank() {
  		return this.rank;
  	}

  	public boolean isAlive() {
  		return this.destroyed;
  	}

	public void isNowDestroyed() {
		this.destroyed = true;
	}
}