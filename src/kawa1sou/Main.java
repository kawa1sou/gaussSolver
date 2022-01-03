package kawa1sou;

public class Main {

    public static void main(String[] args) {

        int [][] a = new int[5][5];
        
        a[0][0] = 1;
        a[0][1] = -1;
        a[0][2] = 0;
        a[0][3] = -1;
        a[0][4] = 2;

        a[1][0] = -2;
        a[1][1] = 3;
        a[1][2] = 1;
        a[1][3] = 2;
        a[1][4] = -5;

        a[2][0] = 0;
        a[2][1] = -1;
        a[2][2] = 0;
        a[2][3] = 1;
        a[2][4] = -2;

        a[3][0] = 1;
        a[3][1] = -2;
        a[3][2] = -1;
        a[3][3] = -1;
        a[3][4] = 3;

        a[4][0] = -3;
        a[4][1] = 6;
        a[4][2] = 1;
        a[4][3] = 1;
        a[4][4] = -3;



        Matrix matrix = new Matrix(5 ,5, a);

        matrix.print();
        matrix.gaussSolve();
        matrix.print();

    }
}
