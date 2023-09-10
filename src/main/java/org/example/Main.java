package org.example;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addToLibrary("Animal Farm", "George Orwell", 9786558178804L, (short)1945);
        library.addToLibrary("The Lord Of Flies", "William Golding", 9781573226127L, (short)1954);
        library.addToLibrary("A Game of Thrones", "George Martin", 9780007237500L, (short)1996);
        library.addToLibrary("A Clash of Kings", "George Martin", 9781984821157L, (short)1998);
        library.addToLibrary("Sezon burz", "Andrzej Sapkowski", 9788842932796L, (short)2013);
        library.addToLibrary("A Feast for Crows", "George Martin", 9783442268603L, (short)2005);
        library.addToLibrary("Pani Jeziora", "Andrzej Sapkowski", 9780316273831L, (short)1999);

        library.addToLibrary("A Clash of Kings", "George R. R. Martin", 9781984821157L, (short)1998);

        library.printAllBooks();

        library.findBookByName("A Clash of Kings");
        library.findBookByName("The Clash of King");

        library.deleteBookByISBN(9783442268603L);
        library.deleteBookByISBN(1111111111111L);
    }
}