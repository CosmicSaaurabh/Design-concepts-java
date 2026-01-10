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


##### Benefits

1. Reduces Complexity :- reduces direct dependencies between objects
2. Loose Coupling :- Users only interact with mediator, making them easier to manage.
3. Single Responsibility :- mediator handles logic go complex logic of sending message, keeping users to focus on their behaviour
4. Centralized control :- Changes to communication rules can be made in mediator without affecting the users.
