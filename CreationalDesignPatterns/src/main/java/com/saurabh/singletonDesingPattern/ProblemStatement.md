## Why we need

In certain situations, such as managing a database connection, logging or configuration settings, we want to ensure that
only one instance  of a class is created throughout the applications lifecycle. If multiple instances are created, it could
lead to issues like 

1. Inconsistent states
2. Resource conflict

## How to solve
1. Keep a reference of the class as private member of class called as instance which keep the instance of the class
2. Make the constructor as private to prevent direct object creation 
3. create a public method to return the instance member and initialise it to a object if it is null

