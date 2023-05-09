package gameObjects;

public interface Item {
    void craftItem();
    int getCount();
    void setCount(int n);
    String getName();
    void setName(String s);
}
