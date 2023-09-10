package org.example;

public abstract class Item {
    private String title;
    private String uniqueID;
    private boolean isBorrowed = false;

    public Item(String title) {
        this.title = title;
        uniqueID = idGenerator();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    abstract void borrowItem();
    abstract void returnItem();
    abstract String idGenerator();
}
