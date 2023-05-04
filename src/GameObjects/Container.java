package GameObjects;

public class Container implements Item {
	private int count = 1;
	private String name;
	private Resource resource;
	
	// constructors
	public Container(String type, Resource r) {
		if (type.isEmpty() || type == null) {
			System.out.println("Error: container name cannot be empty or null");
		} else {
			this.name = type;
		}
		
		this.resource = r;
	}
	
	public Container(String type, Resource r, int amt) {
		if (type.isEmpty() || type == null) {
			System.out.println("Error: container name cannot be empty or null");
		} else {
			this.name = type;
		}
		
		this.resource = r;
		
		if (amt > 0) {
			this.count = amt;
		} else {
			System.out.println("Error: Must have positive value for Container.amt in constructor");
		}
	}

	@Override
	public void craftItem() {
		// TODO Check crafting recipe here?
		this.resource.decrement(3); // ignore this this is just a placeholder, it'll get deleted later
	}

	// accessors/mutators
	@Override
	public int getCount() {
		return this.count;
	}

	@Override
	public void setCount(int n) {
		if (n > 0) {
			this.count = n;
		} else {
			System.out.println("Error: count value must be positive");
		}
		
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String s) {
		if (s.isEmpty() || s == null) {
			System.out.println("Error: container name cannot be empty or null");
		} else {
			this.name = s;
		}
	}
	
	
}
