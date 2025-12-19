/* This is an example of violating the Liskov Substitution Principle.
 * Here, the ReadOnlyFile class extends File but does not support the write operation,
 * which can lead to runtime errors when a ReadOnlyFile object is used in place of a File object.
 */

package com.saurabh.liskov_substitution_principle.BadCode;

public class Main {
    public static void main(String[] args) {
        File readOnlyFile = new ReadOnlyFile();
        readOnlyFile.read(); // This works fine

        // The following line will throw an exception at runtime
        readOnlyFile.write(); // This violates Liskov Substitution Principle as parent class cannot be replaced by child class without issues
    }
}
