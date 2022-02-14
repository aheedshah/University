import java.util.Arrays;
import java.util.Random;

//Q3 Part 2
public class Password {
    //Initialising the numbers, symbols, uppercase and lowercase letters so that is public and can be accessed anywhere.
    public static char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static char[] symbol = {'!', '@', '#', '$', '%', '&', '*', '(', ')', '_', '+', '-', '='};
    public static char[] letters = {'A', 'a', 'B', 'b', 'C', 'c', 'D', 'd', 'E', 'e', 'F', 'f', 'G', 'g', 'H', 'h', 'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', 'M', 'm', 'N', 'n', 'O', 'o', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't', 'U', 'u', 'V', 'v', 'W', 'w', 'X', 'x', 'Y', 'y', 'Z', 'z'};
    public static char[] uppercaseLetters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static char[] lowercaseLetters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    static String generator(int length, int symbols, int digits){
        //Output an array of characters with the specific symbols and digits and letters in places where there is nothing
        char[] password = new char[length]; //Creating an array which holds length number of characters.

        //Filling the password array with a character to stop us from overwriting the characters already there.
        Arrays.fill(password, '>');

        //if symbols + digits is more than length, Throw an error
        if(length<symbols+digits){
            return "Error! Symbols + Digits are greater than the total number of password";
        }

        //Initialising rnd which will be used later to choose random numbers and indices
        Random rnd = new Random();

        //First, looping through digits.
        for(int i = 0; i<digits; i++){
            //Choosing an int b/w 0 and the length of the password and assigning it to randomIndex
            int randomIndex = rnd.nextInt(password.length);
            //Choosing a number at random
            int n = rnd.nextInt(numbers.length);
            //If password is not overwritten already,
            if(password[randomIndex] == '>'){
                //It's safe to write to it
                password[randomIndex] = numbers[n];
            } else{ //Else, loop through it once more
                i--;
            }
        }

        //Now, looping through symbols
        for(int i = 0; i<symbols; i++){
            //Choosing an int b/w 0 and the length of the password and assigning it to randomIndex
            int randomIndex = rnd.nextInt(password.length);
            //Choosing a symbol at random
            int n = rnd.nextInt(symbol.length);
            //If password is not overwritten already,
            if(password[randomIndex] == '>'){
                //It's safe to write to it
                password[randomIndex] = symbol[n];
            }else{ //Else, loop through it once more
                i--;
            }
        }

        for(int i = 0; i<length-(symbols+digits); i++){
            //Choosing an int b/w 0 and the length of the password and assigning it to randomIndex
            int randomIndex = rnd.nextInt(password.length);
            //Choosing a letter at random
            int n = rnd.nextInt(letters.length);
            //If password is not overwritten already,
            if(password[randomIndex] == '>'){
                //It's safe to write to it
                password[randomIndex] = letters[n];
            }else{//Else, loop through it once more
                i--;
            }
        }

        //Converting array of characters to string to output and then
        //Finally, returning it.
        return String.valueOf(password);
    }

    //Q3 Part 3
    static String qualityOfPassword(String password){
        //Creating an array to store the characters in the String password
        char[] ch = new char[password.length()];

        // Copy character by character into array
        for (int i = 0; i < password.length(); i++) {
            ch[i] = password.charAt(i);
        }

        //Initialising to keep track of number of digits, symbols, etc.
        int numberOfDigits = 0;
        int numberOfSymbols = 0;
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean letterCase = false;

        //Checking how many numbers the password has
        for(int i = 0; i<ch.length; i++){
            for(int j = 0; j<numbers.length; j++){
                if(ch[i] == numbers[j]){
                    numberOfDigits++;
                }
            }
        }

        //Checking how many symbols the password has
        for(int i = 0; i<ch.length; i++){
            for(int j = 0; j<symbol.length; j++){
                if(ch[i] == symbol[j]){
                    numberOfSymbols++;
                }
            }
        }

        //Checking if the password has any uppercase letters
        for(int i = 0; i<ch.length; i++){
            for(int j = 0; j<uppercaseLetters.length; j++){
                if(ch[i] == uppercaseLetters[j]){
                    upperCase = true;
                }
            }
        }

        //Checking if the password has any lowercase letters
        for(int i = 0; i<ch.length; i++){
            for(int j = 0; j<lowercaseLetters.length; j++){
                if(ch[i] == lowercaseLetters[j]){
                    lowerCase = true;
                }
            }
        }

        //If the password has both lowercase and uppercase letters, then make letterCase = true
        if(upperCase && lowerCase){
            letterCase = true;
        }

        //For Debugging
//        System.out.println(ch.length);
//        System.out.println(numberOfDigits);
//        System.out.println(numberOfSymbols);
//        System.out.println(letterCase);
        //Different Conditions based on what was given in the assignment
        if(ch.length<=8 && numberOfDigits<=2 && numberOfSymbols <=1 && letterCase == false){
            return "Poor";
        } else if(ch.length > 8 && numberOfDigits>2 && numberOfSymbols>1 && letterCase == false){
            return "Okay";
        } else if((ch.length > 12 && ch.length<16) && numberOfDigits>3 && numberOfSymbols>3 && letterCase == true){
            return "Good";
        } else if(ch.length >= 16 && numberOfDigits>4 && numberOfSymbols>4 && letterCase == true){
            return "Excellent";
        } else {
            return "None of the conditions have been met by this Password";//If none other conditions are met.
        }
    }
}
