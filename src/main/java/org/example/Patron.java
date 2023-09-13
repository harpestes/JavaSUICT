package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Patron {
    private String name;
    private String ID;
    private ArrayList<Item> borrowedItems;

    public Patron(String name) {
        this.name = name;
        borrowedItems = new ArrayList<>();
        ID = idGenerator();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public ArrayList<Item> getBorrowedItems() {
        return borrowedItems;
    }

    public void setBorrowedItems(ArrayList<Item> borrowedItems) {
        this.borrowedItems = borrowedItems;
    }

    public void borrowItem(Item i) {
        borrowedItems.add(i);
    }

    public void returnItem(Item i) {
        borrowedItems.remove(i);
    }

    private String idGenerator() {
        Random rnd = new Random();
        Library library = new Library();
        String result = rnd.ints(48, 123)
                .limit(16)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        if(library.getItems().stream().map(x -> x.getUniqueID().equals(result)).findAny().isPresent())
            return idGenerator();
        return result;
    }
}
