package com.spartaglobal.samurah;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileReader implements FileReaderInterface {

    private BufferedReader reader;

    @Override
    public ArrayList<String> getShoppingList() {
        ArrayList<String> items = new ArrayList<>();
        String line;
        try {
            while (((line = reader.readLine()) != null)) {
                String[] splitLine = line.split(",");
                items.addAll(Arrays.asList(splitLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return items;
    }

    @Override
    public boolean initialize(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            try {
                reader = new BufferedReader(new java.io.FileReader(file));
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
