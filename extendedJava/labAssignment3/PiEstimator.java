import java.util.Random;
/**
 * This class sets the number of darts that are being thrown*/
public class PiEstimator {
    //number of iterations the algorithm, a larger number here should result in a more accurate estimate
    //I've set it to a billion as asked in the question
    public static final int numberOfDarts = 1_000_000_000;
}

/**
 * This class keeps track of the number of darts that are within the dart board*/
class TotalWithin {
    //This variable keeps track of the number of darts hit within the board
    private long numOfDartsWithin = 0;

    //Getters and setters for the declared variable above
    public long getNumOfDartsWithin() {
        return numOfDartsWithin;
    }

    public void setNumOfDartsWithin(long numOfDartsWithin) {
        this.numOfDartsWithin = numOfDartsWithin;
    }
}

/**
 * This is the main class which creates instances of all the other classes
 * used in this implementation*/
class Main {
    //Driver Code
    public static void main(String[] args) {
        //Creates a new instance of TotalWithin to keep track of
        //the number of darts
        TotalWithin tw = new TotalWithin();
        //Creating 4 different threads for the implementation
        ThrowDart1 td1 = new ThrowDart1(tw);
        ThrowDart2 td2 = new ThrowDart2(tw);
        ThrowDart3 td3 = new ThrowDart3(tw);
        ThrowDart4 td4 = new ThrowDart4(tw);
        //Starting these threads
        td1.start();
        td2.start();
        td3.start();
        td4.start();

        //Joining them in a try-catch block to catch the exception
        try {
            td1.join();
            td2.join();
            td3.join();
            td4.join();
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }
        //Outputs the number of darts within the board to the console
        System.out.println("Number of darts within = " +tw.getNumOfDartsWithin());

        //Stores the proportion of darts that hit the board
        long within = tw.getNumOfDartsWithin();
        //dividing the number of hits by total number of darts thrown to get an estimate of pi
        double estimate = (double)within/PiEstimator.numberOfDarts *4;
        System.out.println("Pi estimate = " + estimate);
    }

}

/**
 * The first thread*/
class ThrowDart1 extends Thread {
    //Declaring a new variable of TotalWithin to use in this class
    private final TotalWithin tw;
    //The constructor method
    ThrowDart1(TotalWithin tw){
        this.tw = tw;
    }
    //The run method for this thread
    public void run() {
        System.out.println("ThrowDart1 is starting");
        //Getting a random number
        Random r = new Random();
        //Looping from 0 to numberOfDarts/4 which makes this thread run a fourth of the entire algorithm
        for(int i = 0; i< PiEstimator.numberOfDarts/4; i++){
            double x = r.nextDouble(); //The x co-ordinate of the dart
            double y = r.nextDouble(); // The y co-ordinate of the dart

            //The distance uses pythagoras theorem to calculate the distance between the dart thrown and the origin
            //Pythagoras Theorem: hypotenuse^2 = base^2 + altitude^2
            double distance = Math.sqrt((x*x) + (y*y));

            //If the distance is less than 1, that means that the dart thrown is in the board
            if(distance<1){
                //We synchronise tw to make sure no other thread uses it while we try to rewrite it
                synchronized (tw) {
                    //We increment tw by 1 each time a dart is thrown somewhere on the board
                    tw.setNumOfDartsWithin(tw.getNumOfDartsWithin() + 1);
                }
            }
        }
        System.out.println("ThrowDart1 is ending");
    }
}

/**
 * The second thread*/
class ThrowDart2 extends Thread{
    //Declaring a new variable of TotalWithin to use in this class
    private final TotalWithin tw;
    //The constructor method
    ThrowDart2(TotalWithin tw){
        this.tw = tw;
    }
    //The run method for this thread
    public void run(){
        System.out.println("ThrowDart2 is starting");
        //Getting a random number
        Random r = new Random();
        //Looping from numberOfDarts/4 to 2*(numberOfDarts/4) which makes this thread run a fourth of the entire algorithm
        for(int i = PiEstimator.numberOfDarts/4; i<2*(PiEstimator.numberOfDarts/4); i++){
            double x = r.nextDouble(); //The x coordinate of the dart thrown
            double y = r.nextDouble(); // The y coordinate of the dart thrown

            //The distance uses pythagoras theorem to calculate the distance between the dart thrown and the origin
            //Pythagoras Theorem: hypotenuse^2 = base^2 + altitude^2
            double distance = Math.sqrt((x*x) + (y*y));

            //If the distance is less than 1, that means that the dart thrown is in the board
            if(distance<1){
                //We synchronise tw to make sure no other thread uses it while we try to rewrite it
                synchronized (tw) {
                    //We increment tw by 1 each time a dart is thrown somewhere on the board
                    tw.setNumOfDartsWithin(tw.getNumOfDartsWithin() + 1);
                }
            }
        }
        System.out.println("ThrowDart2 is ending");
    }
}

/**
 * The third thread*/
class ThrowDart3 extends Thread{
    //Declaring a new variable of TotalWithin to use in this class
    private final TotalWithin tw;
    //The constructor method
    ThrowDart3(TotalWithin tw){
        this.tw = tw;
    }
    //The run method for this thread
    public void run(){
        System.out.println("ThrowDart3 is starting");
        //Getting a random number
        Random r = new Random();
        //Looping from 2*(numberOfDarts/4) to 3*(numberOfDarts/4) which makes this thread run a fourth of the entire algorithm
        for(int i = 2*(PiEstimator.numberOfDarts/4); i<3*(PiEstimator.numberOfDarts/4); i++){
            double x = r.nextDouble(); //The x coordinate of the dart thrown
            double y = r.nextDouble(); // The y coordinate of the dart thrown

            //The distance uses pythagoras theorem to calculate the distance between the dart thrown and the origin
            //Pythagoras Theorem: hypotenuse^2 = base^2 + altitude^2
            double distance = Math.sqrt((x*x) + (y*y));

            //If the distance is less than 1, that means that the dart thrown is in the board
            if(distance<1){
                //We synchronise tw to make sure no other thread uses it while we try to rewrite it
                synchronized (tw) {
                    //We increment tw by 1 each time a dart is thrown somewhere on the board
                    tw.setNumOfDartsWithin(tw.getNumOfDartsWithin() + 1);
                }
            }
        }
        System.out.println("ThrowDart3 is ending");
    }
}

/**
 * The fourth thread*/
class ThrowDart4 extends Thread{
    //Declaring a new variable of TotalWithin to use in this class
    private final TotalWithin tw;
    //Our constructor method
    ThrowDart4(TotalWithin tw){
        this.tw = tw;
    }
    //The run method for this thread
    public void run(){
        System.out.println("ThrowDart4 is starting");
        //Getting a random number
        Random r = new Random();
        //Looping from 3*(numberOfDarts/4) to numberOfDarts which makes this thread run a fourth of the entire algorithm
        for(int i = 3*(PiEstimator.numberOfDarts/4); i<=PiEstimator.numberOfDarts; i++){
            double x = r.nextDouble(); //The x coordinate of the dart
            double y = r.nextDouble(); // The y coordinate of the dart

            //The distance uses pythagoras theorem to calculate the distance between the dart thrown and the origin
            //Pythagoras Theorem: hypotenuse^2 = base^2 + altitude^2
            double distance = Math.sqrt((x*x) + (y*y));

            //If the distance is less than 1, that means that the dart thrown is in the board
            if(distance<1){
                //We synchronise tw to make sure no other thread uses it while we try to rewrite it
                synchronized (tw) {
                    //We increment tw by 1 each time a dart is thrown somewhere on the board
                    tw.setNumOfDartsWithin(tw.getNumOfDartsWithin() + 1);
                }
            }
        }
        System.out.println("ThrowDart4 is ending");
    }
}
