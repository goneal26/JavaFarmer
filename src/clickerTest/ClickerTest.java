package clickerTest;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickerTest {
<<<<<<< Updated upstream
   private int count = 0; // variable to store the count
   
   public ClickerTest() {
      JFrame frame = new JFrame("Button Example");
      JButton button = new JButton("Pick Berry");
      JLabel label = new JLabel("Berries: " + count); // label to display count
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // code to be executed when button is clicked
            count++; // increment the count
            label.setText("Berries: " + count); // update the label text
         }
      });
      frame.add(button, BorderLayout.PAGE_START); // add button to top of frame
      frame.add(label, BorderLayout.PAGE_END); // add label to bottom of frame
      frame.pack();
      frame.setVisible(true);
   }
   
   public static void main(String[] args) {
      ClickerTest example = new ClickerTest();
   }
=======
	// Initialize values
	private int berryCount = 0; // variable to store the count
	private int stickCount = 0;
	private int maxBerries = 10; // Initial limit
	private int maxSticks = 10;
	private int hungerLevel = 100; // initial hunger level

	public ClickerTest() {
		// make buttons and labels
		JFrame frame = new JFrame("Button Example");
		JButton button = new JButton("Forage");
		JLabel label = new JLabel("Berries: " + berryCount + " / " + maxBerries); // label to display count
		JLabel stickLabel = new JLabel("Sticks: " + stickCount + " / " + maxSticks); // stick count label
		JLabel hungerLabel = new JLabel("Hunger: " + hungerLevel); // hunger level label
		JLabel notiLabel = new JLabel("Forage for berries and sticks");

		// button for increasing berry storage
		JButton basketButton = new JButton("Make Basket");
		basketButton.setVisible(false);

		// button for eating
		JButton eatButton = new JButton("Eat");

		// Layout for the sticks and berries
		JPanel labelPanel = new JPanel(new GridLayout(4, 1));
		labelPanel.add(notiLabel);
		labelPanel.add(label);
		labelPanel.add(stickLabel);
		labelPanel.add(hungerLabel);

		// layout for buttons
		JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
		buttonPanel.add(button);
		buttonPanel.add(eatButton);
		buttonPanel.add(basketButton);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (berryCount < maxBerries) {
					// code to be executed when button is clicked
					berryCount++; // increment the count
					label.setText("Berries: " + berryCount + " / " + maxBerries); // update the label text
				}
				int randomNum = (int) (Math.random() * 3);
				if (randomNum == 1) {
					int stickNumber = (int) (Math.random() * 4) + 1;
					if (stickCount < maxSticks) {
						stickCount += stickNumber; // increment stick count by random number
						stickLabel.setText("Sticks: " + stickCount + " / " + maxSticks); // update stick label text
						notiLabel.setText("Found " + stickNumber + " sticks");
					}
				}
				if (randomNum < 1) {
					notiLabel.setText("Nothing. Look again!");
				}
				if (stickCount >= 10) {
					basketButton.setVisible(true);
				}
			}
		});

		basketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code to be executed when reset button is clicked
				stickCount -= 10; // reset the stick count
				maxSticks += 5; // increase the stick count limit
				stickLabel.setText("Sticks: " + stickCount + " / " + maxSticks); // update the stick label text
				maxBerries += 10; // Increase berry count limit
				label.setText("Berries: " + berryCount + " / " + maxBerries); // update the berry label text
				if (stickCount < 10) {
					basketButton.setVisible(false); // Hide the reset button
				}
			}
		});

		eatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code to be executed when reset button is clicked
				if (berryCount > 5) {
					hungerLevel += 10; // reset the stick count
					if (hungerLevel > 100) {
						hungerLevel = 100;
					}
					berryCount -= 5; // Increase berry count limit
					label.setText("Berries: " + berryCount + " / " + maxBerries); // update the berry label text
				}
			}
		});

		// setup the window
		frame.add(buttonPanel, BorderLayout.EAST); // add button to top of frame
		frame.add(labelPanel, BorderLayout.CENTER); // add label to bottom of frame
		frame.pack();
		frame.setVisible(true);

		// decrease hunger level every second
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000); // wait 1 second
						if (hungerLevel > 0) {
							hungerLevel--; // decrease hunger level
							hungerLabel.setText("Hunger: " + hungerLevel); // update hunger label text
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	// Main method
	public static void main(String[] args) {
		ClickerTest example = new ClickerTest();
	}
>>>>>>> Stashed changes
}
