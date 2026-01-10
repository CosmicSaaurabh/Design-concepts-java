### Problem statement

We want to build a chat system with multiple participants where each user can send message to every other users.
If users send message to each other user directly, the complexity increases as the number of user increases. 
Problem is each user must know about the other user, creating a complex web of communication and dependencies.


### How to solve

##### Scenario
In a chat system, multiple participants communicate through a central chat mediator, reducing the need to know
every other user present.

Mediator: Chat Server
Colleagues: Chat participants send messages to mediator which distributes message to every other user.

