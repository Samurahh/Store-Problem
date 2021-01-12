package com.spartaglobal.samurah;

import java.util.Collection;

public interface ShoppingListReaderInterface {
    Collection<String> getShoppingList();//gets the items from filePath
    boolean initialize(String filePath);//initialize the fileReader with file from filePath and processes the shopping list
}
