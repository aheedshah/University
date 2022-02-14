public class Q2 {
    public static void main(String[] args) {
        //part 1: display even numbers between 0 and 1000
        int i = 0; //Initialising i
        while(i<=1000) { //i starts at 0 and ends at 1000
            System.out.println(i); //Prints i to the terminal
            i+=2; //Adding 2 to i every single time so that the number is even
        }

        //part 2: display odd numbers between 0 and 1000
        int j = 0; //Initialising j
        for(j=0; j<1000; j++) { //Looping j from 0 to 999
            if(j%2 != 0) { //if j is not divisible by 2,
                System.out.println(j); //then print j to the terminal
            }
        }

        //part 3: display all the multiples of 4 between 0 and 1000
        int k=0; //Initialising k
        for(k=1; k<=1000; k++){//Looping k from 1 to 1000
            if(k%4 == 0) { //If k is divisible by 4
                System.out.println(k); //then, print k to the console
            }
        }

        //part 4: display all the numbers between 1 and 1000 replacing multiples of 3 with Java
        //multiples of 5 with Script and multiples of 3 and 5 with JavaScript

        int l = 1; //Initialising l
        while(l<=1000){ //Looping from 1 to 1000
            if(l%3 == 0 && l%5 == 0){ //If l is divisible by 3 and 5,
                System.out.println("JavaScript"); //Print JavaScript to the terminal
            } else if(l%3 == 0) { //Else if l is divisible by 3 alone, print Java to the terminal
                System.out.println("Java");
            } else if(l%5 ==0) { //Else if l is divisible by 5 alone, print Script to the terminal
                System.out.println("Script");
            } else { //Else if l is not divisible by any of them, print the number l
                System.out.println(l);
            }
            l++;
        }
    }
}