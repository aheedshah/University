import java.text.DecimalFormat;

public class Q3 {
    public static void main(String[] args) {
        double salary = 60000; //Initialising the salary value

        //write your code here to calculate the tax of the variable salary, make sure you try multiple values
        // to test your work

        double updatedSalary; //Initialising a new double to store the value of updates salary as we go down the tax brackets.
        double tax = 0; //Initialising the tax to be equal to 0
        if(salary>50000){ //If salary is greater than 50k
            updatedSalary = salary-50000; //subtract 50k to find the tax to be paid at 40%
            tax+= 0.4 * updatedSalary; //declare tax to be equal to 40% of the money above 50k
            salary-=updatedSalary; //Updating the new salary
        } if(salary>30000 && salary<=50000){ //If the salary is between 30k and 50k,
            updatedSalary = salary-30000; //Subtract 30k to find the amount of tax to be paid at 20%
            tax+=(0.2*updatedSalary); //Update the tax by adding the amount to be paid at 20%
            salary-=updatedSalary; //Updating the new salary
        } if(salary>15000 && salary<=30000){ //If the salary is between 15k and 30k
            updatedSalary = salary - 15000; //Subtract 15k to find the amount to be paid at 5%
            tax+=(0.05*updatedSalary); //Update the tax by adding the amount to be paid at 5%
            salary-=updatedSalary; //Updating the new Salary
        }

        DecimalFormat f = new DecimalFormat("#0.00");
        System.out.println("The tax to be paid is £" + f.format(tax));
    }
}
