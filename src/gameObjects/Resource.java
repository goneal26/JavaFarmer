package gameObjects;

public class Resource {
    private int amount;
    private int maximum;
    private String name;

    public Resource(int n, int max, String s) {
        amount = n;
        maximum = max;
        name = s;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int n) {
        amount = n;
        if (amount > maximum) {
            amount = maximum;
        }
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int n) {
        maximum = n;
        if (amount > maximum) {
            amount = maximum;
        }
    }

    public String getName() {
        return name;
    }

    public void increment(int n) {
        amount += n;
        if (amount > maximum) {
            amount = maximum;
        }
    }

    public void decrement(int n) {
        amount -= n;
        if (amount < 0) {
            amount = 0;
        }
    }

    public void increaseMaximum(int n) {
        maximum += n;
    }
}
