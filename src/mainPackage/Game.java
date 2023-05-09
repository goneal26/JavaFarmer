package mainPackage;

import gameObjects.*;

public class Game {

    public static void main(String[] args) {
    	//initialize objects
    	GUI g = new GUI();
    	Resource berries = new Resource(10, 10, "berries");
    	Resource sticks = new Resource(10, 10, "sticks");
    	Player p = new Player(100, 100, berries, sticks);
    	Farm f = new Farm("Berry Farm", berries);

    	//GUI Controllers (button conditions)
    	g.updateLabels(berries.getAmount(), berries.getMaximum(), sticks.getAmount(), sticks.getMaximum(), p.getHunger(), f.getCount());
    	if (berries.getAmount() >= 100) {
    		g.setMakeFarmButtonVisible(true);
    	} else {
    		g.setMakeFarmButtonVisible(false);
    	}
    	if (sticks.getAmount() >= 10) {
    		g.setBasketButtonVisible(true);
    	} else {
    		g.setBasketButtonVisible(false);
    	}
    	
    	//Game Loop
    	
    	
    }

    public void saveGame(Player p) {
        String[] data = {
        		"hunger: " + p.getHunger(),
        		"maxHunger: " + p.getMaxHunger()
        }; // TO-DO
        
        
    }

    public void loadGame() {
        // Implementation to be added later
    }
}
