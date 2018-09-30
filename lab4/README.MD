The two design patterns that are used are
1. State Pattern
2. Observer Pattern

* State pattern is used to change the state of table from available to booked and vice-versa, on reqeuest from the table manager.
* StateManager plays the role of context and defines current state of Table
* Concrete Table state classes implements the behaviour associated with each state
* Observer pattern is used to notify the topmost customer on waitlist about the availability of table
* Observer pattern is also used to notify TableManager about the requests of the customer
