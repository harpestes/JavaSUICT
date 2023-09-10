package org.example;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book("Animal Farm", "George Orwell");
        Book book2 = new Book("A Game of Thrones", "George Martin");
        DVD dvd1 = new DVD("Evil Beavers", 20);
        library.add(book1);
        library.add(book2);
        library.add(dvd1);
        library.add(dvd1);

        Patron patron1 = new Patron("Bobr");
        Patron patron2 = new Patron("Bebr");
        library.registerPatron(patron1);
        library.registerPatron(patron2);
        library.registerPatron(patron1);

        library.lendItem(patron1, book1);
        library.lendItem(patron2, book1);

        library.listAvailable();
        library.listBorrowed();
        library.listAvailable();

        library.returnItem(patron1, book1);
        library.returnItem(patron2, book1);

        library.remove(book1);

        library.listAvailable();
    }
}