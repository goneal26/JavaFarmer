package mainPackage;

import gameObjects.*;

public class Game {
    private Player player;
    private GUI gui;

    public Game(Player p) {
        player = p;
        
    }

    public static void main(String[] args) {
    	GUI g = new GUI();
    	Player p = new Player();
    	Resource berries = new Resource(10, 10, "berries");
    	Resource sticks = new Resource(10, 10, "sticks");
    	g.startGUI();
    	p.initPlayer();
    	g.updateLabels(berries.getAmount(), berries.getMaximum(), sticks.getAmount(), sticks.getMaximum(), p.getHunger(), 0);
    	
    }

    public void saveGame(Player p) {
        // Implementation to be added later
    }

    public void loadGame() {
        // Implementation to be added later
    }
}
