
Explanation for HW-5: Many-to-Many Event Notification using Multicast Design Pattern

In this homework, I have successfully implemented the Many-to-Many Event Notification Multicast Design Pattern.

What is happening here?
We are simulating a Car Sensor System where multiple sensors (observables) send data to multiple observers.

Observables (Sensors):
1. Speed Sensor
2. Fuel Mileage Sensor


Observers (Subscribers):
1. Car Dashboard Display
2. Car Brand App
3. Car Website

How does Many-to-Many Work here?
- Each sensor notifies all observers when an event occurs (like speed change, fuel mileage change).
- All observers receive and update the same data simultaneously, following the Multicast Design Pattern.




