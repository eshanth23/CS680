Metal Detector Application
Overview
This is a simulation of a Metal Detector system using the State Design Pattern. The application models a typical metal detector used in security checks at places like airports. The detector has three main states: Idle, Scanning, and Alarm. The system transitions between these states based on motion detection and whether metal is detected. The goal of this implementation is to demonstrate the use of the State Design Pattern to manage the different states and their behaviors.

Key Features
Idle State: The metal detector is inactive and waiting for motion detection.
Scanning State: The metal detector actively scans for metal when motion is detected.
Alarm State: If metal is detected, the detector triggers an alarm.
State Design Pattern
The State Design Pattern allows the system to change its behavior when its internal state changes. This pattern encapsulates state-specific behavior into individual classes, making it easier to maintain and scale the system as new states can be added without modifying the core logic.

