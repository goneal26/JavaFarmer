package gameObjects;

import java.util.Timer;
import java.util.TimerTask;

import mainPackage.GUI;

/**
 * The Farm class represents an item that produces resources over time.
 */
public class Farm implements Item {

	private int count; // the number of farms the player has
	private String name; // the name of the farm
	private Resource resource; // the resource produced by the farm
	private Timer timer = new Timer(); // the timer used to produce the resource
	private GUI gui; // temporary solution for the presentation

	/**
	 * Constructs a new Farm object with the specified name, resource, and GUI.
	 * 
	 * @param name     the name of the farm
	 * @param resource the resource produced by the farm
	 * @param gui      the GUI used to display the resource count
	 */
	public Farm(String name, Resource resource, GUI gui) {
		this.count = 0;
		this.name = name;
		this.resource = resource;
		this.gui = gui;
	}

	/**
	 * Constructs a new Farm object with the specified name, resource, GUI, and count.
	 * 
	 * @param name     the name of the farm
	 * @param resource the resource produced by the farm
	 * @param gui      the GUI used to display the resource count
	 * @param count    the initial number of farms the player has
	 */
	public Farm(String name, Resource resource, GUI gui, int count) {
		if (count > 0) {
			this.count = count;
		}
		this.name = name;
		this.resource = resource;
		this.gui = gui;
	}

	/**
	 * Starts the timer that produces the resource.
	 */
	private void startTimer() {
		this.timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				if (count >= 1) {
					resource.increment(40 * count);
				}
				gui.berryCountLabel.setText("Berries: " + resource.getAmount() + " / " + resource.getMaximum());
			}
		}, 0, 60000); // add 40 berries every minute
	}

	/**
	 * Adds a farm to the player's inventory and starts the production timer if necessary.
	 */
	public void craftItem() {
		if (this.count < 1) {
			this.startTimer();
		}
		this.count++;
	}

	/**
	 * Returns the current number of farms the player has.
	 * 
	 * @return the number of farms the player has
	 */
	public int getCount() {
		return this.count;
	}

	/**
	 * Sets the number of farms the player has.
	 * 
	 * @param n the new number of farms the player has
	 */
	public void setCount(int n) {
		if (n >= 0) {
			this.count = n;
		}
	}

	/**
	 * Returns the name of the farm.
	 * 
	 * @return the name of the farm
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name of the farm.
	 * 
	 * @param s the new name of the farm
	 */
	public void setName(String s) {
		this.name = s;
	}

	/**
	 * Harvests the resource produced by the farm and adds it to the player's inventory.
	 */
	public void harvest() {
		this.resource.increment(this.count);
	}
}
