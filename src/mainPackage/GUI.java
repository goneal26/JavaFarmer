package mainPackage;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI {
	private int windowWidth;
	private int windowHeight;

	private JFrame frame;
	private JButton forageButton;
	private JButton emptyButton;
	private JButton basketButton;
	private JButton eatButton;
	private JButton makeFarmButton;
	private JLabel berryCountLabel;
	private JLabel stickCountLabel;
	private JLabel hungerLevelLabel;
	private JLabel notificationLabel;
	private JLabel farmCountLabel;

	public GUI() {
		windowWidth = 800;
		windowHeight = 600;

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

		// create panels
		JPanel labelPanel = new JPanel(new GridLayout(5, 1));
		labelPanel.add(notificationLabel);
		labelPanel.add(hungerLevelLabel);
		labelPanel.add(berryCountLabel);
		labelPanel.add(stickCountLabel);
		labelPanel.add(farmCountLabel);

		JPanel buttonPanel = new JPanel(new GridLayout(5, 1));
		buttonPanel.add(emptyButton);
		buttonPanel.add(eatButton);
		buttonPanel.add(forageButton);
		buttonPanel.add(basketButton);
		buttonPanel.add(makeFarmButton);

		// add components to frame
		frame.getContentPane().add(labelPanel, BorderLayout.WEST);
		frame.getContentPane().add(buttonPanel, BorderLayout.EAST);

		// configure frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}

	public void startGUI() {
		windowWidth = 800;
		windowHeight = 600;

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

		// create panels
		JPanel labelPanel = new JPanel(new GridLayout(5, 1));
		labelPanel.add(notificationLabel);
		labelPanel.add(hungerLevelLabel);
		labelPanel.add(berryCountLabel);
		labelPanel.add(stickCountLabel);
		labelPanel.add(farmCountLabel);

		JPanel buttonPanel = new JPanel(new GridLayout(5, 1));
		buttonPanel.add(emptyButton);
		buttonPanel.add(eatButton);
		buttonPanel.add(forageButton);
		buttonPanel.add(basketButton);
		buttonPanel.add(makeFarmButton);

		// add components to frame
		frame.getContentPane().add(labelPanel, BorderLayout.WEST);
		frame.getContentPane().add(buttonPanel, BorderLayout.EAST);

		// configure frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
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

	public void updateLabels(int berryCount, int maxBerries, int stickCount, int maxSticks, int hungerLevel,
			int berryFarms) {
		berryCountLabel.setText("Berries: " + berryCount + " / " + maxBerries);
		stickCountLabel.setText("Sticks: " + stickCount + " / " + maxSticks);
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

	public void addButtonListener(ActionListener listener) {
		forageButton.addActionListener(listener);
		emptyButton.addActionListener(listener);
		basketButton.addActionListener(listener);
		eatButton.addActionListener(listener);
		makeFarmButton.addActionListener(listener);
	}
}
