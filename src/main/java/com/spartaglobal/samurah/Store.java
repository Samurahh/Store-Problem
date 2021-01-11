package com.spartaglobal.samurah;

import java.util.Collection;
import java.util.Map;

public class Store implements StoreInterface{
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
        return false;
    }

    @Override
    public boolean addProducts(Map<String, Integer> products) {
        return false;
    }

    @Override
    public boolean removeProducts(Collection<String> products) {
        return false;
    }
}
