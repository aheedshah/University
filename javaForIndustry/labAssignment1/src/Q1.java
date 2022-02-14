import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Stack;

public class Q1 {
    public static void main(String[] args) {
        //write your code here to output the employee details

        //PART 1 of the Question
        //Printing the first two lines to the terminal
        System.out.println("Employee Reference");
        System.out.println("-------------------");

        int number = 12345; //Stores the employee number
        System.out.println("ID Number: " + number);// Prints the employee number

        String name = " \"Jack Smith\""; //Stores the string's name
        System.out.println("Name: " + name); //Prints the name to the terminal

        int age = 52; //Stores the age
        System.out.println("Age: " + age); //Prints the age to the terminal

        //To output the salary with 2 dp and a comma separator, we need to make a String and then parse it into a double
        //Reference: https://duckduckgo.com/?q=how+to+output+a+number+with+comma+seperators+in+java&t=osx&ia=web&iax=qa
        String salaryString = "27736.80"; //Creating a String with the salary amount
        double amount = Double.parseDouble(salaryString);
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        System.out.println("Salary: " + formatter.format(amount));

        //-------------------------------------
        //Part 2

        int currentAge = 66; //Variable to store the current age of employee
        int yearsToRetirement = currentAge-age; //Calculating the years to retirement using just the variables
        System.out.println("Jack Smith's years to retirement are: " + yearsToRetirement); //Printing it to the terminal

        int hoursPerWeek = 35; //Variable to store how many hours the employee works
        int totalWeeks = 52; //Variable to store how many weeks an employee works

        double salaryDouble = Double.parseDouble(salaryString);
        double hourlyRate = salaryDouble/(hoursPerWeek*totalWeeks); //Variable to store hourly rate of employee
        System.out.println("Jack Smith's hourly rate is: " + hourlyRate); //Printing the hourly rate to the terminal
    }
}
