package gameObjects;

import java.util.Timer;
import java.util.TimerTask;

import mainPackage.Player;
import mainPackage.GUI;

public class HungerTimer {
    private Timer timer;
    private Player player;
    private GUI gui;

    public HungerTimer(Player p, GUI g) {
        this.timer = new Timer();
        this.player = p;
        this.gui = g;
    }

    public void start() {
        this.timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
            	if (player.getHunger() > 0) {
                player.decrementHunger(1);
            	}
                gui.hungerLevelLabel.setText(player.getHunger() + " / " + player.getMaxHunger());
            }
        }, 0, 1000); // decrement hunger every second
    }
}
