/**
 * This is an abstract class which can extend to other classes
 * This class is extended in CrewMember and Passenger classes
 * This has one abstract method called calculatePersonWeight()
 * */
public abstract class Person {
    //Declaring the variables for each person
    private String name; //Name of the person
    private int passportNumber; //Their Passport Number

    //Creating the constructor which initialises the variables name and passportNumber
    public Person(String name, int passportNumber){
        this.name = name;
        this.passportNumber = passportNumber;
    }

    /**
     * This abstract method is used in the child classes
     * @return double: The weight of the person
     * */
    public abstract double calculatePersonWeight();

    //Creating getters and setters for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //Creating getters and setters for passport number
    public int getPassportNumber() {
        return passportNumber;
    }
    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }
}
