package com.saurabh.iteratorDesignPattern.followingPattern;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookCollection {

    // if we change the collection to treeSet, then we just need to update BookIterator instead of changing client code
    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Iterator<Book> createBookIterator() {
        return new BookIterator(books);
    }
}
