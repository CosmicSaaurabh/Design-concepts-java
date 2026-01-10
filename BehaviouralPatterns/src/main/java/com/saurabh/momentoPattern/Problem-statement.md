### Problem Statement

Memento design pattern enables undo/redo functionality by capturing and restoring an object's internal state without breaking encapsulation.

#### Problem It Solves
Applications like text editors, games, or transaction systems need to support "undo" operations. 
Direct state access by external classes violates encapsulation, while copying entire complex object graphs is inefficient and error-prone. 
Memento solves this by letting objects create lightweight "snapshots" of their state that others can store and restore later.


### Solution

How It Works
Three key participants:

Originator: Object whose state changes (creates/restores mementos)

Memento: Snapshot containing originator's state (opaque to outsiders)

Caretaker: Manages memento history (never inspects memento contents)

The originator creates mementos with full state access, while caretakers only get narrow interfaces (add/restore). This preserves encapsulation while enabling state rollback.