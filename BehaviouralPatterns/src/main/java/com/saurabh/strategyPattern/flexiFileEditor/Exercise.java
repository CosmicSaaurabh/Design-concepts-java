package com.saurabh.strategyPattern.flexiFileEditor;

import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
        new Exercise().run();
    }

    // Do not modify the run method. It facilitates the formatting process of a document using different formatting strategies.
    public void run() {

        Scanner sc = new Scanner(System.in);
        Document document = new Document();

        String userInput = sc.nextLine();
        document.setContent(userInput);

        // Using PlainTextFormatter
        // TODO: Set the formatter for the document to PlainTextFormatter.
        PlainTextFormatter plainTextFormatter = new PlainTextFormatter();
        document.setFormatter(plainTextFormatter);

        System.out.println("Plain Text:");
        document.display();

        // Using HTMLFormatter
        // TODO: Set the formatter for the document to HTMLFormatter.
        HTMLFormatter htmlFormatter = new HTMLFormatter();
        document.setFormatter(htmlFormatter);

        System.out.println("HTML Format:");
        document.display();

        // Using MarkdownFormatter
        // TODO: Set the formatter for the document to MarkdownFormatter.
        MarkdownFormatter markdownFormatter = new MarkdownFormatter();
        document.setFormatter(markdownFormatter);

        System.out.println("Markdown Format:");
        document.display();

        sc.close();
    }
}