/**
 * @author Seamus Jackson
 * @author Tre O'Neal
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

/**
 * The GUI class where all of our methods for the graphical user interface are held.
 * These methods handle setting buttons and labels visible/invisible,
 * and the final transition after the first "phase" of the game is over.
 */
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
	
	/**
	 * Get the window width.
	 * @return The width of the window.
	 */
	public int getWindowWidth() {
		return windowWidth;
	}

	/**
	 * Set the window width.
	 * @param n The width to set.
	 */
	public void setWindowWidth(int n) {
		windowWidth = n;
	}

	/**
	 * Get the window height.
	 * @return The height of the window.
	 */
	public int getWindowHeight() {
		return windowHeight;
	}

	/**
	 * Set the window height.
	 * @param n The height to set
	 */
	public void setWindowHeight(int n) {
		windowHeight = n;
	}
	
	/**
	 * Update all of the in-game labels with the corresponding values.
	 * @param berryCount The current berry count.
	 * @param maxBerries The maximum berry count.
	 * @param landCount The current land count.
	 * @param maxLand The maximum land count.
	 * @param stickCount The current stick count.
	 * @param maxSticks The maximum stick count.
	 * @param hungerLevel The current hunger level.
	 * @param berryFarms The number of current berry farms.
	 */
	public void updateLabels(int berryCount, int maxBerries, int landCount, int maxLand, int stickCount, int maxSticks,
			int hungerLevel, int berryFarms) {
		berryCountLabel.setText("Berries: " + berryCount + " / " + maxBerries);
		stickCountLabel.setText("Sticks: " + stickCount + " / " + maxSticks);
		landCountLabel.setText("Available Land: " + landCount + " / " + maxLand);
		hungerLevelLabel.setText("Hunger: " + hungerLevel);
		farmCountLabel.setText("Current Farms: " + berryFarms);
	}
	
	/**
	 * Set the notification text that pops up when you forage.
	 * @param notification The notification text to display.
	 */
	public void setNotification(String notification) {
		notificationLabel.setText(notification);
	}
	
	/**
	 * Set the visibility of the basket button.
	 * @param visible true to make the button visible, false otherwise.
	 */
	public void setBasketButtonVisible(boolean visible) {
		basketButton.setVisible(visible);
	}

	/**
	 * Set the visibility of the make farm button.
	 * @param visible true to make the button visible, false otherwise.
	 */
	public void setMakeFarmButtonVisible(boolean visible) {
		makeFarmButton.setVisible(visible);
	}

	/**
	 * Set the visibility of the land label.
	 * @param visible true to make the label visible, false otherwise.
	 */
	public void setLandLabelVisible(boolean visible) {
		landCountLabel.setVisible(visible);
	}

	/**
	 * Set the visibility of the advance button.
	 * @param visible true to make the button visible, false otherwise.
	 */
	public void setAdvanceButtonVisible(boolean visible) {
		advanceButton.setVisible(visible);
	}
	
	// end of first phase (basically end of game so far)
	
	/**
	 * Move to the next stage of the game, typically after the first phase is over.
	 */
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
	
	/**
	 * Add an ActionListener to the buttons.
	 * @param listener The ActionListener to add.
	 */
	public void addButtonListener(ActionListener listener) {
		forageButton.addActionListener(listener);
		emptyButton.addActionListener(listener);
		basketButton.addActionListener(listener);
		eatButton.addActionListener(listener);
		makeFarmButton.addActionListener(listener);
	}
}
