# ReentrantLock in Java

## Overview
**ReentrantLock** (`java.util.concurrent.locks.ReentrantLock`) provides explicit mutual exclusion locking with **reentrancy** support, offering more control than `synchronized` blocks. The same thread can acquire the lock multiple times without deadlocking.[1]

## Key Characteristics

| Feature | Description |
|---------|-------------|
| **Reentrant** | Same thread can `lock()` multiple times (hold count increments) |
| **Explicit** | Manual `lock()`/`unlock()` (use `try-finally`) |
| **Flexible** | `tryLock()`, timeouts, interruptible, fairness option |
| **Thread-safe** | Atomic operations with visibility guarantees |

## Core Methods

```java
ReentrantLock lock = new ReentrantLock();  // Default: non-fair
ReentrantLock fairLock = new ReentrantLock(true);  // Fair: FIFO ordering
```

| Method | Purpose | Return |
|--------|---------|--------|
| `lock()` | Acquire lock (blocks if unavailable) | `void` |
| `unlock()` | Release lock (decrements hold count) | `void` |
| `tryLock()` | Non-blocking attempt | `boolean` |
| `tryLock(long, TimeUnit)` | Timeout attempt | `boolean` |
| `lockInterruptibly()` | Interruptible lock | `void` |
| `newCondition()` | Create Condition for await/signal | `Condition` |
| `getHoldCount()` | Current thread's hold count | `int` |
| `isLocked()` | Any thread holds lock | `boolean` |

## Basic Usage Pattern
```java
public class Counter {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();
    
    public void increment() {
        lock.lock();  // Acquire
        try {
            count++;
        } finally {
            lock.unlock();  // Always release
        }
    }
}
```

## Reentrancy Example
```java
public class ReentrantExample {
    private final ReentrantLock lock = new ReentrantLock();
    
    public void outerMethod() {
        lock.lock();  // HoldCount=1
        try {
            System.out.println("Outer: " + lock.getHoldCount());
            innerMethod();  // Same thread → HoldCount=2
        } finally {
            lock.unlock();  // HoldCount=1
        }
        // Must call unlock() again after innerMethod returns
        lock.unlock();  // HoldCount=0
    }
    
    public void innerMethod() {
        lock.lock();  // Reentrant acquisition
        try {
            System.out.println("Inner: " + lock.getHoldCount());
        } finally {
            lock.unlock();
        }
    }
}
```

## Advanced Examples

### 1. tryLock with Timeout
```java
if (lock.tryLock(5, TimeUnit.SECONDS)) {
    try {
        // Critical section with 5s timeout
    } finally {
        lock.unlock();
    }
} else {
    // Handle timeout
}
```

### 2. Interruptible Lock
```java
try {
    lock.lockInterruptibly();  // Can be interrupted
    // Critical section
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
} finally {
    if (lock.isHeldByCurrentThread()) {
        lock.unlock();
    }
}
```

### 3. Producer-Consumer with Condition
```java
private final ReentrantLock lock = new ReentrantLock();
private final Condition notEmpty = lock.newCondition();
private Queue<String> queue = new LinkedList<>();

public void produce(String item) throws InterruptedException {
    lock.lock();
    try {
        queue.add(item);
        notEmpty.signal();  // Wake waiting consumers
    } finally {
        lock.unlock();
    }
}

public String consume() throws InterruptedException {
    lock.lock();
    try {
        while (queue.isEmpty()) {
            notEmpty.await();  // Wait for items
        }
        return queue.poll();
    } finally {
        lock.unlock();
    }
}
```

## Comparison: ReentrantLock vs synchronized

| Aspect | ReentrantLock | synchronized |
|--------|---------------|--------------|
| **Lock Type** | Explicit | Implicit |
| **Reentrant** | Yes | Yes |
| **Interruptible** | Yes (`lockInterruptibly()`) | No |
| **Timeout** | Yes (`tryLock()`) | No |
| **Fairness** | Configurable | No |
| **Condition Variables** | Multiple (`newCondition()`) | Single (`wait()/notify()`) |
| **Try Lock** | Yes | No |

## Best Practices

1. **Always use try-finally**: Prevents lock leaks
2. **Check ownership**: `if (lock.isHeldByCurrentThread())`
3. **Avoid nested locks**: Increases deadlock risk
4. **Fair locks sparingly**: Performance overhead
5. **Document lock order**: For multi-lock scenarios

## Common Use Cases (LLD Context)
```
Parking Lot: Spot allocation under concurrent bookings
Vending Machine: Payment processing with nested validation
Polluxkart: Inventory updates across microservices [memory:8]
Elevator: Request processing with direction optimization
```

## Performance Considerations
- **Non-fair locks faster** (default)
- **Avoid in hot paths** if `synchronized` suffices
- **Use `StampedLock` for read-heavy scenarios** (Java 8+)

## Troubleshooting
```
HoldCount leak: Missing unlock() in finally block
Deadlock: Improper lock ordering
Starvation: Use fair locks sparingly
Interrupt ignored: Use lockInterruptibly()
```

**Perfect for your concurrent LLD practice alongside POJO/enum designs!**[2]

[1](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/locks/ReentrantLock.html)
[2](https://www.geeksforgeeks.org/java/reentrant-lock-in-java/)
[3](https://docs.oracle.com/cd/E17802_01/j2se/j2se/1.5.0/jcp/beta1/apidiffs/java/util/concurrent/locks/ReentrantLock.html)
[4](https://www.digitalocean.com/community/tutorials/java-lock-example-reentrantlock)
[5](https://learn.microsoft.com/en-us/dotnet/api/java.util.concurrent.locks.reentrantlock?view=net-android-35.0)
[6](https://developer.android.com/reference/java/util/concurrent/locks/ReentrantLock)
[7](https://nicklee1006.github.io/Java-Multithreading-15-ReentrantLock/)
[8](https://www.javamadesoeasy.com/2015/03/reentrantlocks-in-java.html)
[9](http://www.dre.vanderbilt.edu/~schmidt/cs891s/2020-PDFs/4.2.5-Java-ReentrantLock-example.pdf)
[10](https://smartprogramming.in/tutorials/java/reentrant-lock)