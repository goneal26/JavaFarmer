/**
 * @author Seamus Jackson
 * @author Tre O'Neal
 * 
 * This is the interface that ingame "items" will implement, such as farms, containers (unused), and anything we
 * may add in the future
 */

package gameObjects;

public interface Item {

	void craftItem();

	int getCount();

	void setCount(int n);

	String getName();

	void setName(String s);
}
