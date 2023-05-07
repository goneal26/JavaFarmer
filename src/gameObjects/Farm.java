package gameObjects;

public class Farm implements Item {
    private int count;
    private String name;
    private Resource resource;

    public Farm(String type, Resource res) {
        count = 1;
        name = type;
        resource = res;
    }

    public Farm(String type, Resource res, int amt) {
        count = amt;
        name = type;
        resource = res;
    }

    public void craftItem() {
        // Implementation to be added later
    	count ++;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int n) {
        count = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    public void harvest() {
        resource.increment(count);
    }
}
