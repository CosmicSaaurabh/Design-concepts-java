package com.saurabh.iteratorDesignPattern.notFollowing;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BookCollection {
//    private Set<Book> books = new TreeSet<>();
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    // public Set<Book> getBooks()
    public List<Book> getBooks() {
        return books;
    }
}
