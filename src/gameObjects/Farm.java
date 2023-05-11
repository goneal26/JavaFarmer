package gameObjects;

import java.util.Timer;
import java.util.TimerTask;
import mainPackage.GUI;

public class Farm implements Item {
    private int count;
    private String name;
    private Resource resource;
    private Timer timer = new Timer();
    private GUI gui; // temporary solution for the presentation

    public Farm(String type, Resource res, GUI g) {
        this.count = 0;
        this.name = type;
        this.resource = res;
        this.gui = g;
    }

    public Farm(String type, Resource res, GUI g, int amt) {
    	if (amt > 0) {
    		this.count = amt;
    	}
        this.name = type;
        this.resource = res;
        this.gui = g;
    }

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
    
    public void craftItem() {
    	if (this.count < 1) {
    		this.startTimer();
    	}
    	this.count ++;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int n) {
    	if (n >= 0) {
    		this.count = n;
    	}
    }

    public String getName() {
        return this.name;
    }

    public void setName(String s) {
        this.name = s;
    }

    public void harvest() {
        this.resource.increment(this.count);
    }
}
