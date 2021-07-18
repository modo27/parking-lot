Parking Lot Low Level Design (Java)

Problem Statement
We own a parking lot that can hold up to ‘n’ cars at any given point in time. Each slot is given a number starting at one increasing with increasing distance from the entry point in steps of one. We want to create an automated ticketing system that allows our customers to use our parking lot without human intervention.

Solution Approach:

Models:

- Vehicle: Right now only type of vehicle required is Car. We can extend other types of vehicle also. Contains registration number and driver's age
- Car: Type of vehicle currently supported
- ParkingLot: Creates a parking lot of fixed size. Slots are maintained using arrays.


Services:

- RequestParser: Class to parse the different types of input requests.
- ParkingService: Implements the core logic of the code.

Exceptions:

- RequestNotFoundException: Thrown when invalid input is passed.
- ParkingException: Thrown when there is any problem with processing of data.

Utils:
- RequestList: Contains a set of valid requests and also validates the number of arguments passed.

Main:
Main class which will read the input file and process it line by line.