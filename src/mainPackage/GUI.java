package mainPackage;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI {
	private int windowWidth;
	private int windowHeight;

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

	public GUI() {
		try {
			// Set the Look and Feel to the system's default
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
		landCountLabel = new JLabel("Availible Land: 10");
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

	public void updateLabels(int berryCount, int maxBerries, int landCount, int maxLand, int stickCount, int maxSticks,
			int hungerLevel, int berryFarms) {
		berryCountLabel.setText("Berries: " + berryCount + " / " + maxBerries);
		stickCountLabel.setText("Sticks: " + stickCount + " / " + maxSticks);
		landCountLabel.setText("Availible Land: " + landCount + " / " + maxLand);
		hungerLevelLabel.setText("Hunger: " + hungerLevel);
		farmCountLabel.setText("Current Farms: " + berryFarms);
	}

	public void setNotification(String notification) {
		notificationLabel.setText(notification);
	}

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

	public void addButtonListener(ActionListener listener) {
		forageButton.addActionListener(listener);
		emptyButton.addActionListener(listener);
		basketButton.addActionListener(listener);
		eatButton.addActionListener(listener);
		makeFarmButton.addActionListener(listener);
	}
}
