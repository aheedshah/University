public class Grade {
    //Overriding the OG toString() method to what I want
    @Override
    public String toString(){
        return "Module: "+subject + ", Grade: " + getLetterGrade(score) + ";";
    }

    //Creating two private instance variables
    private String subject;
    private int score;

    /**Initialises the variables passed in the Grades Constructor
    * @param: String subject: The module name
    * @param: int score: The score the student has got in that module
    * */
    public Grade(String subject, int score){
        this.subject = subject;
        this.score = score;
    }

    /** Gets the grade in letter from the given score
    * @param: double score: The score the student has got
    * @returns: char grade: The grade in a character ranging from A-F.
    * */
    public static char getLetterGrade(double score){
        char grade = 'E';
        if(score>100) {
            grade = 'E';
        } else if(score>=70){
            grade = 'A';
        } else if(score>=60){
            grade = 'B';
        } else if(score>=50){
            grade = 'C';
        } else if(score>=40){
            grade = 'D';
        } else if(score<40){
            grade = 'F';
        } else if(score<0){
            grade = 'E';
        }
        return grade;
    }

    //Creating getters and setters
    //Getter and setter for subject
    public String getSubject(){
        return subject;
    }
    public void setSubject(String newSubject){
        subject = newSubject;
    }

    //Creating getters and setters
    //Getter and setter for score
    public int getScore(){
        return score;
    }
    public void setScore(int newScore){
        score = newScore;
    }
}
