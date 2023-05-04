package GameObjects;

public interface Item {
	public void craftItem();
	// maybe need to change this in order to take like, the inventory as an argument in order to check if you have the right resources
	
	public int getCount();
	
	public void setCount(int n);
	
	public String getName();
	
	public void setName(String s);
}
