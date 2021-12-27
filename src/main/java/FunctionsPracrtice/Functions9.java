package FunctionsPracrtice;

import java.util.Scanner;

public class Functions9 {
    public static void main(String[] args) {
        final int ARRAY_LENGTH = 5;
        int[][] mat = new int[ARRAY_LENGTH][ARRAY_LENGTH];
        initiateMatrix(mat);
        printMatrix(mat);
        System.out.println("Max left top rectangle is " + maxLeftTopZero(mat));
    }

    public static void initiateMatrix(int[][] mat) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter " + mat.length * mat[0].length + " digits to the matrix");
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                mat[row][col] = scanner.nextInt();
            }
        }
    }

    public static void printMatrix(int[][] mat) {
        for (int[] ints : mat) {
            for (int col = 0; col < mat[0].length; col++) {
                System.out.print(ints[col] + " ");
            }
            System.out.println();
        }
    }

    public static int maxLeftTopZero(int[][] mat) {
        int borderCol = mat.length - 1, borderRow = 0;
        while(borderCol>=borderRow){
            for (int col = 0; col <=borderCol ; col++) {
                if(mat[borderRow][col]!=0){
                    borderCol=col-1;
                    break;
                }
            }
            borderRow++;
        }
        return  borderRow-1;
    }
}
