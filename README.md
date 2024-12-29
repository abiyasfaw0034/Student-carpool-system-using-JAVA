Title: Student Carpool  System - Requirements and Design

Introduction:

The Carpool Coordination System is a desktop application designed to connect parents/guardians and trusted drivers for coordinating reliable ride-sharing arrangements for elementary and high school students. This system facilitates efficient communication between parents and drivers, ensuring safe and convenient transportation for students.

Requirements:

1.User Registration and Profile Management:

The system allows users to register an account and create a digital wallet upon registration. Parents/guardians can create and manage their profiles, including information about their children, such as names, ages, schools, and specific pickup/drop-off locations.
Drivers are required to create and manage their profiles, including uploading their driver's license.

2.Ride Search and Recommendation:

Parents/guardians can search for available rides based on preferred pickup/drop-off locations and timing. The system recommends available rides by matching drivers with similar routes and timings.

3.Contract Options and Payment:

Parents/guardians are provided with a range of contract duration options to choose from, such as monthly, weekly, 3-monthly, or yearly.Parents can transfer payment for the ride from their digital wallet. The system calculates the payment based on the number of seats booked and the duration of the contract.

4.Contract Management:

Drivers and guardians can view contract details, status, and expiration dates.
Options for editing, renewing, or terminating contracts are provided as needed.

5.Notifications:

Parents/guardians receive notifications about their child's rides, including updates on ride status and scheduling.

6.User Authentication:

Users are authorized with a username and password to access the system's functionalities securely.

Design

Interfaces:

1. User-interface:
Abstract Attributes: name, userId, address, telephoneNumber, password
Abstract Methods:
register(): Allows a new user to register an account with the system by providing personal information.
login(): Allows a registered user to log in to their account by providing their username and password.

Classes:

1. Parent:

Implements: UserInterface
Attributes: name, userId, address, telephoneNumber, children (List of Child objects)
Methods:
addChild(Child child): Adds information about a child, such as name, age, school, pickup, and drop-off locations.
 createDigitalWallet(double initialBalance): Allows the parent to create a digital wallet within the system by specifying an initial balance.
searchRides(String pickupLocation, String dropOffLocation, String timing): Allows parents to search for available rides based on preferred pickup and drop-off locations and timing.
transferPayment(double amount): Enables the parent to transfer payment for the ride from their digital wallet.

2. Child:

Attributes: name, age, school, pickupLocation, dropOffLocation.This class represents information about each child, including their name, age, school, and specific pickup and drop-off locations.

3.Driver:

Implements: UserInterface
Attributes: name, userId, address, telephoneNumber, driverLicense
Methods:
createDigitalWallet(double initialBalance): Allows the driver to create a digital wallet within the system by specifying an initial balance.



4. Ride:

Attributes: driver (Driver object), children (List of Child objects), pickupLocation, dropOffLocation, timing, contractDuration. This class represents a ride, including information about the driver, children, pickup and drop-off locations, timing, and contract duration.
