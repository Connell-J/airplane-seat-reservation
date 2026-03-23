# Airplane Seat Reservation System

A Java application that lets users reserve and cancel seats on a plane. The number of seats is set at runtime via user input, and availability is tracked in real time.

## How It Works

The user defines the plane size on startup. They can then reserve or cancel seats and check availability. The system immediately confirms whether a selected seat is available or already taken.

## Project Structure
├── Airplane.java      # Manages the seat array and reservation logic
├── Seat.java          # Represents an individual seat and its status
└── Project1.java      # Entry point, handles user input and menu

## How to Run

1. Clone the repository
2. Open the project in **Eclipse**
3. Run `Project1.java`
4. Enter the number of seats when prompted and follow the menu

## Concepts Demonstrated

- Array-based data structure
- User input handling
- Object-oriented design
- Real-time state tracking
