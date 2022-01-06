package FunctionsPracrtice;

import java.util.Scanner;

public class Functions7 {
    public static void main(String[] args) {
        final int ROWS = 3, COLS = 5;
        int[][] arr = new int[ROWS][COLS];
        initiateArray(arr);
        printArray(arr);
        System.out.println("The matrix is " + (isMirrorMat(arr)?"":"not ") + "a mirror matrix");

    }

    public static void initiateArray(int[][] arr) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter " + arr.length * arr[0].length + " numbers to the array");
        for (int indexR = 0; indexR < arr.length; indexR++) {
            for (int indexC = 0; indexC < arr[0].length; indexC++) {
                arr[indexR][indexC] = scanner.nextInt();
            }
        }
    }

    public static void printArray(int[][] arr) {
        for (int indexR = 0; indexR < arr.length; indexR++) {
            for (int indexC = 0; indexC < arr[0].length; indexC++) {
                System.out.print(arr[indexR][indexC] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isMirrorMat(int[][] arr) {
        for(int col=0; col<arr[0].length/2; col++){
            for (int row = 0; row < arr.length ; row++) {
                if(arr[row][col]!=arr[row][arr[0].length-1-col])
                    return false;
            }
        }
        return true;
    }

}
