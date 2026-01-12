package com.saurabh.iteratorDesignPattern.followingPattern;

import java.util.Iterator;

public class ClientV2 {
    public static void main(String[] args) {
        BookCollectionV2 bookCollection = new BookCollectionV2();

        Book book3 = new Book("Python Book");
        Book book1 = new Book("C++ book");
        Book book2 = new Book("Java Book");


        bookCollection.addBook(book1);
        bookCollection.addBook(book2);
        bookCollection.addBook(book3);

        Iterator bookIterator = bookCollection.iterator();
        while(bookIterator.hasNext()) {
            Book book = (Book) bookIterator.next();
            System.out.println(book.toString());
        }

    }
}
