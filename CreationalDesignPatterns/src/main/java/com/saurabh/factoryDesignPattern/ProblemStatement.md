## why we need

Consider an example of transportation service app where users request diffrent types of transport vehicles
e.g., car, bike, Bus. you might initially create a separate classes for each type and create instances like this

```Car car = new Car();```
```Bus bus = new Bus();````

But as the system evolves managing object creation direcly like this can be complex, especially when adding new vehicle.

client code will be tightly coupled with car, bus, bike objects which violates open/closed principle

## Solution

The factory pattern help centralize the creation logic and delegates the responsibility of creating objects to factory 
classes, which decides the specific class to instantiate. This allows the code to adhere Open/Closed principle by letting 
new types of vehicles added without modifying the existing code.