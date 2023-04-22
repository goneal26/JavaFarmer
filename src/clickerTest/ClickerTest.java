package clickerTest;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickerTest {
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
}
