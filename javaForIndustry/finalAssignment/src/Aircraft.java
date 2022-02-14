/**
 * This class gets and stores the aircraft's details and also uses the File input to get its details
 * */
import java.io.File;
public class Aircraft {
    //Declaring the variables for each Aircraft
    private String make; //The make of aircraft
    private String model; //The model
    private String tailNumber; //The tail number
    private double craftWeight; //The weight of the aircraft
    private double maximumTakeoffWeight; //The maximum weight the aircraft can handle
    private File layoutFile; //The file which stores the aircraft details

    //Constructor method which initialises each of the variable declared above.
    public Aircraft(String make, String model, String tailNumber, double craftWeight, double maximumTakeoffWeight, File layoutFile){
        this.make = make;
        this.model = model;
        this.tailNumber= tailNumber;
        this.craftWeight = craftWeight;
        this.maximumTakeoffWeight = maximumTakeoffWeight;
        this.layoutFile = layoutFile;
    }

    //Overriding the toString method which returns only the information needed.
    @Override
    public String toString() {
        return  "make: " + make +
                " model: " + model +
                " tailNumber: " + tailNumber +
                " weight: " + craftWeight +
                " maximum take off weight: " + maximumTakeoffWeight
                ;
    }

    //Getters and setters for make
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }

    //Getters and setters for model
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    //Getters and setters for tailNumber
    public String getTailNumber() {
        return tailNumber;
    }
    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
    }

    //Getters and setters for craftNumber
    public double getCraftWeight() {
        return craftWeight;
    }
    public void setCraftWeight(double craftNumber) {
        this.craftWeight = craftNumber;
    }

    //Getters and setters for maximumTakeoffWeight
    public double getMaximumTakeoffWeight() {
        return maximumTakeoffWeight;
    }
    public void setMaximumTakeoffWeight(double maximumTakeoffWeight) {
        this.maximumTakeoffWeight = maximumTakeoffWeight;
    }

    //Getters and setters for layoutFile
    public File getLayoutFile() {
        return layoutFile;
    }
    public void setLayoutFile(File layoutFile) {
        this.layoutFile = layoutFile;
    }
}
