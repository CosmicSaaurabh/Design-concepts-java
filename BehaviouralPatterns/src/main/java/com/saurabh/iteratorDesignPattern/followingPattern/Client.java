package com.saurabh.iteratorDesignPattern.followingPattern;

import com.saurabh.iteratorDesignPattern.followingPattern.Book;

import java.util.Iterator;

public class Client {
    public static void main(String[] args) {
        BookCollection bookCollection = new BookCollection();
        Book book1 = new Book("C++ book");
        Book book2 = new Book("Java Book");
        Book book3 = new Book("Python Book");

        bookCollection.addBook(book1);
        bookCollection.addBook(book2);
        bookCollection.addBook(book3);

        Iterator bookIterator = bookCollection.createBookIterator();
        while(bookIterator.hasNext()) {
            Book book = (Book) bookIterator.next();
            System.out.println(book.toString());
        }

    }
}
