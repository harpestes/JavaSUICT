package org.example;

public class Book {
    private String name;
    private String author;
    private long number;
    private short year;

    public Book(String name, String author, long number, short year) {
        this.name = name;
        this.author = author;
        this.number = number;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public long getNumber() {
        return number;
    }

    @Override
    public String toString() {
        String result = "";
        if(name.length() > 12) result += name + "\t\t";
        else if(name.length() == 12) result += name + "\t\t\t";
        else result += name + "\t\t\t\t";

        if(author.length() < 17) result += author + "\t\t";
        else result += author + "\t";

        result += number + "\t\t" + year;

        return result;
    }
}
