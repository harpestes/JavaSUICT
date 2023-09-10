package org.example;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public boolean addToLibrary(String name, String author, long ISBN, short year) {
        if (findIndexByISBN(ISBN) == -1) {
            return books.add(new Book(name, author, ISBN, year));
        }
        else {
            printer("Book with ISBN: " + ISBN + " already exist");
            return false;
        }
    }

    public void printAllBooks() {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Book name\t\t\t\tAuthor name\t\t\tISBN\t\t\t\tYear");
        for (Book b: books) {
            System.out.println(b.toString());
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    public Book findBookByName(String name) {
        for (Book b : books) {
            if(b.getName().equals(name)) {
                System.out.println("-------------------------------------------------------------------------");
                System.out.println("Book name\t\t\t\tAuthor name\t\t\tISBN\t\t\t\tYear");
                System.out.println(b);
                System.out.println("-------------------------------------------------------------------------");
                return b;
            }
        }

        printer("There is no book with this name: \"" + name + "\"");
        return null;
    }

    public Book deleteBookByISBN(long ISBN) {
        if (findIndexByISBN(ISBN) == -1) {
            printer("There is no book with this ISBN: " + ISBN);
            return null;
        }
        else {
            printer("Book with ISBN: " + ISBN + " successfully removed");
            return books.remove(findIndexByISBN(ISBN));
        }
    }

    private int findIndexByISBN(long ISBN) {
        int index = -1;

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getNumber() == ISBN) {
                index = i;
                break;
            }
        }
        return index;
    }

    private void printer(String message) {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(message);
        System.out.println("-------------------------------------------------------------------------");
    }
}
