package mainPackage;

import gameObjects.*;

public class Game {
    private Player player;
    private GUI gui;

    public Game(Player p) {
        player = p;
        
    }

    public static void main(String[] args) {
    	//initialize objects
    	GUI g = new GUI();
    	Player p = new Player();
    	Resource berries = new Resource(10, 10, "berries");
    	Resource sticks = new Resource(10, 10, "sticks");
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
        // Implementation to be added later
    }

    public void loadGame() {
        // Implementation to be added later
    }
}
