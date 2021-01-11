package com.spartaglobal.samurah;

import java.util.Collection;
import java.util.Map;

public interface StoreInterface {
    int getCost(String product); //the cost of one product "product"
    int getCost(Collection<String> products); //the total cost of products from the inventory of the shop
    boolean addProduct(String productName, int price); //adds the product to the inventory of the shop (true - if added, false- if exists already)
    boolean removeProduct(String productName); //removes the product from the inventory of the shop (true - if removed, false - if doesn't exist)
    Map<String, Integer> getItems(); //get total inventory of shop
    boolean doesItemExist(String productName); //check if the item exists in the inventory
    boolean addProducts(Map<String, Integer> products); //add products in the inventory (true - if added, false- if exists already)
    boolean removeProducts(Collection<String> products);  //removes products in the inventory (true - if removed, false - if doesn't exist)
}
