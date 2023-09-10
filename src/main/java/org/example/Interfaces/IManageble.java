package org.example.Interfaces;

import org.example.Item;

import java.util.ArrayList;

public interface IManageble {
    boolean add(Item i);
    Item remove(Item i);
    ArrayList<Item> listBorrowed();
    ArrayList<Item> listAvailable();
}
