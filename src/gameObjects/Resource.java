/**
 * @author Tre O'Neal
 * 
 * This is the class that sets up the "resource" object. This way we have some set methods for
 * interacting with resources in the game, as well as the ability to easily come up with new ones
 * and implement them in the future if we want to.
 */

package gameObjects;

public class Resource {
	/**
	 * The amount of the resource.
	 */
	private int amount;
	
	/**
	 * The maximum amount of the resource.
	 */
	private int maximum;
	
	/**
	 * The name of the resource.
	 */
	private String name;

	/**
	 * Constructor for the resource.
	 * 
	 * @param n the initial amount of the resource
	 * @param max the maximum amount of the resource
	 * @param s the name of the resource
	 */
	public Resource(int n, int max, String s) {
		this.amount = n;
		this.maximum = max;
		this.name = s;
	}

	/**
	 * Gets the current amount of the resource.
	 * 
	 * @return the current amount of the resource
	 */
	public int getAmount() {
		return this.amount;
	}

	/**
	 * Sets the current amount of the resource.
	 * 
	 * @param n the new amount of the resource
	 */
	public void setAmount(int n) {
		if (n <= maximum && n > 0) {
			this.amount = n;
		}
	}

	/**
	 * Gets the maximum amount of the resource.
	 * 
	 * @return the maximum amount of the resource
	 */
	public int getMaximum() {
		return this.maximum;
	}

	/**
	 * Sets the maximum amount of the resource.
	 * 
	 * @param n the new maximum amount of the resource
	 */
	public void setMaximum(int n) {
		if (n > 0) {
			this.maximum = n;
		}
	}

	/**
	 * Gets the name of the resource.
	 * 
	 * @return the name of the resource
	 */
	public String getName() {
		return name;
	}

	/**
	 * Increments the amount of the resource by the specified amount.
	 * 
	 * @param n the amount to increment the resource by
	 */
	public void increment(int n) {
		if (n > 0) {
			this.amount += n;
			if (this.amount > this.maximum) {
				this.amount = this.maximum;
			}
		}
	}

	/**
	 * Decrements the amount of the resource by the specified amount.
	 * 
	 * @param n the amount to decrement the resource by
	 */
	public void decrement(int n) {
		if (n > 0) {
			this.amount -= n;
			if (this.amount < 0) {
				this.amount = 0;
			}
		}
	}

	/**
	 * Increases the maximum amount of the resource by the specified amount.
	 * 
	 * @param n the amount to increase the maximum amount of the resource by
	 */
	public void increaseMaximum(int n) {
		if (n > 0) {
			this.maximum += n;
		}
	}
}
