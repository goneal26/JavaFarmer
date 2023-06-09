/**
 * @author Seamus Jackson
 * 
 * This class implements the constant countdown timer that ticks down the player's hunger until it hits 0,
 * as well as making sure the GUI updates with it.
 */

package gameObjects;

import java.util.Timer;
import java.util.TimerTask;

import mainPackage.Player;
import mainPackage.GUI;

public class HungerTimer {
    private Timer timer;
    private Player player;
    private GUI gui;
    
    // constructor
    public HungerTimer(Player p, GUI g) {
        this.timer = new Timer();
        this.player = p;
        this.gui = g;
    }
    
    // inits the timer
    public void start() {
        this.timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
            	if (player.getHunger() > 0) {
                player.decrementHunger(1);
            	}
                gui.hungerLevelLabel.setText("Hunger: " + player.getHunger() + " / " + player.getMaxHunger());
            }
        }, 0, 1000); // decrement hunger every second
    }
}
