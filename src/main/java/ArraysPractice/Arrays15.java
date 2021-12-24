package ArraysPractice;

import java.util.Scanner;

public class Arrays15 {
    public static void main(String[] args) {
        final int ARRAY_SIZE=4;
        int[][] mat= new int[ARRAY_SIZE][ARRAY_SIZE];
        initiateMatrix(mat);
        printMatrix(mat);
        System.out.println("The matrix is " + (isPrimaryFolded(mat)?" ":"not ") + "primary folded");

    }

    public static void initiateMatrix(int[][] mat){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter " + mat.length*mat[0].length + " numbers to the matrix");
        for (int row = 0; row < mat.length ; row++) {
            for (int col = 0; col <mat[0].length ; col++) {
                mat[row][col]= scanner.nextInt();
            }
        }
    }
    public static void printMatrix(int[][] mat){
        for (int row = 0; row <mat.length ; row++) {
            for (int col = 0; col <mat[0].length ; col++) {
                System.out.print(mat[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isPrimaryFolded(int[][] mat){
        for (int row = 0; row < mat.length ; row++) {
            for (int col = row+1; col <mat[0].length ; col++) {
                if(mat[row][col]!=mat[col][row]){
                    return false;
                }
            }
        }
        return true;
    }
}
