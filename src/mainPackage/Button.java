package mainPackage;

import gameObjects.Resource;
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
	// tired af gonna keep working on this tomorrow
	/* 
	 * TO-DO:
	 * this is gonna be an abstract class that our resource
	 * and item buttons/labels come from. We can then just 
	 * instantiate these in our GUI class later. It's complicated
	 * af but I think im figuring it out, been sketching out how
	 * its gonna work
	 * 
	 * */
}
