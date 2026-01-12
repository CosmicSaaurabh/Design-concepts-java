package com.saurabh.iteratorDesignPattern.followingPattern;

import java.util.*;
import java.util.Iterator;

public class BookCollectionV2 implements Iterable<Book>{

    private Set<Book> books = new TreeSet<>();

    public Set<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }
    @Override
    public Iterator<Book> iterator() {
//        return new BookIterator();
        return books.iterator();
    }

//    private class BookIterator implements Iterator<Book> {
//
//        @Override
//        public boolean hasNext() {
//            return false;
//        }
//
//        @Override
//        public Book next() {
//            return null;
//        }
//    }
}
