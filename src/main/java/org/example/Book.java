package org.example;

import java.util.Random;

public class Book extends Item {
    private final String author;
    public Book(String title, String author) {
        super(title);
        this.author = author;
    }

    public String getAuthor() {
        return author;
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
        return "Book title: " + super.getTitle() + ", Author: " + author + "; ";
    }
}
