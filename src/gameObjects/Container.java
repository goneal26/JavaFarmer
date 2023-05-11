package gameObjects;

public class Container implements Item {
    private int count;
    private String name;
    private Resource resource; // might tweak how this works later

    public Container(String type, Resource res) {
        this.count = 1;
        this.name = type;
        this.resource = res;
    }

    public Container(String type, Resource res, int amt) {
    	if (amt > 0) {
    		this.count = amt;
    	}
        this.name = type;
        this.resource = res;
    }

    public void craftItem() {
        this.count++;
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
}
