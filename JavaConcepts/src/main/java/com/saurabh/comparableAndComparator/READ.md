`Comparable` and `Comparator` are two ways to tell Java **how to sort objects**.

***

## Comparable – “natural” order inside the class

**Idea**: The class itself knows how it should be ordered.

- Interface: `java.lang.Comparable<T>`
- You implement it **inside** your class.
- You override **one method**:
  ```java
  int compareTo(T other);
  ```
- Used by: `Collections.sort(list)`, `Arrays.sort(array)`, `TreeSet`, `TreeMap` (when no external comparator is given). [javatrainingschool](https://javatrainingschool.com/how-to-sort-a-set-in-java/)

### Simple example

```java
public class Person implements Comparable<Person> {
    private String name;
    private int age;

    @Override
    public int compareTo(Person other) {
        // natural order: by age
        return Integer.compare(this.age, other.age);
    }
}
```

Now:

```java
List<Person> people = ...
Collections.sort(people);  // uses Person.compareTo
```

### When to use Comparable

- There is **one obvious** “natural” order (e.g., numbers, dates, names, IDs).
- You’re okay with that order being the **default** everywhere.
- You control the class code and can modify it.

***

## Comparator – custom external ordering

**Idea**: Sorting rule is defined **outside** the class.

- Interface: `java.util.Comparator<T>`
- You write a separate class, lambda, or anonymous class.
- You override **one method**:
  ```java
  int compare(T o1, T o2);
  ```
- Used by: `Collections.sort(list, comparator)`, `new TreeSet<>(comparator)`, `new TreeMap<>(comparator)`, streams `sorted(comparator)`.

### Simple example

```java
Comparator<Person> byName =
        (p1, p2) -> p1.getName().compareTo(p2.getName());

Comparator<Person> byAgeDesc =
        (p1, p2) -> Integer.compare(p2.getAge(), p1.getAge());  // reverse
```

Usage:

```java
Collections.sort(people, byName);       // sort by name
Collections.sort(people, byAgeDesc);    // sort by age, descending
```

### When to use Comparator

- You **cannot** change the class (library code).
- You need **multiple different sort orders** for the same class  
  (by age, by name, by salary, etc.).
- You want sorting logic **outside** the domain object (cleaner model).

***

## How compareTo / compare should behave

Both methods must return:

- `< 0` if first < second
- `0` if first == second
- `> 0` if first > second

Typical pattern:

```java
@Override
public int compareTo(Person other) {
    return Integer.compare(this.age, other.age);
}
```

Or with `Comparator` helpers:

```java
Comparator<Person> byAgeThenName =
        Comparator.comparingInt(Person::getAge)
                  .thenComparing(Person::getName);
```

***

## Which one should you choose?

| Question | Use |
|----------|-----|
| Object has one obvious natural order (e.g., `LocalDate`, `String`)? | `Comparable` |
| Need multiple sort criteria for same type? | `Comparator` |
| You don’t own the class? | `Comparator` |
| You want collections like `TreeSet` or `TreeMap` to use your custom order? | Pass a `Comparator` to their constructor |

A common pattern in real projects is:

- Implement a **simple, natural** `Comparable` (e.g., by ID or creation time).
- Use different **Comparators** wherever you need alternative business sort orders.