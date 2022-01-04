package StringPractice;

import java.util.Scanner;

public class Strings2 {
    public static void main(String[] args) {
        final int ARRAY_LENGTH = 5;
        String[] text=new String[ARRAY_LENGTH];
        boolean[] arr=new boolean[ARRAY_LENGTH];
        int result;
        fillStringArray(text);
        result=checkShorterLength(text,ARRAY_LENGTH,arr,(int)(Math.random()*15)+5);
        System.out.println("There are " + result + " string that are shorter than the random number in index:");
        printBooleanIndex(arr);

    }
    public static void fillStringArray(String[] arr) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter " + arr.length + " strings to the array");
        for (int index = 0; index < arr.length; index++) {
            arr[index] = input.next();
        }
    }

    public static void printArray(String[] arr) {
        for (String s : arr) {
            if(s!=null) {
                System.out.println(s);
            }
        }
    }

    public static void printBooleanIndex(boolean[] arr){
        for (int index = 0; index < arr.length ; index++) {
            if(arr[index]){
                System.out.print(index + " ");
            }
        }
        System.out.println();
    }

    public static int checkShorterLength(String[] text, int arrLength, boolean[] checkArr, int maxStringLength){
        int count=0;
        for (int index = 0; index <arrLength ; index++) {
            if(text[index].length()<maxStringLength){
                checkArr[index]=true;
                count++;
            }
        }
        return count;
    }
}
