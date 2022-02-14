import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q2Main {
    //Main Method
    public static void main(String[] args) {
        //Try-catch block from preventing a file not found exception
        try {
            int[][] puzzle = new int[9][9]; //This is a 9x9 puzzle with 3x3 boxes
            Scanner sc = new Scanner(new File("./extensionPuzzle.txt")); //Using the scanner to get the puzzle
            while (sc.hasNextLine()){ //Looping through the line
                //Using the for loop to read the puzzle and store it into the puzzle array
                for(int i = 0; i <puzzle.length; i++){
                    String[] line = sc.nextLine().split(","); //Splitting the array on the commas
                    for(int j=0; j< line.length; j++){
                        if(i<0 || i>9 || j<0 || j>9){ //If any element contains these, it's not a valid puzzle
                            System.out.println("Puzzle contains numbers either less than 0 or greater than 10. Please check the puzzle again");
                            return;
                        }
                        puzzle[i][j] = Integer.parseInt(line[j]); //Parsing it into an int and storing it into the array
                    }
                }
            }

            //Outputting the unsolved sudoku puzzle
            System.out.println("Sudoku Unsolved:");
            Grid.toString(puzzle);

            //When the puzzle is solved, output it.
            if(Solver.solveSudoku(puzzle)){
                System.out.println("Sudoku Solved:");
                Grid.toString(puzzle);
            } else{ //Else, there's no solution
                System.out.println("No solution");
            }
        } catch (FileNotFoundException e){
            System.out.println("Couldn't find the file"); //Exception if you can't find the file
        }
    }
}
