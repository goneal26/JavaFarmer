/**
 * @author Tre O'Neal
 * 
 * See UPDATE section at bottom of class
 */

package mainPackage;

import gameObjects.Resource; // not implemented yet
import javax.swing.JLabel;
import javax.swing.JButton;

public abstract class Button {
	private JLabel label;
	private JButton button;
	private boolean isVisible;
	
	protected abstract void init();
	
	public void setVisibility(boolean b) {
		this.isVisible = b;
		label.setVisible(this.isVisible);
		button.setVisible(this.isVisible);
	}
	
	public boolean getVisiblity() {
		return this.isVisible;
	}
	// 
	/* 
	 * TO-DO:
	 * this is gonna be an abstract class that our resource
	 * and item buttons/labels come from. We can then just 
	 * instantiate these in our GUI class later. It's complicated
	 * af but I think im figuring it out, been sketching out how
	 * its gonna work
	 * 
	 * 
	 * UPDATE:
	 * Didn't end up completing this class due to time constraints, so it doesn't really do anything in 
	 * the game rn and it's left out of the UML. Eventually it would've combined the label and button into
	 * a single "element" (working title) that we could easily access or modify from the GUI class. 
	 * Would've made the GUI stuff way more modular too.
	 * */
}
