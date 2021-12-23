package FunctionsPracrtice;

import java.util.Scanner;

public class Functions6 {
    public static void main(String[] args) {
        final int ARRAY_SIZE = 3;
        int[][] arr = new int[ARRAY_SIZE][ARRAY_SIZE];
        initiateArray(arr);
        printArray(arr);
        System.out.println("The sum of the rows " +(checkSum(arr)?"":"not ")+ "equal to the sum of the columns");


    }

    public static void initiateArray(int[][] arr) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter " + arr.length * arr.length + " numbers to the array");
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

    public static boolean checkSum(int[][] arr) {
        int sumRow, sumCol;
        for (int fixedIndex = 0; fixedIndex < arr.length; fixedIndex++) {
            sumRow=0;
            sumCol=0;
            for (int moveIndex = 0; moveIndex < arr.length; moveIndex++) {
                sumRow+=arr[fixedIndex][moveIndex];
                sumCol+=arr[moveIndex][fixedIndex];
            }
            if(sumCol!=sumRow){
                return false;
            }
        }
        return true;
    }

}
