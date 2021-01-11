package com.spartaglobal.samurah;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Store implements StoreInterface{

    private HashMap<String, Integer> products;

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
        return false;
    }

    @Override
    public boolean removeProduct(String productName) {
        return false;
    }

    @Override
    public Map<String, Integer> getItems() {
        return null;
    }

    @Override
    public boolean doesItemExist(String productName) {
        if (productName == null) {
            return false;
        }
        return products.containsKey(productName);
    }

    @Override
    public boolean addProducts(Map<String, Integer> products) {
        for (String product : products.keySet()) {
            if(!doesItemExist(product)){
                this.products.put(product, products.get(product));
            }
            return false;
        }
        return true;
    }

    @Override
    public boolean removeProducts(Collection<String> products) {
        return false;
    }
}
