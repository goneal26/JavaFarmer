package mainPackage;

import gameObjects.Resource;

public class Player {
    private int hunger;
    private int maxHunger;
    private Resource sticks;
    private Resource berries;

    public Player() {
        hunger = 100;
        maxHunger = 100;
        sticks = new Resource(0, 10, "sticks");
        berries = new Resource(0, 10, "berries");
    }
    
    public void initPlayer() {
        hunger = 100;
        maxHunger = 100;
        sticks = new Resource(0, 10, "sticks");
        berries = new Resource(0, 10, "berries");
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int n) {
        hunger = n;
        if (hunger > maxHunger) {
            hunger = maxHunger;
        }
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
