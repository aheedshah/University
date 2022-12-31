public class Solver {
    /**
     * This is the actual solver which brings all the classes together.
     * @param puzzle: The puzzle we need to sort
     * @returns: true if the puzzle is solved and false otherwise
     * */
    public static boolean solveSudoku(int[][] puzzle){
        //Using ints to store the row and columns we'll try first
        //We start from -1 as we don't have any elements at -1 want to overwrite any element.
        int row = -1;
        int column = -1;
        boolean isEditable = true; //Checks if the cells can be edited anymore or not

        //The loop below loops over all elements to check which cells are empty and tries to add numbers to them
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length; j++) {
                if (puzzle[i][j] == 0) { //If a cell is empty,
                    row = i; //We make row=i
                    column = j; //and column=j
                    isEditable = false; //And set isEditable to false
                    break; //And break from the loop and try to add number to the cell
                }
            }
            //If no cell is editable, we break from the loop
            if (!isEditable) {
                break;
            }
        }
        //When no empty space is left, this returns true, and we have completed the puzzle
        if (isEditable) {
            return true;
        }

        //This loop, loops numbers from 1 to 9 and tries to add them in the empty cells.
        //It then calls the numberCanBeFilled Method from Grid and if that return true, it makes the
        //Puzzle's specific row and column equal to the number
        for (int num = 1; num <= puzzle.length; num++) {
            if (Grid.numberCanBeFilled(puzzle, row, column, num)) {
                puzzle[row][column] = num;
                if (solveSudoku(puzzle)) { //When we solve the puzzle, we return true
                    return true;
                } else { //Else, the number at that spot = 0 again, and we run through the loop again
                    puzzle[row][column] = 0;
                }
            }
        }
        //If we can't solve the puzzle, we return false
        return false;
    }
}
