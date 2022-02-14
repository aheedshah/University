/*THIS IS THE MAIN FILE FOR QUESTION 1. QUESTION 1 ALSO HAS TWO OTHER CLASSES CALLED
GRADE.JAVA AND STUDENT.JAVA.
I'VE COMPLETED ALL THE QUESTIONS FOR QUESTION 1 AND HAVE WRITTEN ALL THE COMMENTS ACCURATELY.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentMain {
    //Accessing the arraylist initialised in the student class
    public static ArrayList<Grade> grade;

    /**
    * This property adds score to san ArrayList
    * @param: ArrayList<Integer> marks: An arraylist
    * @param: score: Int which is the score the student has got
    * @returns: void
    * */
    public static void addMarks(ArrayList<Integer> marks, int score){
        marks.add(score);
    }

    /**
     * The main method
     * Adds the Students given in the example including their grades
     * Creates the main menu for users
     * @throws IOException: Exception for System.in.read()
     */
    public static void main(String[] args) throws IOException {
        //Arraylist to store students
        ArrayList<Student> studentArrayList = new ArrayList<>();

        //Arraylist to store marks
        ArrayList<Integer> marks = new ArrayList<>();

        //Adding Bert to the arraylist and her grades
        addMarks(marks, 52);//Programming
        addMarks(marks, 63);//Web Dev
        addMarks(marks, 76);//Maths
        addMarks(marks, 68);//Algorithms
        studentArrayList.add(new Student("Bert Smith", "Computing", 21, 12345, true, marks.toArray(new Integer[marks.size()])));

        //Adding Olivia to the arraylist and her grades
        marks.clear();//Clearing marks so that the previous marks don't get added again
        addMarks(marks, 73);//Programming
        addMarks(marks, 82);//Web Dev
        addMarks(marks, 72);//Maths
        addMarks(marks, 66);//Algorithms
        studentArrayList.add(new Student("Olivia Green", "Computing", 19, 23464, true, marks.toArray(new Integer[marks.size()])));

        //Adding Eloise to the arraylist and her grades
        marks.clear();//Clearing marks so that the previous marks don't get added again
        addMarks(marks, 65);//Programming
        addMarks(marks, 63);//Web Dev
        addMarks(marks, 37);//Maths
        addMarks(marks, 40);//Algorithms
        studentArrayList.add(new Student("Eloise Jones", "Computing", 18, 34744, true, marks.toArray(new Integer[marks.size()])));

        //Adding Ben to the arraylist and his grades
        marks.clear();//Clearing marks so that the previous marks don't get added again
        addMarks(marks, 55);//Programming
        addMarks(marks, 29);//Web Dev
        addMarks(marks, 56);//Maths
        addMarks(marks, 38);//Algorithms
        studentArrayList.add(new Student("Ben Bird", "Computing", 42, 34834, false, marks.toArray(new Integer[marks.size()])));

        //Adding Karen to the arraylist and her grades
        marks.clear();//Clearing marks so that the previous marks don't get added again
        addMarks(marks, 62);//Programming
        addMarks(marks, 51);//Web Dev
        addMarks(marks, 43);//Maths
        addMarks(marks, 43);//Algorithms
        studentArrayList.add(new Student("Karen Brown", "Computing", 25, 45632, false, marks.toArray(new Integer[marks.size()])));


        //Creating the menu system
        char i = 'm'; //Initialising i to be equal to m so that the first iteration of the main menu runs
        do{
            //The main menu:
            if(i=='m'){ //If i == m, then print the whole main menu
                System.out.println("Main Menu:");
                System.out.println("What can I assist you with today?");
                System.out.println("1. Print Report of all students");
                System.out.println("2. Print the name of students with a failed module");
                System.out.println("3. Print out Average Grade for each student");
                System.out.println("4. Add a new Student");
            }

            i = (char)System.in.read(); //Reads the user input and assigns it to i
            System.in.read(); //It stores the return key we press after we assign a value to i.
            switch (i) { //Switch statement for different cases of i.
                //Case 1: The case which prints all the students with their grades
                case '1':
                    System.out.println("Report of all students");
                    //Foreach student, this loop runs
                    for(Student std: studentArrayList){
                        System.out.println(std);
                    }
                    System.out.println("Press m to return to the main menu or e to exit");
                    break;
                //Case 2: Prints the name of students who have failed the module.
                case '2':
                    System.out.println("Students who have failed at least one module:");

                    for(int j=0;j<studentArrayList.size(); j++) {//Runs for each number of student in the arraylist
                        for(int k=0; k<studentArrayList.get(0).gradeArrayList.size(); k++) { //Runs for each of the number of modules
                            if(studentArrayList.get(j).gradeArrayList.get(k).getScore()<40){//If the score is <40, then they've failed
                                System.out.println(studentArrayList.get(j).getName());//Prints the names of students who've failed
                            }
                        }
                    }
                    System.out.println("Press m to return to the main menu or e to exit");
                    break;
                //Case 3: Prints the average grade for each student
                case '3':
                    System.out.println("Average Grade for each student");
                    //Declaring variables to find avg grade
                    double grades= 0;
                    double average=0;
                    double grade=0;

                    for(Student scholar:studentArrayList){ //Loop runs for each student
                        for(Grade mark: scholar.gradeArrayList){//Loop runs for each student's grade
                            grades++;//Checks number of modules
                            average += mark.getScore(); //Adds the total number of marks
                        }
                        grade=average/grades;
                        System.out.println(scholar.getName() + "'s Average Score is: " + grade + " and their Average Grade is: " + Grade.getLetterGrade(grade));
                        average=0;
                        grades=0;
                    }
                    System.out.println("Press m to return to the main menu or e to exit");
                    break;
                //Case 4: An interface to add a new student
                case '4':
                    //Clearing the arraylist in which the new grades will go
                    marks.clear();

                    //Creating a new scanner and starting the terminal interface
                    System.out.println("Add a new Student");
                    Scanner in = new Scanner(System.in);

                    //Enter Name:
                    System.out.println("Hi, Please enter the Name of the Student you would like to add:");
                    //Students can have numbers and digits. Reference: Elon Musk's son
                    String name = in.nextLine();


                    //Enter Dept.
                    System.out.println("Please enter the name of the Department this student belong to:");
                    //Departments can also have numbers. E.g. Computing Department - 1
                    String department = in.nextLine();

                    //Enter Age
                    System.out.println("Please enter the age of this student:");
                    //Age needs to be valid and should be >0 and an integer
                    int age = 0;
                    Boolean correctAge = false; // boolean to check if input is integer
                    while(!correctAge){
                        if(in.hasNextInt()){
                                age = in.nextInt();
                                if(age<0){
                                    System.out.println("You must enter an integer for the age and your age should be greater than 0(Duh!)");
                                    correctAge = false; //Ending the loop if number is an integer
                                } else{
                                    correctAge = true;
                                }
                        } else{
                            System.out.println("You must enter an integer for the age and your age should be greater than 0(Duh!)");
                            in.next();
                        }
                    }

                    //Enter Student Number
                    System.out.println("Please enter the Student Number of this student:");
                    //It needs to be an integer and >0. Uses the same logic as age above.
                    int studentNumber = 0;
                    boolean correctStudentNumber = false; // boolean to check if input is integer
                    while(!correctStudentNumber){
                        if(in.hasNextInt()){
                            studentNumber = in.nextInt();
                            if(studentNumber<0){
                                System.out.println("You must enter an integer for the Student Number and the student number can't be negative!");
                                correctStudentNumber = false; //Ending the loop if number is an integer
                            } else{
                                correctStudentNumber = true;
                            }
                        } else{
                            System.out.println("You must enter an integer for the Student Number and the student number can't be negative!");
                            in.next();
                        }
                    }

                    //Is the student full-time or part-time?
                    System.out.println("Please write if this is a full time or part time student:(True for full-time and false for part-time)");
                    boolean isCorrectFullTime = false;
                    boolean isFullTime = false;
                    while(!isCorrectFullTime){
                        if(in.hasNextBoolean()){
                            isFullTime = in.nextBoolean();
                            isCorrectFullTime = true;
                        } else {
                            System.out.println("Please enter true or false only. True means the student is Full Time and False means they aren't");
                            isCorrectFullTime = false;
                            in.next();
                        }
                    }


                    //Add score for programming
                    System.out.println("Please enter the score(0-100) this student got in the module \"Programming\" ");
                    int programmingScore = 0;
                    Boolean correctProgrammingScore = false; // boolean to check if input is integer
                    while(!correctProgrammingScore){
                        if(in.hasNextInt()){
                            programmingScore = in.nextInt();
                            if(programmingScore<0){
                                System.out.println("Surely a person can't do that bad in a module that they get negative marks! At least give them a 0!");
                                correctProgrammingScore = false; //Ending the loop if number is an integer
                            } else{
                                correctProgrammingScore = true;
                            }
                        } else{
                            System.out.println("Surely a person can't do that bad in a module that they get negative marks! At least give them a 0!");
                            in.next();
                        }
                    }
                    marks.add(programmingScore);

                    //Add Score for Web Dev
                    System.out.println("Please enter the score(0-100) this student got in the module \"Web Dev\" ");
                    int webDevScore = 0;
                    Boolean correctWebDevScore = false; // boolean to check if input is integer
                    while(!correctWebDevScore){
                        if(in.hasNextInt()){
                            webDevScore = in.nextInt();
                            if(webDevScore<0){
                                System.out.println("Surely a person can't do that bad in a module that they get negative marks! At least give them a 0!");
                                correctWebDevScore = false; //Ending the loop if number is an integer
                            } else{
                                correctWebDevScore = true;
                            }
                        } else{
                            System.out.println("Surely a person can't do that bad in a module that they get negative marks! At least give them a 0!");
                            in.next();
                        }
                    }
                    marks.add(webDevScore);

                    //Add Score for Maths
                    System.out.println("Please enter the score(0-100) this student got in the module \"Maths\" ");
                    int mathsScore = 0;
                    Boolean correctMathsScore = false; // boolean to check if input is integer
                    while(!correctMathsScore){
                        if(in.hasNextInt()){
                            mathsScore = in.nextInt();
                            if(mathsScore<0){
                                System.out.println("Surely a person can't do that bad in a module that they get negative marks! At least give them a 0!");
                                correctMathsScore = false; //Ending the loop if number is an integer
                            } else{
                                correctMathsScore = true;
                            }
                        } else{
                            System.out.println("Surely a person can't do that bad in a module that they get negative marks! At least give them a 0!");
                            in.next();
                        }
                    }
                    marks.add(mathsScore);

                    //Add score for Algorithms
                    System.out.println("Please enter the score(0-100) this student got in the module \"Algorithms\" ");
                    int algorithmsScore = 0;
                    Boolean correctAlgorithmScore = false; // boolean to check if input is integer
                    while(!correctAlgorithmScore){
                        if(in.hasNextInt()){
                            algorithmsScore = in.nextInt();
                            if(algorithmsScore<0){
                                System.out.println("Surely a person can't do that bad in a module that they get negative marks! At least give them a 0!");
                                correctAlgorithmScore = false; //Ending the loop if number is an integer
                            } else{
                                correctAlgorithmScore = true;
                            }
                        } else{
                            System.out.println("Surely a person can't do that bad in a module that they get negative marks! At least give them a 0!");
                            in.next();
                        }
                    }
                    marks.add(algorithmsScore);

                    //Adding it all to the arraylist at the end.
                    studentArrayList.add(new Student(name, department, age, studentNumber, isFullTime, marks.toArray(new Integer[marks.size()])));
                    System.out.println("New Record Added! Press 1 to show the updated version of the report");
                    System.out.println("Press m to return to the main menu or e to exit");
                    break;
                case 'e': //For cases h and m, we just break away from the loop so that the terminal doesn't run the default case
                case 'm':
                    break;
                default:
                    System.out.println("Invalid Input. Back to the Main Menu");
                    i='m'; //If there's an invalid input, assign i=m so that the main menu pops up again.
            }
        } while(i != 'e'); //The loop runs until i isn't equal to e. When it is, the programme ends with the output returned below.
        System.out.println("Goodbye!");
    }
}
