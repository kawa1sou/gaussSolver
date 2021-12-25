package kawa1sou;

/*
Basically everything is in here
 */
public class Matrix {

    public int size_a;
    public int size_b;
    public int[][] matrix = new int[size_a][size_b];

    public Matrix(int size_a, int size_b, int [][] matrix) {

        this.size_a = size_a;
        this.size_b = size_b;
        this.matrix = matrix;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }

    public void print() {

        System.out.println("----------------------------------------------");
        for(int i = 0; i < size_a; i++) {
            for(int j = 0; j < size_b; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("----------------------------------------------");
    }
    /*
    Main function for Gauss method
     */
    public void gauss_solve() {
        for (int j = 0; j < size_b - 1; j++) {
            if(gauss_step_check(j) == 1)
                gauss_step(j);
        }
    }

    /*
    Checks if there's a point to do a step on a specific row, return 1 if yes, 0 otherwise.
    Firstly, searches for a line with non-zero value on a needed row.
    Thenceforth, checks if there's at least one line beside one found at the first point
    Also uses lines exchange method, so the line, which is being subtracked from the other ones is on row'th position
     */

    public int gauss_step_check(int row) {

        int init_comp = matrix[row][row];
        int init_line = row;

        if (init_comp == 0) {
            for (int i = row; i < size_a; i++){
                if (matrix[i][row] != 0) {
                    gauss_line_exchange(init_line, i);
                    init_line = i;
                    break;
                }
            }
        }

        for (int i = 0; i < size_a; i++) {
            if (matrix[i][row] != 0 && i != init_line) {
                return 1;
            }
        }

        return 0;
    }

    /*
    Performs the Gauss step
     */

    public void gauss_step(int row) {

        for (int i = row + 1; i < size_a; i++) {
            if (matrix[i][row] != 0) {
                double factor = matrix[i][row] / (matrix[row][row] * 1.0);

                for (int j = 0; j < size_b; j++) {
                    matrix[i][j] -= factor * matrix[row][j];
                }
            }
        }
    }

    /*
    Simple line exchange, used in gauss_step_check method
     */

    public void gauss_line_exchange(int init_line, int exchange_line) {
        for (int j = 0; j < size_b; j++) {
            int temp = matrix[init_line][j];
            matrix[init_line][j] = matrix[exchange_line][j];
            matrix[exchange_line][j] = temp;
        }
    }


}
