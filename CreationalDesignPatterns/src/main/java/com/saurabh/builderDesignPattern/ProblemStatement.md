### What it solves
When an object requires many parameters, especially optional ones, the constructor can become hard to use or maintain.
This issue can lead to 
1. Long constructor parameters list.
2. Difficult in understanding which values are optional or required.
3. Lack of flexibility when it comes to setting only some values.

For example, constructing an object with multiple optional parameters without the builder pattern can look lik this - not 
Following

### How to solve
when a class constructor have too many parameters, the Builder Pattern allows to step-by-step construction of complex objects

Solution: Separate the constructor of an object from its representation and offer a fluent interface for creating
complex objects.