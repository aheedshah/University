public class DisplaySudoku {
    public void displaySudoku(int[][] puzzle){
        for(int i=0;i<9;i++) {
            if(i%3==0 && i!=0) {
                System.out.println("----------------------------------\n");
            }
            for(int j=0;j<9;j++) {
                if(j%3==0 && j!=0) {
                    System.out.print(" | ");
                }
                System.out.print(" " + puzzle[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n\n__________________________________________\n\n");
    }
}
