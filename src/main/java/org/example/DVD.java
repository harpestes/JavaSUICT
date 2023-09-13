package org.example;

import java.util.Random;

public class DVD extends Item{

    private final int duration;
    public DVD(String title, int duration) {
        super(title);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String idGenerator() {
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

    @Override
    void borrowItem() {
        super.setBorrowed(true);
    }

    @Override
    void returnItem() {
        super.setBorrowed(false);
    }

    @Override
    public String toString() {
        return "DVD title: " + super.getTitle() + ", Duration: " + duration + "min; ";
    }
}
