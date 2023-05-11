package gameObjects;

public class Resource {
    private int amount;
    private int maximum;
    private String name;

    public Resource(int n, int max, String s) {
        this.amount = n;
        this.maximum = max;
        this.name = s;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int n) {
        if (n <= maximum && n > 0) {
            this.amount = n;
        }
    }

    public int getMaximum() {
        return this.maximum;
    }

    public void setMaximum(int n) {
        if (n > 0) {
            this.maximum = n;
        }
    }

    public String getName() {
        return name;
    }

    public void increment(int n) {
    	if (n > 0) {
    		this.amount += n;
    		if (this.amount > this.maximum) {
    			this.amount = this.maximum;
    		}
    	}
    }

    public void decrement(int n) {
    	if (n > 0) {
    		this.amount -= n;
            if (this.amount < 0) {
                this.amount = 0;
            }
    	}
    }

    public void increaseMaximum(int n) {
    	if (n > 0) {
    		this.maximum += n;
    	}
    }
}
