package com.saurabh.strategyPattern.flexiFileEditor;


// This class represents a document that can have its content formatted using different strategies.
public class Document {

    private String content;
    private TextFormatter formatter;

    public void setContent(String content) {
        this.content = content;
    }

    public void setFormatter(TextFormatter formatter) {
        this.formatter = formatter;
    }

    public void display() {
        // TODO: Print the formatted content using the chosen formatter.
        System.out.println(this.formatter.format(content));
    }
}