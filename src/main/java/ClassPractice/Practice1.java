package ClassPractice;

import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int ARRAY_SIZE = 15;
        int[] arr1 = randomValues(ARRAY_SIZE);
        int[] arr2 = randomValues(ARRAY_SIZE);
        int[] arr3;
        int number;

        printArray(arr1);
        printArray(arr2);
        System.out.println("Please enter a number of partition");
        number = scanner.nextInt();
        System.out.println("The max number with the length " + number + " is " + maxNumber(arr1, number));
        arr3 = distinctArray(arr1, arr2, ARRAY_SIZE);
        printArray(arr3);
        System.out.println("The reverse number is " + buildReverseNumber(arr3));
    }

    public static int[] randomValues(int arrSize) {
        int[] arr = new int[arrSize];
        for (int index = 0; index < arr.length; index++) {
            arr[index] = (int) (Math.random() * 10);
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int index = 0; index < arr.length; index++) {
            System.out.print(arr[index] + " ");
        }
        System.out.println();
    }

    public static int maxNumber(int[] arr, int numberLength) {
        int maxNumber = 0, tempMax;
        for (int index = 0; index <= arr.length - numberLength; index++) {
            tempMax = buildNumber(arr, index, numberLength);
            if (maxNumber < tempMax) {
                maxNumber = tempMax;
            }
        }
        return maxNumber;
    }

    public static int buildNumber(int[] arr, int index, int numberLength) {
        int number = 0;
        while (numberLength > 0) {
            number = 10 * number + arr[index++];
            numberLength--;
        }
        return number;
    }

    public static int buildReverseNumber(int[] arr) {
        int reverseNumber = 0, place = 1, index = 0;
        while (arr[index] != -1) {
            reverseNumber += arr[index] * place;
            place *= 10;
            index++;
        }
        return reverseNumber;
    }

    public static int[] fillMinus(int size) {
        int[] arr = new int[size];
        for (int index = 0; index < arr.length; index++) {
            arr[index] = -1;
        }
        return arr;
    }

    public static int[] distinctArray(int[] arr1, int[] arr2, int size) {
        int[] distinct = fillMinus(size);
        int place = 0;
        for (int index = 0; index < arr1.length; index++) {
            if (!hasBeen(arr2, arr1[index], size-1) && !hasBeen(distinct, arr1[index],place)) {
                distinct[place++] = arr1[index];
            }
        }
        return distinct;
    }

    public static boolean hasBeen(int[] arr, int number, int checkRange) {
        for (int index = 0; index <= checkRange; index++) {
            if (arr[index] == number) {
                return true;
            }
        }
        return false;
    }
}
