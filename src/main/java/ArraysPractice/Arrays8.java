package ArraysPractice;

import java.util.Scanner;

public class Arrays8 {
    public static void main(String[] args) {

        final int ARRAY_SIZE = 6;
        int[] arr = new int[ARRAY_SIZE];
        int reverseValue, temp;
        boolean isMirror = true;

        initiateArray(arr);
        for (int i = 0; i < ARRAY_SIZE / 2; i++) {
            if (reverseValue(arr[i]) != arr[ARRAY_SIZE - 1 - i]) {
                isMirror = false;
                break;
            }
        }
        printArray(arr);
        System.out.println(isMirror ? "Mirror arrays" : "Not mirror arrays");
    }

    public static void initiateArray(int[] arr) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter " + arr.length + " numbers for the first array");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
    }

    public static void printArray(int[] arr) {
        for (int number : arr) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public static int reverseValue(int number) {
        int reverseValue = 0, temp = number;
        while (temp > 0) {
            reverseValue = 10 * reverseValue + temp % 10;
            temp /= 10;
        }
        return reverseValue;
    }
}
