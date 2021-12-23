package ArraysPractice;

import java.util.Scanner;

public class Arrays11 {
    public static void main(String[] args) {
        final int ARRAY_SIZE = 10;
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[ARRAY_SIZE][ARRAY_SIZE];
        int rowUser, colUser, max;

        rowUser = receiveDimensions(ARRAY_SIZE, "rows");
        colUser = receiveDimensions(ARRAY_SIZE, "cols");
        max=initiateArray(arr, rowUser, colUser);
        printArr(arr, rowUser, colUser);
        System.out.println("The max number in the frame is " + max);

    }

    public static int receiveDimensions(int length, String dim) {
        Scanner scanner = new Scanner(System.in);
        boolean isOK = false;
        int dimension;
        do {
            System.out.println("Please enter number of " + dim + " btw 0 - " + length);
            dimension = scanner.nextInt();
            if (dimension > 0 && dimension <= length) {
                isOK = true;
            }
        } while (!isOK);
        return dimension;
    }

    public static int initiateArray(int[][] arr, int rows, int cols) {
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        System.out.println("Please enter " + (rows * cols) + " numbers to the array");
        for (int indexRow = 0; indexRow < rows; indexRow++) {
            for (int indexCols = 0; indexCols < cols; indexCols++) {
                arr[indexRow][indexCols] = scanner.nextInt();
                if(indexRow==0){
                    max = checkMax(max, arr[indexRow][indexCols]);
                    continue;
                }
                if (indexCols==0){
                    max = checkMax(max, arr[indexRow][indexCols]);
                    continue;
                }
                if(indexRow== arr.length-1){
                    max = checkMax(max, arr[indexRow][indexCols]);
                    continue;
                }
                if(indexCols== arr.length-1){
                    max = checkMax(max, arr[indexRow][indexCols]);
                }
            }
        }
        return max;
    }

    private static int checkMax(int max, int number) {
        return number>max?number:max;
    }

    public static void printArr(int[][] arr, int rows, int cols) {
        for (int indexRow = 0; indexRow < rows; indexRow++) {
            for (int indexCols = 0; indexCols < cols; indexCols++) {
                System.out.print(arr[indexRow][indexCols] + " ");
            }
            System.out.println();
        }
    }
}
