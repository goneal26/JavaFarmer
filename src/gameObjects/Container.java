package gameObjects;

/**
 * The Container class represents an item that can hold other items.
 */
public class Container implements Item {

	private int count; // the number of items in the container
	private String name; // the name of the container
	@SuppressWarnings("unused")
	private Resource material; // the resource that is used to craft the item

	/**
	 * Constructs a new Container object with the specified name and resource.
	 * 
	 * @param name     the name of the container
	 * @param material the resource that is used to craft the container
	 */
	public Container(String name, Resource material) {
		this.count = 1;
		this.name = name;
		this.material = material;
	}

	/**
	 * Constructs a new Container object with the specified name, resource, and
	 * count.
	 * 
	 * @param name     the name of the container
	 * @param material the resource that is used to craft the container
	 * @param count    the initial number of items in the container
	 */
	public Container(String name, Resource material, int count) {
		if (count > 0) {
			this.count = count;
		}
		this.name = name;
		this.material = material;
	}

	/**
	 * Adds an item to the container.
	 */
	public void craftItem() {
		this.count++;
	}

	/**
	 * Returns the current number of items in the container.
	 * 
	 * @return the number of items in the container
	 */
	public int getCount() {
		return this.count;
	}

	/**
	 * Sets the number of items in the container.
	 * 
	 * @param n the new number of items in the container
	 */
	public void setCount(int n) {
		if (n >= 0) {
			this.count = n;
		}
	}

	/**
	 * Returns the name of the container.
	 * 
	 * @return the name of the container
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name of the container.
	 * 
	 * @param s the new name of the container
	 */
	public void setName(String s) {
		this.name = s;
	}
}
