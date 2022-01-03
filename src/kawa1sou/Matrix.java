package kawa1sou;

/*
Basically everything is in here
 */
public class Matrix {

    public int sizeA;
    public int sizeB;
    public int[][] matrix;

    public Matrix(int sizeA, int sizeB, int [][] matrix) {

        this.sizeA = sizeA;
        this.sizeB = sizeB;
        this.matrix = matrix;

    }

    public void print() {

        System.out.println("----------------------------------------------");
        for(int i = 0; i < sizeA; i++) {
            for(int j = 0; j < sizeB; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("----------------------------------------------");
    }
    /*
    Main function for Gauss method
     */
    public void gaussSolve() {
        for (int j = 0; j < sizeB - 1; j++) {
            if(gaussStepCheck(j) == 1)
                gaussStep(j);
        }
    }

    /*
    Checks if there's a point to do a step on a specific row, return 1 if yes, 0 otherwise.
    Firstly, searches for a line with non-zero value on a needed row.
    Thenceforth, checks if there's at least one line beside one found at the first point
    Also uses lines exchange method, so the line, which is being subtracted from the other ones is on row'th position
     */

    public int gaussStepCheck(int row) {

        int initComp = matrix[row][row];
        int initLine = row;

        if (initComp == 0) {

            for (int i = row; i < sizeA; i++) {

                if (matrix[i][row] != 0) {
                    gaussLineExchange(initLine, i);
                    initLine = i;
                    break;
                }
            }
        }

        for (int i = 0; i < sizeA; i++) {
            if (matrix[i][row] != 0 && i != initLine) {
                return 1;
            }
        }

        return 0;
    }

    /*
    Performs the Gauss step
     */

    public void gaussStep(int row) {

        for (int i = row + 1; i < sizeA; i++) {
            if (matrix[i][row] != 0) {

                int init_factor = matrix[row][row];
                int k_factor = matrix[i][row];

                for (int j = 0; j < sizeB; j++) {
                    matrix[i][j] = matrix[i][j] * init_factor - matrix[row][j] * k_factor;
                }
            }
        }
    }

    /*
    Simple line exchange, used in gaussStepCheck method
     */

    public void gaussLineExchange(int initLine, int exchangeLine) {
        for (int j = 0; j < sizeB; j++) {
            int temp = matrix[initLine][j];
            matrix[initLine][j] = matrix[exchangeLine][j];
            matrix[exchangeLine][j] = temp;
        }
    }
}
