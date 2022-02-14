public class Q3Main {
    public static void main(String[] args) {
        //Q3 Part 4
        String password1 = Password.generator(6,2,1);
        //expected outcome: No conditions match as symbols = 2
        //returned outcome: "None of the conditions have been met by this Password"
        String qualityOfPassword1 = Password.qualityOfPassword(password1);
        System.out.println(qualityOfPassword1);

        String password2 = Password.generator(14,4,5);
        //expected outcome: Good or Okay. Depends on if both lowercase and uppercase are a part of the random numbers or not
        //Returned: Good
        String qualityOfPassword2 = Password.qualityOfPassword(password2);
        System.out.println(qualityOfPassword2);

        String password3 = Password.generator(9,2,3);
        //expected outcome: Okay or No conditions matched. Depends on if mixed letters are true or not. If there are mixed letters, no condition is matched.
        //returned outcome: Okay
        String qualityOfPassword3 = Password.qualityOfPassword(password3);
        System.out.println(qualityOfPassword3);

        String password4 = Password.generator(9,2,2);
        //expected outcome: No conditions match as digits = 2
        //returned outcome: "None of the conditions have been met by this Password"
        String qualityOfPassword4 = Password.qualityOfPassword(password4);
        System.out.println(qualityOfPassword4);

        String password5 = Password.generator(18,5,5);
        //expected outcome: Excellent
        //returned outcome: Excellent
        String qualityOfPassword5 = Password.qualityOfPassword(password5);
        System.out.println(qualityOfPassword5);
    }
}
