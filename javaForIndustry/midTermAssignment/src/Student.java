import java.util.ArrayList;
import java.util.Locale;

public class Student {
    //Overriding the main toString method to show the details I want.
    @Override
    public String toString() {
        return ("Student Name: "+name+
                "; Student No: "+ studentNumber +
                "; Department: "+ department +
                "; Age : " + age +
                "; Is Full Time? : " + isFullTime +
                "; username: " + userName +
                "; grade: " + gradeArrayList);
    }
    //Declaring the private properties
    private String name;
    private String department;
    private int age;
    private String userName;
    private int studentNumber;
    private boolean isFullTime;

    //Creating a public arraylist for grades
    public ArrayList<Grade> gradeArrayList = new ArrayList<>();

    //Setting the empty student constructor
    public Student(){
        this.name = null;
        this.department = null;
        this.age = -1;
        this.studentNumber = -1;
        this.isFullTime = false;
    }

    /**This Constructor creates the username of a Student as well as puts the name of the modules in their specific order
    * @param: String name: name of the student
    * @param: String department: department the student belongs to
    * @param: int age: age of the student
    * @param: int studentNumber: studentNumber of the student
    * @param: boolean isFullTime: True if a student is full-time and false otherwise
    * @param: Array Marks: The marks the student has got
    */
    public Student(String name, String department, int age, int studentNumber, boolean isFullTime, Integer[] marks){
        //Making the properties passed to be equal to the constructor's properties
        this.name = name;
        this.department = department;
        this.age = age;
        this.studentNumber = studentNumber;
        this.isFullTime = isFullTime;

        //Creating the username
        //Storing the initial letter of the first name in a new char variable
        char firstNameInitial = name.charAt(0);
        //Storing the first 4 letters of the last name in a new String
        int whiteSpace = name.indexOf(" ");
        String lastNameLetters = name.substring(whiteSpace+1, whiteSpace+5);

        //Getting the first 3 digits of student number
        //Storing the total length of the student number
        int lengthOfStudentNumber = String.valueOf(studentNumber).length();
        int first3StudentDigits = (int)Math.floor((studentNumber / Math.pow(10, lengthOfStudentNumber - 3)));
        userName = (firstNameInitial+lastNameLetters+first3StudentDigits).toLowerCase(Locale.ROOT);

        //Adding each grade of the student to gradeArrayList
        gradeArrayList.add(new Grade("Programming",marks[0]));
        gradeArrayList.add(new Grade("Web Dev",marks[1]));
        gradeArrayList.add(new Grade("Maths",marks[2]));
        gradeArrayList.add(new Grade("Algorithms",marks[3]));
    }

    //Creating getters and setters
    //Getter and setter for name
    public String getName(){
        return name;
    }
    public void setName(String newName){
        name = newName;
    }

    //Getter and setter for department
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String newDepartment){
        department = newDepartment;
    }

    //Getter and setter for age
    public int getAge(){
        return age;
    }
    public void setAge(int newAge){
        age = newAge;
    }
    //Getter and setter for userName
    public String getUserName(){
        return userName;
    }
    public void setUserName(String newUserName){
        userName = newUserName;
    }

    //Getter and setter for studentNumber
    public int getStudentNumber(){
        return studentNumber;
    }
    public void setStudentNumber(int newStudentNumber){
        studentNumber = newStudentNumber;
    }

    //Getter and setter for isFullTime
    public boolean getIsFullTime(){
        return isFullTime;
    }
    public void setIsFullTime(boolean newIsFullTime){
        isFullTime = newIsFullTime;
    }
}
