package com.spartaglobal.samurah;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Store implements StoreInterface {

    private HashMap<String, Integer> items;

    public Store() {
        items = new HashMap<>();
    }

    @Override
    public int getCost(String product) {
        return items.get(product);
    }

    @Override
    public int getCost(Collection<String> products) {
        int totalCost = 0;
        for(String product:products) {
            if(doesItemExist(product)) {
                totalCost += getCost(product);
            }
        }
        return totalCost;
    }

    @Override
    public boolean addProduct(String productName, int price) {
        if (productName == null || !doesItemExist(productName)) {
            return false;
        } else if (price > 0) {
            items.put(productName, price);
            return true;
        } else {
            System.out.println("Price of "+ productName +" must be greater than 0.");
            return false;
        }
    }

    @Override
    public boolean removeProduct(String productName) {
        if (productName != null && doesItemExist(productName)) {
            items.remove(productName);
            return true;
        }
        else return false;
    }

    @Override
    public Map<String, Integer> getItems() {
        return items;
    }

    @Override
    public boolean doesItemExist(String productName) {
        return items.containsKey(productName);
    }

    @Override
    public boolean addProducts(Map<String, Integer> products) {
        for (String product : products.keySet()) {
            if (!items.containsKey(product)) {
                addProduct(product, products.get(product));
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeProducts(Collection<String> products) {
        for (String product : products) {
            if (!removeProduct(product)) {
                return false;
            }
        }
        return true;
    }
}
