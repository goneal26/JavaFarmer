package clickerTest;

public abstract class Resource {
	private int amount;
	private int maximum;
	private String name; // mostly exists for setting the labels
	
	// constructor
	public Resource(int n, int max, String s) {
		if (n >= 0 && max > 0) {
			this.amount = n;
			this.maximum = max;
		} else {
			System.out.println("Error: cannot init resource amt to negative value or max to 0/negative");
		}
		
		if (s.isEmpty() || s == null) {
			System.out.println("Error: resource name cannot be empty or null");
		} else {
			this.name = s;
		} 
	}
	
	// accessors and mutators
	public int getAmount() {
		return this.amount;
	}
	
	public void setAmount(int n) {
		if (n >= 0) {
			this.amount = n;
		} else {
			System.out.println("Error: cannot set resource amt to negative value");
		}
	}
	
	public int getMaximum() {
		return this.maximum;
	}
	
	public void setMaxmimum(int n) {
		if (n > 0) {
			this.maximum = n;
		} else {
			System.out.println("Error: max must be >0");
		}
	}
	
	// shouldnt need mutator for name, shouldnt change after being set by constructor
	public String getName() {
		return this.name;
	}
	// can be overriden or setName method added if necessary for specific subclass
	
	// incrementing amount
	public void increment(int n) {
		if (n >= 0) {
			if ((this.amount + n) >= this.maximum) {
				this.amount = this.maximum;
			} else {
				this.amount += n;
			}
		} else {
			System.out.println("Error: cannot increment amount by negative value");
		}
	}
	
	// decrementing amount
	public void decrement(int n) {
		if (n >= 0) {
			if ((this.amount - n) < 0) {
				this.amount = 0;
			} else {
				this.amount -= n;
			}
		} else {
			System.out.println("Error: cannot decrement amount by negative value");
		}
	}
	
	// increasing maximum
	public void increaseMaximum(int n) {
		if (n >= 0) {
			this.maximum += n;
		} else {
			System.out.println("Error: cannot increase max by negative value");
		}
	}
	// dont need to decrease max, subclasses can have their own method if needed
}