package shopping;

import java.util.*;

public class Cart {
    private List<Product> items = new ArrayList<>();

    public void addItem(Product p) {
        items.add(p);
    }

    public List<Product> getItems() {
        return items;
    }

    public double getTotal() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }
}
