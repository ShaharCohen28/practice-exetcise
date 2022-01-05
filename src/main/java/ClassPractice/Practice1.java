package ClassPractice;

import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int ARRAY_SIZE = 15;
        int[] arr1 = randomValues(ARRAY_SIZE);
        int[] arr2 = randomValues(ARRAY_SIZE);
        int[] arr3 = new int[ARRAY_SIZE];
        int number;
        printArray(arr1);
        printArray(arr2);
        /*
        System.out.println("Please enter a number of partition");
        number = scanner.nextInt();
        System.out.println("The max number with the length " + number + " is " + maxNumber(arr1, number))
        */

        //printArray(arr3);
        //distinctArray(arr1,arr2,arr3);
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
        int maxNumber = 0;
        int maxDigit = arr[0], tempMax;
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

    public static int buildReverseNumber(int[] arr){
        int reverseNumber=0, place=1, index=arr.length-1;
        while (arr[index]<0){
            index--;
        }
        for (int digit = index; digit >=0 ; digit--) {
            reverseNumber=reverseNumber*10+arr[digit];
            place*=10;
        }
        return reverseNumber;
    }

    public static int[] fillMinus(int size){
        int[] arr=new int[size];
        for (int index = 0; index < arr.length; index++) {
            arr[index] = -1;
        }
        return arr;
    }

    public static int[] distinctArray(int[] arr1, int[] arr2, int size) {
        int[] distinct=fillMinus(size);
        boolean hasBeen, isDouble;
        int place = 0;
        for (int index1 = 0; index1 < arr1.length; index1++) {
            hasBeen = false;
            for (int index2 = 0; index2 < arr2.length; index2++) {
                if (arr1[index1] == arr2[index2]) {
                    hasBeen = true;
                    break;
                }
            }
            if (!hasBeen) {
                isDouble = false;
                for (int index3 = 0; index3 <= place; index3++) {
                    if (arr1[index1] == distinct[index3]) {
                        isDouble = true;
                        break;
                    }
                }
                if (!isDouble) {
                    distinct[place++] = arr1[index1];
                }
            }
        }
        return distinct;
    }
}
