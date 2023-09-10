package org.example;

import org.example.Interfaces.IManageble;

import java.util.ArrayList;

public class Library implements IManageble {
    private final ArrayList<Item> items = new ArrayList<>();
    private final ArrayList<Patron> patrons = new ArrayList<>();

    public boolean registerPatron(Patron p) {
        if(!patrons.contains(p)) {
            patrons.add(p);
            return true;
        }
        printer("This patron already exist!");
        return false;
    }

    public boolean lendItem(Patron p, Item i) {
        if (!i.isBorrowed() && items.contains(i)) {
            i.borrowItem();
            p.borrowItem(i);
            return true;
        }
        printer("Item already borrowed or doesn't register in library!");
        return false;
    }

    public Item returnItem(Patron p, Item i) {
        if(i.isBorrowed() && p.getBorrowedItems().contains(i) && items.contains(i)) {
            i.returnItem();
            p.returnItem(i);
            return i;
        }
        printer("Item already returned or patron has no item!");
        return null;
    }
    @Override
    public boolean add(Item i) {
        for (Item item : items) {
            if(item.getUniqueID().equals(i.getUniqueID())){
                printer("Item already exist!");
                return false;
            }
        }
        printer("Item successfully added!");
        return items.add(i);
    }

    @Override
    public Item remove(Item item) {
        for (int i = 0; i < items.size(); i++) {
            if(item.getUniqueID().equals(items.get(i).getUniqueID())){
                printer("Item successfully removed!");
                return items.remove(i);
            }
        }
        printer("Item does not exist!");
        return null;
    }

    @Override
    public ArrayList<Item> listBorrowed() {
        ArrayList<Item> listBorrowed = new ArrayList<>();
        for (Item i : items) {
            if(i.isBorrowed()) listBorrowed.add(i);
        }
        if(listBorrowed.size() != 0) {
            printer("List of borrowed items:\n" + listBorrowed);
            return listBorrowed;
        }
        printer("There is no borrowed items!");
        return null;
    }

    @Override
    public ArrayList<Item> listAvailable() {
        ArrayList<Item> listAvailable = new ArrayList<>();
        for (Item i : items) {
            if(!i.isBorrowed()) listAvailable.add(i);
        }
        if(listAvailable.size() != 0) {
            printer("List of available items:\n" + listAvailable);
            return listAvailable;
        }
        printer("There is no available items!");
        return null;
    }

    private void printer(String message) {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(message);
        System.out.println("-------------------------------------------------------------------------");
    }
}
