package mainPackage;

import gameObjects.Resource;

public class Player {
    private int hunger = 100;
    private int maxHunger = 100;
    public Resource sticks = new Resource(0, 10, "sticks");
    public Resource berries = new Resource(0, 10, "berries");
    
    public Player(int h, int mh, Resource s, Resource b) {
    	if (h > 0 && mh > 0 && mh >= h) {
    		this.hunger = h;
        	this.maxHunger = mh;
    	}
    	this.sticks = s;
    	this.berries = b;
    }

    public int getHunger() {
        return this.hunger;
    }

    public void setHunger(int n) {
        if (n <= this.maxHunger && n > 0) {
            this.hunger = n;
        }
    }
    
    public int getMaxHunger() {
    	return this.maxHunger;
    }

    public void incrementHunger(int n) {
        hunger += n;
        if (hunger > maxHunger) {
            hunger = maxHunger;
        }
    }

    public void decrementHunger(int n) {
        hunger -= n;
        if (hunger < 0) {
            hunger = 0;
        }
    }

    public void reset() {
        //TO-DO
    	hunger = maxHunger;
    	
    }
    
}
