package mainPackage;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;

import gameObjects.*;

public class Game {

    public static void main(String[] args) {
    	//initialize objects
    	GUI g = new GUI();
    	Resource berries = new Resource(0, 10, "berries");
    	Resource sticks = new Resource(0, 10, "sticks");
    	Player p = new Player(100, 100, berries, sticks);
    	Farm f = new Farm("Berry Farm", berries);
    	HungerTimer h = new HungerTimer(p, g);
    	h.start();

    	//GUI Controllers (button conditions)   
    	g.notificationLabel.setFont(new Font("Arial", Font.PLAIN, 20));
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
    	g.forageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (p.berries.getAmount() < p.berries.getMaximum()) {
					// code to be executed when button is clicked
					p.berries.increment(1); // increment the count
					g.berryCountLabel.setText("Berries: " + p.berries.getAmount() + " / " + p.berries.getMaximum()); // update the label text
				}
				int randomNum = (int) (Math.random() * 3);
				if (randomNum > 0) {
					int stickNum = (int) (Math.random() * 4);
					if (p.sticks.getAmount() < p.sticks.getMaximum()) {
						p.sticks.increment(stickNum); // increment stick count by random number
						g.stickCountLabel.setText("Sticks: " + p.sticks.getAmount() + " / " + p.sticks.getMaximum()); // update stick label text
						g.notificationLabel.setText("You found " + stickNum + " stick(s)");
					}
					if ((p.sticks.getAmount() + stickNum) > p.sticks.getMaximum()) {
						p.sticks.setAmount(p.sticks.getMaximum());
						g.stickCountLabel.setText("Sticks: " + p.sticks.getAmount() + " / " + p.sticks.getAmount()); // update stick label text
					}
				}
				if (p.sticks.getAmount() >= 10) {
					g.basketButton.setVisible(true);
				}
				if (p.sticks.getAmount() == p.sticks.getMaximum()) {
					g.notificationLabel.setText("No room!");
				}
				if (p.berries.getAmount() >= 100) {
					g.makeFarmButton.setVisible(true);
				}
			}
		});
    	
		g.basketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code to be executed when reset button is clicked
				p.sticks.decrement(10); // reset the stick count
				p.sticks.setMaximum(p.sticks.getMaximum() + 5); // increase the stick count limit
				g.stickCountLabel.setText("Sticks: " + p.sticks.getAmount() + " / " + p.sticks.getMaximum()); // update the stick label text
				p.berries.setMaximum(p.berries.getMaximum() + 10); // Increase berry count limit
				g.berryCountLabel.setText("Berries: " + p.berries.getAmount() + " / " + p.berries.getMaximum()); // update the berry label text
				g.notificationLabel.setText("More storage!");
				if (p.sticks.getAmount() < 10) {
					g.basketButton.setVisible(false); // Hide the reset button
				}
			}
		});
		
		g.eatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code to be executed when reset button is clicked
				if (p.berries.getAmount() > 5) {
					p.incrementHunger(10); 
					if (p.getHunger() > 100) {
						p.setHunger(100);
					}
					p.berries.decrement(5); 
					g.berryCountLabel.setText("Berries: " + p.berries.getAmount() + " / " + p.berries.getMaximum()); // update the berry label text
					g.notificationLabel.setText("Delicious!");
					g.hungerLevelLabel.setText(p.getHunger() + " / " + p.getMaxHunger());
				}
			}
		});
		
		g.makeFarmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (p.berries.getAmount() >= 100) {
					p.berries.decrement(100);
					g.berryCountLabel.setText("Berries: " + p.berries.getAmount() + " / " + p.berries.getMaximum()); // update the berry label text
					f.craftItem();
					g.farmCountLabel.setText("Current Farms: " + f.getCount());
					if (p.berries.getAmount() < 100)  {
						g.makeFarmButton.setVisible(false);
					}
				}
				
			}
		});

	
    	
    	
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
