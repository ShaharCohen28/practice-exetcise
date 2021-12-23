package SortPractice;

public class Sort2 {
    public static void main(String[] args) {
        final int ARRAY_LENGTH = 5;
        int[][] arr = new int[ARRAY_LENGTH][ARRAY_LENGTH];
        initiateArray(arr);
        printArray(arr);
        System.out.println();
        sortMainDiagonal(arr);
        printArray(arr);

    }

    public static void initiateArray(int[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                arr[row][col] = (int) (Math.random() * 9) + 1;
            }
        }
    }

    public static void printArray(int[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void sortMainDiagonal(int[][] arr) {
        int temp;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j][j] > arr[j + 1][j + 1]) {
                    temp = arr[j][j];
                    arr[j][j] = arr[j + 1][j + 1];
                    arr[j + 1][j + 1] = temp;
                }
            }
        }
    }
}
