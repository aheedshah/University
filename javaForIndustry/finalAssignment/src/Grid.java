public class Grid {
    /**
     * @param row: The row in which the number is trying to add
     * @param column: The column in which the number is trying to add
     * @param number: The number which we are trying to add
     * @param puzzle: The sudoku Puzzle
     * @returns: true if the number can be filles and false otherwise
     * */
    public static boolean numberCanBeFilled(int[][] puzzle, int row, int column, int number){
        //This loop checks if the number we are adding is unique within the row and column
        for(int i = 0; i< puzzle.length; i++){
            if (puzzle[row][i] == number) { //If it is already present in the row, we return false
                return false;
            }
            if(puzzle[i][column] == number){//If it is already present in the column, we return false
                return false;
            }
        }

        // This loop check if each box has a unique number which we are trying to add.
        int numberToCheck = 3; //This is 3 as the box is a 3x3.
        int boxRowStart = row - (row % numberToCheck); //This indicates the starting index of the row in which we are trying to add the number
        int boxColStart = column - (column % numberToCheck); //This indicates the starting index of the column in which we are trying to add the number

        //This loop checks if the number we are adding is unique within the box
        //We iterate over all 9 elements in the box
        for (int i = boxRowStart; i < boxRowStart + numberToCheck; i++) { //Loops from the starting index of the row of the box to the ending
            for (int j = boxColStart; j < boxColStart + numberToCheck; j++) {//Loops from the starting index of the row of the box to the ending
                if (puzzle[i][j] == number) { //If it is already present, we return false
                    return false;
                }
            }
        }

        //If we haven't returned false till now, then we can add the number to the puzzle at the row and column provided.
        return true;
    }

    /**
     * The toString() method which returns the puzzle the way I want.
     * */
    public static void toString(int[][] puzzle){
        // We got the answer, just print it
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length; j++) {
                System.out.print(puzzle[i][j]);
                System.out.print(", ");
            }
            System.out.print("\n");

            if ((i + 1) % (int)Math.sqrt(puzzle.length) == 0) {
                System.out.print("");
            }
        }
    }

}
