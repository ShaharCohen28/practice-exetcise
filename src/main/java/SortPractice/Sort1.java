package SortPractice;

public class Sort1 {
    public static void main(String[] args) {
        final int ARRAY_LENGTH = 10;
        int[] arr = new int[ARRAY_LENGTH];
        initiateArray(arr);
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }

    public static void initiateArray(int arr[]) {
        for (int index = 0; index < arr.length; index++) {
            arr[index] = (int) (Math.random() * 99) + 1;
        }
    }

    public static void printArray(int[] arr) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] arr) {
        int temp;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }
    }
}
