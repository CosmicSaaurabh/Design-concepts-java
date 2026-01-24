A record class is a **special kind of class** in Java used to model simple, immutable data carriers with minimal boilerplate code. It automatically gives you fields, a constructor, accessors, `equals`, `hashCode`, and `toString` based on its components. [docs.oracle](https://docs.oracle.com/en/java/javase/17/language/records.html)

## Basic idea and syntax
Instead of writing a full POJO:

```java
public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override public boolean equals(Object o) { ... }
    @Override public int hashCode() { ... }
    @Override public String toString() { ... }
}
```

you can write:

```java
public record Person(String name, int age) { }
```

The compiler generates:
- `private final` fields `name` and `age`
- A canonical constructor `Person(String name, int age)`
- Accessor methods `name()` and `age()`
- Value-based `equals`, `hashCode`, and `toString()`. [jenkov](https://jenkov.com/tutorials/java/record.html)

## Key properties
- **Immutable data**: components are stored in private final fields; there are no setters. [dzone](https://dzone.com/articles/understanding-the-java-record-class)
- **Final type**: records are implicitly `final`, cannot be extended, and extend `java.lang.Record` (not other classes). [docs.oracle](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Record.html)
- **Can implement interfaces**: you can add methods and implement interfaces, but extra instance fields are not allowed (only static fields). [javadzone](https://javadzone.com/record-classes-in-java-17/)

Example with methods and validation:

```java
public record User(String name, int age) {
    public User {
        if (age < 0) {
            throw new IllegalArgumentException("age must be >= 0");
        }
    }

    public boolean isAdult() {
        return age >= 18;
    }
}
```

## When to use records
Use a record when:
- The class’s main purpose is to **hold data** (DTOs, API models, configuration, key/value pairs). [aegissofttech](https://www.aegissofttech.com/insights/what-is-java-record-benefits-features/)
- You want **immutability** and value-based equality.
- You don’t need inheritance from other classes or mutable state.

Avoid records when:
- You need **mutable** objects with setters or changing fields.
- You need to extend another class (records cannot do this).
- The type has significant behavior beyond being a data container.

In short, records are an elegant replacement for many boilerplate POJOs where the class is primarily a simple, immutable data holder.