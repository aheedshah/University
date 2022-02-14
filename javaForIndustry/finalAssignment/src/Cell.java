public class Cell {
    /**
     * @param puzzle: The puzzle which we're checking
     * @returns: true if you can edit and false otherwise.
     * */
    public static boolean isEditable(int[][] puzzle){
        for(int i = 0; i< puzzle.length; i++){
            for(int j = 0; j<puzzle.length; j++){
                if(puzzle[i][j] == 0){
                    return true;
                }
            }
        }
        return false;
    }
}
