In Java, an **abstract class** is a class declared with the `abstract` keyword that **cannot be instantiated directly** and serves as a blueprint for subclasses, containing both **abstract methods** (no implementation) and **concrete methods** (with implementation).[1]

## Key Characteristics
- **Cannot create objects**: `new AbstractClass()` → compile error
- **Must extend**: Subclasses inherit and implement abstract methods
- **Partial implementation**: Mix of implemented + unimplemented methods
- **Constructors allowed**: Called during subclass instantiation
- **Fields supported**: Instance variables + static members

## When to Use Abstract Classes

### ✅ **Use Cases**
```
1. **Template Method Pattern** (Parking Lot example)
   abstract class ParkingLot {
       abstract ParkingSpot allocateSpot(Vehicle v);  // Subclasses implement
       public void processEntry(Vehicle v) {          // Common logic
           ParkingSpot spot = allocateSpot(v);
           spot.assignVehicle(v);
       }
   }

2. **Shared Implementation** (Your Polluxkart microservices)
   abstract class OrderProcessor {
       protected void validateStock() { /* common */ }
       abstract void processPayment();  // Service-specific
   }

3. **"IS-A" Relationships** (Elevator states)
   abstract class ElevatorState {
       abstract void handleRequest(Elevator e, int floor);
   }
```

### ✅ **LLD Examples from Your Practice**
```
- Vehicle → Car, Bike, Truck (common methods + specific behavior)
- PaymentProcessor → CashPayment, CardPayment  
- SpotAllocator → NearestSpot, NearestEmptyFloor
```

## When NOT to Use Abstract Classes

### ❌ **Avoid When**
```
1. **Pure Abstraction** → Use Interface
   ```
interface Drawable { void draw(); }  // No implementation
   ```

2. **Multiple Inheritance** → Interface (pre-Java 8 limitation)
   ```
class MyClass implements Drawable, Serializable {}  // Multiple OK
// vs
class MyClass extends AbstractClass {}  // Single inheritance only
   ```

3. **No Shared Implementation**
   ```
// Bad: Empty abstract class
abstract class Payment {}  // Use enum instead[11]
   ```

4. **Final Classes** → Concrete class with `final` methods
   ```
final class ImmutableVehicle { /* no extension needed */ }
   ```

## Abstract Class vs Interface (LLD Context)

| Aspect | Abstract Class | Interface |
|--------|----------------|-----------|
| **Methods** | Abstract + Concrete | Default + Abstract (Java 8+) |
| **Fields** | Instance + Static | `public static final` only |
| **Inheritance** | Single | Multiple |
| **Constructor** | Yes | No |
| **LLD Use** | Template Method | Contracts/Strategies |

## Practical Example (Your Vending Machine)
```java
abstract class VendingMachine {
    protected Inventory inventory;
    protected PaymentProcessor payment;
    
    // Constructor
    public VendingMachine(Inventory inv, PaymentProcessor p) {
        this.inventory = inv;
        this.payment = p;
    }
    
    // Concrete method (shared logic)
    public void dispenseItem(String itemId) {
        if (inventory.hasItem(itemId)) {
            processPayment(itemId);
            inventory.removeItem(itemId);
        }
    }
    
    // Abstract method (subclass responsibility)
    abstract void processPayment(String itemId);
}

// Concrete implementation
class CoinVendingMachine extends VendingMachine {
    @Override
    void processPayment(String itemId) {
        // Coin-specific logic with ReentrantLock [prior discussion]
    }
}
```

**Perfect for your LLD interviews**—use abstract classes when sharing **common code** with **variation points**, interfaces for pure contracts [web:110].

[1](https://www.geeksforgeeks.org/java/abstract-classes-in-java/)
[2](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)
[3](https://www.w3schools.com/java/java_abstract.asp)
[4](https://www.simplilearn.com/tutorials/java-tutorial/abstract-class-in-java)
[5](https://herovired.com/home/learning-hub/blogs/abstract-class-in-java)
[6](https://www.baeldung.com/java-abstract-class)
[7](https://cuvette.tech/blog/understanding-abstract-class-in-java-a-deep-dive)
[8](https://www.theserverside.com/definition/abstract-class)
[9](https://www.digitalocean.com/community/tutorials/abstract-class-in-java)
[10](https://www.geeksforgeeks.org/java/difference-between-abstract-class-and-interface-in-java/)
[11](https://www.w3schools.com/java/java_enums.asp)