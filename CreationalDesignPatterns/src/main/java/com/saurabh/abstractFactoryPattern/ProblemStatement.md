### What is solves







### How it solves

Provides in interface for creating the families of related objects without specifying the concrete classes.

Structure - 
1. Abstract Factory :- Interface for creating abstract product
2. Concrete Factor :- Implements the Abstract factory and creates concrete products

Using the Abstract Factory Pattern, you create interfaces for each product e.g. windows, mac, scrollBar, keyBoard and provide 
family of concrete implementations for each theme eg WindowsScrollBar, MacScrollBar

The Abstract Factory provides a way to create a suite of related objects without knowing the exact types of objects that will be 
created.