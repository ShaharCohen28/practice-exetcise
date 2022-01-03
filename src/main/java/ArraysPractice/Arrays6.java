package ArraysPractice;

import java.util.Scanner;

public class Arrays6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chArr = new char[10];
        boolean isCaps = false;

        initiateArray(chArr);
        printArray(chArr);
        for (int i = 0; i < chArr.length; i++) {
            if (chArr[i] >= 'A' && chArr[i] <= 'Z') {
                isCaps = !isCaps;
                continue;
            }
            if (isCaps) {
                chArr[i] -= 32;
            }
        }
        printArray(chArr);
    }

    public static void initiateArray(char[] arr) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter " + arr.length + " letters, 2 must be capital " +
                "and the rest must be lower-case");
        for (int index = 0; index < arr.length; index++) {
            arr[index] = scanner.next().charAt(0);
        }
    }

    public static void printArray(char[] arr) {
        for (char letters : arr) {
            System.out.print(letters + ", ");
        }
        System.out.println();
    }
}
