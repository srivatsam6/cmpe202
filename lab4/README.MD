The two design patterns that are used are
1. State Pattern
* State pattern is used to change the state of table from available to booked and vice-versa, on reqeuest from the table manager
* StateManager plays the role of context and defines current state of Table
* Concrete Table state classes implements the behaviour associated with each state

2. Observer Pattern
* Observer pattern is used to notify the topmost customer on waitlist about the availability of table
* Observer pattern is also used to notify TableManager about the booking requests of the customer
* RestaurantManager plays the role of subject that notifies observers up on a request from customer
* TableStateManager is the observer which triggers the table state change up on notification from the publisher
