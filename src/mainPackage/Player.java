package mainPackage;

import gameObjects.Resource;

/**
 * Represents a player in a game.
 */
public class Player {
	
	/**
	 * The current hunger level of the player.
	 */
	private int hunger = 100;

	/**
	 * The maximum hunger level of the player.
	 */
	private int maxHunger = 100;

	/**
	 * The sticks resource owned by the player.
	 */
	public Resource sticks = new Resource(0, 10, "sticks");

	/**
	 * The berries resource owned by the player.
	 */
	public Resource berries = new Resource(0, 10, "berries");

	/**
	 * Constructs a player object with a specified hunger level, maximum hunger level, sticks resource, and berries resource.
	 * 
	 * @param h the hunger level of the player
	 * @param mh the maximum hunger level of the player
	 * @param s the sticks resource owned by the player
	 * @param b the berries resource owned by the player
	 */
	public Player(int h, int mh, Resource s, Resource b) {
		if (h > 0 && mh > 0 && mh >= h) {
			this.hunger = h;
	    	this.maxHunger = mh;
		}
		this.sticks = s;
		this.berries = b;
	}

	/**
	 * Gets the current hunger level of the player.
	 * 
	 * @return the current hunger level of the player
	 */
	public int getHunger() {
	    return this.hunger;
	}

	/**
	 * Sets the hunger level of the player to a specified value.
	 * The new value must be less than or equal to the maximum hunger level and greater than 0.
	 * 
	 * @param n the new hunger level of the player
	 */
	public void setHunger(int n) {
	    if (n <= this.maxHunger && n > 0) {
	        this.hunger = n;
	    }
	}

	/**
	 * Gets the maximum hunger level of the player.
	 * 
	 * @return the maximum hunger level of the player
	 */
	public int getMaxHunger() {
		return this.maxHunger;
	}

	/**
	 * Increases the hunger level of the player by a specified amount.
	 * The new hunger level must not exceed the maximum hunger level.
	 * 
	 * @param n the amount to increase the hunger level by
	 */
	public void incrementHunger(int n) {
	    this.hunger += n;
	    if (this.hunger > this.maxHunger) {
	        this.hunger = this.maxHunger;
	    }
	}

	/**
	 * Decreases the hunger level of the player by a specified amount.
	 * The new hunger level must not be less than 0.
	 * 
	 * @param n the amount to decrease the hunger level by
	 */
	public void decrementHunger(int n) {
	    this.hunger -= n;
	    if (this.hunger < 0) {
	        this.hunger = 0;
	    }
	}

	/**
	 * Resets the hunger level of the player to the maximum hunger level.
	 */
	public void reset() {
		hunger = maxHunger;
	}
}

