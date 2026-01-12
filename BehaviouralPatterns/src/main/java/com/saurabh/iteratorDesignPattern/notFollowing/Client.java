package com.saurabh.iteratorDesignPattern.notFollowing;

public class Client {
    public static void main(String[] args) {
        BookCollection bookCollection = new BookCollection();
        Book book1 = new Book("C++ book");
        Book book2 = new Book("Java book");
        Book book3 = new Book("Python book");

        bookCollection.addBook(book1);
        bookCollection.addBook(book2);
        bookCollection.addBook(book3);

        // book collection changes to keep books in TreeSet then it will fail
        for (int i = 0; i < (int)bookCollection.getBooks().size(); i++) {
            System.out.println("Book is: " + bookCollection.getBooks().get(i).toString());
        }

    }
}
