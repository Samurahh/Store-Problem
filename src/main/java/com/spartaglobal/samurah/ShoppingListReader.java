package com.spartaglobal.samurah;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ShoppingListReader implements ShoppingListReaderInterface {

    private BufferedReader reader;

    public ShoppingListReader(String filePath) {
        initialize(filePath);
    }

    @Override
    public Collection<String> getShoppingList() {
        ArrayList<String> items = new ArrayList<>();
        String line;
        try {
            while (((line = reader.readLine()) != null)) {
                String[] splitLine = line.split(",");
                items.addAll(Arrays.asList(splitLine));
            }
        } catch (Exception e) {
//            e.printStackTrace();
            return Collections.emptyList();
        }
        return items;
    }

    @Override
    public boolean initialize(String filePath) {
        if (filePath != null) {
            try {
                reader = new BufferedReader(new FileReader(filePath));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        } else {
            return false;
        }
    }
}