package gameObjects;

public class Farm implements Item {
    private int count;
    private String name;
    private Resource resource;

    public Farm(String type, Resource res) {
        this.count = 0;
        this.name = type;
        this.resource = res;
    }

    public Farm(String type, Resource res, int amt) {
    	if (amt > 0) {
    		this.count = amt;
    	}
        this.name = type;
        this.resource = res;
    }

    public void craftItem() {
        // Implementation to be added later
    	this.count ++;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int n) {
    	if (n >= 0) {
    		this.count = n;
    	}
    }

    public String getName() {
        return this.name;
    }

    public void setName(String s) {
        this.name = s;
    }

    public void harvest() {
        this.resource.increment(this.count);
    }
}
