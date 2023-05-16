/**
 * @author Seamus Jackson
 * 
 * the class where all of our methods for the GUI are held.
 * these are mostly just here so that we don't have to call a ton of GUI methods in the main class,
 * setting buttons and labels visible/invisible,
 * and the final transition after the first "phase" of the game is over.
 */

package mainPackage;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI {
	private int windowWidth;
	private int windowHeight;
	
	// a bunch of JLabels
	private JFrame frame;
	public JButton forageButton;
	public JButton emptyButton;
	public JButton basketButton;
	public JButton eatButton;
	public JButton makeFarmButton;
	public JButton advanceButton;
	public JLabel berryCountLabel;
	public JLabel stickCountLabel;
	public JLabel landCountLabel;
	public JLabel hungerLevelLabel;
	public JLabel notificationLabel;
	public JLabel farmCountLabel;

	// constructor
	public GUI() {
		try {
			// Set the Look and Feel to Nimbus
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		windowWidth = 350;
		windowHeight = 200;

		// create components
		frame = new JFrame("Berry Farmer");
		forageButton = new JButton("Forage");
		emptyButton = new JButton("I'm empty");
		basketButton = new JButton("Make Basket");
		basketButton.setVisible(false);
		eatButton = new JButton("Eat");
		makeFarmButton = new JButton("New Farm");
		makeFarmButton.setVisible(false);
		berryCountLabel = new JLabel("Berries: 0 / 10");
		stickCountLabel = new JLabel("Sticks: 0 / 10");
		hungerLevelLabel = new JLabel("Hunger: 0");
		notificationLabel = new JLabel("Forage for supplies!");
		farmCountLabel = new JLabel("Current Farms: 0");
		landCountLabel = new JLabel("Available Land: 10");
		advanceButton = new JButton("Advance");
		advanceButton.setVisible(false);

		// create panels
		JPanel labelPanel = new JPanel(new GridLayout(6, 1));
		labelPanel.add(notificationLabel);
		labelPanel.add(hungerLevelLabel);
		labelPanel.add(berryCountLabel);
		labelPanel.add(stickCountLabel);
		labelPanel.add(farmCountLabel);
		labelPanel.add(landCountLabel);

		JPanel buttonPanel = new JPanel(new GridLayout(6, 1));
		buttonPanel.add(emptyButton);
		buttonPanel.add(eatButton);
		buttonPanel.add(forageButton);
		buttonPanel.add(basketButton);
		buttonPanel.add(makeFarmButton);
		buttonPanel.add(advanceButton);

		// add components to frame
		frame.getContentPane().add(labelPanel, BorderLayout.WEST);
		frame.getContentPane().add(buttonPanel, BorderLayout.EAST);

		// configure frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(windowWidth, windowHeight);
		frame.setVisible(true);
		emptyButton.setVisible(false);
	}
	
	// accessors and mutators for window sizing
	public int getWindowWidth() {
		return windowWidth;
	}

	public void setWindowWidth(int n) {
		windowWidth = n;
	}

	public int getWindowHeight() {
		return windowHeight;
	}

	public void setWindowHeight(int n) {
		windowHeight = n;
	}
	
	// updates all of the ingame labels with the right values (ints taken from a player object)
	public void updateLabels(int berryCount, int maxBerries, int landCount, int maxLand, int stickCount, int maxSticks,
			int hungerLevel, int berryFarms) {
		berryCountLabel.setText("Berries: " + berryCount + " / " + maxBerries);
		stickCountLabel.setText("Sticks: " + stickCount + " / " + maxSticks);
		landCountLabel.setText("Available Land: " + landCount + " / " + maxLand);
		hungerLevelLabel.setText("Hunger: " + hungerLevel);
		farmCountLabel.setText("Current Farms: " + berryFarms);
	}
	
	// sets the text that pops up when you forage
	public void setNotification(String notification) {
		notificationLabel.setText(notification);
	}
	
	// visibility setting for the buttons
	public void setBasketButtonVisible(boolean visible) {
		basketButton.setVisible(visible);
	}

	public void setMakeFarmButtonVisible(boolean visible) {
		makeFarmButton.setVisible(visible);
	}

	public void setLandLabelVisible(boolean visible) {
		landCountLabel.setVisible(visible);
	}

	public void setAdvanceButtonVisible(boolean visible) {
		advanceButton.setVisible(visible);
	}
	
	// end of first phase (basically end of game so far)
	public void moveToNextStage() {
		notificationLabel.setText("Resources Exhausted");
		basketButton.setVisible(false);
		makeFarmButton.setVisible(false);
		hungerLevelLabel.setVisible(false);
		farmCountLabel.setVisible(false);
		forageButton.setVisible(false);
		eatButton.setVisible(false);
		stickCountLabel.setVisible(false);
		advanceButton.setVisible(true);
		berryCountLabel.setText("Advance to next stage?");

	}
	
	// adding action listeners
	public void addButtonListener(ActionListener listener) {
		forageButton.addActionListener(listener);
		emptyButton.addActionListener(listener);
		basketButton.addActionListener(listener);
		eatButton.addActionListener(listener);
		makeFarmButton.addActionListener(listener);
	}
}
