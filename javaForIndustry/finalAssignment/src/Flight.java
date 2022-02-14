/**
 * This class brings together all the components and completes the system.
 * This class stores and gets each flight's specific flying details like their departing and arriving airport, etc.
 * This class also calculates the weight of each passenger, book their seats, and upgrades, downgrades any passenger's eats(if needed)
 * */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Flight {
    //Declaring the variables
    private int flightNumber; //The flight's number
    private Aircraft craft; //The aircraft's details from the Aircraft Class
    private String startLocation; //The departing airport
    private String endLocation; //The arriving airport
    private double distance; //The total distance of the flight

    private int firstClass; //Number of firstClass passengers
    private int economyClass; //Number of economyClass passengers
    private int unallocatedSeats; //number of unallocated seats

    //Creating public arraylists to store seats and crew
    public ArrayList<Seat> seats; //arrayList "seats" that stores elements of type Seat
    public ArrayList<CrewMember> crew; //arrayList "crew" that stores elements of type CrewMember

    /**The constructor which initialises the variables declared above and populates the seats arrayList
     * @exception FileNotFoundException: Handled in the try-catch block inside the constructor
     */
    public Flight(int flightNumber, Aircraft craft, String startLocation, String endLocation, double distance){
        //Initialising the variables
        this.flightNumber = flightNumber;
        this.craft = craft;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.distance = distance;
        seats = new ArrayList<>();
        crew = new ArrayList<>();
        //Using a try and catch statement to catch the FileNotFoundException so that
        //if the file is not found, the programme doesn't stop working
        try {
            //Getting the file using FileInputStream
            FileInputStream fis = new FileInputStream(craft.getLayoutFile());
            //Creating a new Scanner which scans the file inputted
            Scanner sc = new Scanner(fis);
            //Initialising the row to be equal to 1 as there is no 0
            int row = 1;
            //While the scanner has a next line, this code runs
            while(sc.hasNextLine()){
                //The String below gets the line we're on
                String line = sc.nextLine();
                //We split the line whenever there's a comma and enter the data into the array data
                String[] data = line.split(",");
                //Looping over the data's length
                for(int i = 0; i < data.length; i++) {
                    String flyingClass = "economy"; //keeping the flying class as economy by default. Saves us an else statement.
                    if(data[i].equals("F")){ //If the data at i equal F, we change the flyingClass to first
                        flyingClass = "first";
                    }
                    //We then, populate the seats arraylist
                    seats.add(new Seat(row, (i+1), flyingClass));
                }
                //And then, we move onto the next row
                row++;
            }
        } catch (FileNotFoundException e) { //If the file isn't found, we output the statement below
            System.out.println("File Not Found. Error Message: " + e);
        }
    }

    /**
     * This method calculates the total take off weight which includes the flight's weight, each passenger and crew member's estimated weight
     * @return: a double of the total weight or -1 if the flight is too heavy and won't be able to takeoff
     * */
    public double calculateTakeOffWeight(){
        double totalWeight = craft.getCraftWeight(); //initialising the totalWeight=craft's weight
        //Looping over each element of the arrayList seat
        for (Seat seat : seats) {
            if(seat.getAllocatedTo() != null) { //This if statement protects our code from throwing a NullPointerException
                totalWeight += seat.getAllocatedTo().calculatePersonWeight(); //Adding each person's weight from each seat to totalWeight
            }
        }
        //Looping over each element of the arrayList crew
        for(CrewMember crewMember: crew){
            totalWeight+=crewMember.calculatePersonWeight();//Adding each crew member's weight to totalWeight
        }
        //If the total weight is greater than the maximumTakeOffWeight, we return -1.
        if(totalWeight > craft.getMaximumTakeoffWeight()){
            return -1;
        }
        return totalWeight;
    }

    /**
     * This method books a seat for a passenger and also upgrades or downgrades the seat based on availability
     * @param passenger: This passenger whose seat is to be booked
     * @returns: 1: If the booking is complete in the seat the customer had booked.
     * @returns: 2: If there are no economy class seats left, and we need to upgrade the class of the passenger
     * @returns: 3: If there are no first class seats left, and we need to downgrade the class of the passenger
     * @returns: -1: If the plane is full
     * */
    public int bookSeat(Passenger passenger){
        //Looping over each seat to find the perfect seat for the passenger
        for(Seat seat: seats){
            if(seat.getAllocatedTo() == null) { //Checking if the seat we are allocating to is empty.
                //If the customer's booking and the seat are both equal to first, we allocate the seat,
                // increment number of first class passengers by 1 and
                // return 1 as the booking is complete
                if (seat.getFlyingClass().equals("first") && passenger.getFlightClass().equals("first")) {
                    seat.setAllocatedTo(passenger);
                    firstClass++;
                    return 1;
                // Else if, the customer's booking and the seat are both equal to economy, we allocate the seat,
                // increment number of first class passengers by 1 and
                // return 1 as the booking is complete
                } else if (seat.getFlyingClass().equals("economy") && passenger.getFlightClass().equals("economy")) {
                    seat.setAllocatedTo(passenger);
                    economyClass++;
                    return 1;
                }
            }
        }
        //For the passengers who couldn't find their own booked seats, we upgrade or downgrade
        for(Seat seat: seats){
            if(seat.getAllocatedTo() == null){//Checking if the seat we are allocating to is empty.
                //If the passenger had booked a first class flight, but we only have economy left, we downgrade,
                // increment number of economyClass passengers by 1, allocate the seat and return 3
                if (seat.getFlyingClass().equals("economy") && passenger.getFlightClass().equals("first")) {
                    seat.setAllocatedTo(passenger);
                    economyClass++;
                    return 3;
                // Else if the passenger had booked an economy class flight, but we only have first class left, we upgrade,
                // increment number of firstClass passengers by 1, allocate the seat and return 2
                } else if (seat.getFlyingClass().equals("first") && passenger.getFlightClass().equals("economy")) {
                    seat.setAllocatedTo(passenger);
                    firstClass++;
                    return 2;
                }
            }
        }
        return -1; //Returning -1 to make sure the method doesn't miss a return statement if arrayList is empty
    }

    //Overriding the toString method which returns only the information needed.
    @Override
    public String toString() {
        return  "-------------" + "\n" +
                "* Flight #" + getFlightNumber() + " *" + "\n" +
                "-------------" + "\n" +
                "From: " + getStartLocation() + "\n" +
                "To: " + getEndLocation() + "\n" +
                "Distance: " + getDistance() + "\n" +
                //How many first class passengers are booked
                "First class passengers: " + firstClass + "\n" +
                //How many economy class passengers are booked
                "Economy class passengers: " + economyClass + "\n" +
                //How many seats are unallocated is equal to the number of first and economy class passengers subtracted
                // from the total amount of seats
                "Unallocated Seats: " + (seats.size()-(firstClass+economyClass)) + "\n" +
                //Name of each crew member
                "Crew: " + crew + "\n" +
                //Info about the aircraft
                getCraft();
    }

    //Getters and setters for flightNumber
    public int getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    //Getters and setters for craft
    public Aircraft getCraft() {
        return craft;
    }
    public void setCraft(Aircraft craft) {
        this.craft = craft;
    }

    //Getters and setters for startLocation
    public String getStartLocation() {
        return startLocation;
    }
    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    //Creating getters and setters for endLocation
    public String getEndLocation() {
        return endLocation;
    }
    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    //Getters and setters for distance
    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
}