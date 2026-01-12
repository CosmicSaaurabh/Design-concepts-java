package com.saurabh.iteratorDesignPattern.followingPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 class BookIterator implements Iterator<Book> {
    private List<Book> books = new ArrayList<>();
    int position = 0;

    BookIterator(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean hasNext() {
        return position < books.size();
    }

    @Override
    public Book next() {
//        Book book = books.get(position);
//        position += 1;
//        return book;
        return books.get(position++);
    }
}
