package com.spartaglobal.samurah;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Store implements StoreInterface {
    private final HashMap<String, Integer> products;

    public Store() {
        products = new HashMap<>();
    }

    @Override
    public int getCost(String product) {
        return 0;
    }

    @Override
    public int getCost(Collection<String> products) {
        return 0;
    }

    @Override
    public boolean addProduct(String productName, int price) {
        if (productName == null || doesItemExist(productName)) {
            return false;
        } else if (price > 0) {
            products.put(productName, price);
            return true;
        } else {
            System.out.println("Price must be greater than zero.");
            return false;
        }
    }

    @Override
    public boolean removeProduct(String productName) {
        if (productName != null) {
            products.remove(productName);
            return true;
        }
        else return false;
    }

    @Override
    public Map<String, Integer> getItems() {
        return products;
    }

    @Override
    public boolean doesItemExist(String productName) {
        return false;
    }

    @Override
    public boolean addProducts(Map<String, Integer> products) {
        return false;
    }
    @Override
    public boolean removeProducts(Collection<String> products) {
        for (String product : products) {
            if (doesItemExist(product)) {
                removeProduct(product);
            } else {
                return false;
            }
        }
        return true;
    }
}
