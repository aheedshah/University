/**
 * This is one of the child classes of Person
 * This class holds and stores each person's number of bags, their name and passport numbers.
 * */
public class Passenger extends Person{
    //Declaring private variables for each Passenger
    private int holdBags; //Each person's number of bags
    private String flightClass; //Their flight class

    //The constructor initialises the flightClass and holdBags and gets the name and passport number from the parent class.
    public Passenger(String name, int passportNumber, String flightClass, int holdBags) {
        //Calling the super class to get the name and passport number
        super(name, passportNumber);
        this.flightClass = flightClass;
        this.holdBags = holdBags;
    }

    //Overriding the abstract method which calculates each person's estimated weight
    @Override
    public double calculatePersonWeight() {
        //If a person is flying first class, their weight is considered a bit more because of their extra meals
        if(flightClass.equals("first")){
            return (25*holdBags + 87.5);
        } else { //For economy class passengers
            return (25*holdBags + 80);
        }
    }

    //Overriding the toString method which returns only the information needed.
    @Override
    public String toString(){
        return "Passenger{" +
                "name = " + getName() +
                " flightClass = " + getFlightClass() +
                " holdBags = " + getHoldBags()
                ;
    }

    //Creating getters and setters for holdBags
    public int getHoldBags() {
        return holdBags;
    }
    public void setHoldBags(int holdBags) {
        this.holdBags = holdBags;
    }

    //Creating getters and setters for flightClass
    public String getFlightClass() {
        return flightClass;
    }
    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }
}
