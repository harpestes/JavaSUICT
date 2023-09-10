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
        return rnd.ints(48, 123)
                .limit(16)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
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
