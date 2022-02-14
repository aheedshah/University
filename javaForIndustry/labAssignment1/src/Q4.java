public class Q4 {
    public static void main(String[] args) throws java.io.IOException{
        //write your answer here

        char i = 'm'; //Initialising i to be equal to m so that the first iteration of the main menu runs
        do{
            if(i=='m'){ //If i == , then print the whole main menu
                System.out.println("Main Menu:");
                System.out.println("What can we assist you with today?");
                System.out.println("1. Current Accounts");
                System.out.println("2. Credit Cards");
                System.out.println("3. Loans");
                System.out.println("4. Saving Accounts");
            }

            i = (char)System.in.read(); //Reads the user input and assigns it to i
            System.in.read(); //It stores the return key we press after we assign a value to i.
            switch (i) { //Switch statement for different cases of i.
                case '1':
                    System.out.println("You are in the Current Accounts Section");
                    System.out.println("Press m to return to the main menu or h to hang up");
                    break;
                case '2':
                    System.out.println("You are in the Credit Cards Section");
                    System.out.println("Press m to return to the main menu or h to hang up");
                    break;
                case '3':
                    System.out.println("You are in the Loans Section");
                    System.out.println("Press m to return to the main menu or h to hang up");
                    break;
                case '4':
                    System.out.println("You are in the Saving Accounts Section");
                    System.out.println("Press m to return to the main menu or h to hang up");
                    break;
                case 'h': //For cases h and m, we just break away from the loop so that the terminal doesn't run the default case
                case 'm':
                    break;
                default:
                    System.out.println("Invalid Input. Back to the Main Menu");
                    i='m'; //If there's an invalid input, assign i=m so that the main menu pops up again.
            }
        } while(i != 'h'); //The loop runs until i isn't equal to h. When it is, the programme ends with the output returned below.
        System.out.println("Thanks for banking with us! Goodbye!");
    }
}