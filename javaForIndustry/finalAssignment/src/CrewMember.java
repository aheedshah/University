/**
 * This is one of the child classes of Person
 * This class gets and stores the name of each crew member and calculates their weight
 * */
public class CrewMember extends Person{
    //Creating the constructor
    public CrewMember(String name, int passportNumber){
        //Calling the super class to get the name and passport number
        super(name, passportNumber);
    }

    //Overriding the existing abstract method and implementing it
    @Override
    public double calculatePersonWeight() {
        return 75;//Each crew member is estimated to weight 75
    }

    //Overriding the toString method which returns only the information needed.
    @Override
    public String toString(){
        return getName();
    }
}
