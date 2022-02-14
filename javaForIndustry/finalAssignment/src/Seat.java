/**
 * This class gets the seats layout from a file and stores each seat's details
 * */
public class Seat {
    private int row; //Row
    private int seat; //Seat number in a specific row
    private String flyingClass; //Class
    private Passenger allocatedTo = null; //Passenger the seat is allocated to

    //The constructor which initialises the row, seat and flyingClass
    public Seat(int row, int seat, String flyingClass){
        this.row= row;
        this.seat = seat;
        this.flyingClass = flyingClass;
    }

    //Overriding the toString method which returns only the information needed.
    @Override
    public String toString(){
        return "Seat{" +
                "row='" + getRow() + '\'' +
                ", seat='" + getSeat() + '\'' +
                ", flyingClass='" + getFlyingClass() + '\'' +
                '}';
    }

    //Getters and setters for row
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }

    //Getters and setters for seat
    public int getSeat() {
        return seat;
    }
    public void setSeat(int seat) {
        this.seat = seat;
    }

    //Getters and setters for flyingClass
    public String getFlyingClass() {
        return flyingClass;
    }
    public void setFlyingClass(String flyingClass) {
        this.flyingClass = flyingClass;
    }

    //Getters and setters for allocatedTo
    public Passenger getAllocatedTo() {
        return allocatedTo;
    }
    public void setAllocatedTo(Passenger allocatedTo) {
        this.allocatedTo = allocatedTo;
    }
}
