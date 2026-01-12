package com.saurabh.iteratorDesignPattern.followingPattern;

public class Book implements Comparable<Book>{
    private String title;

    public Book(String s) {
        this.title = s;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" + "title= " + title +  "}";
    }

    @Override
    public int compareTo(Book o) {
        return this.title.compareTo(o.title);
    }
}
