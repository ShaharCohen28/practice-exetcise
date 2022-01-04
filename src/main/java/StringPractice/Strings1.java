package StringPractice;

import java.util.Scanner;

public class Strings1 {
    public static void main(String[] args) {
        final int ARRAY_LENGTH = 3;
        String[] text1 = new String[ARRAY_LENGTH];
        String[] text2 = new String[ARRAY_LENGTH];
        String[] text3 = new String[ARRAY_LENGTH];
        fillStringArray(text1);
        fillStringArray(text2);
        createNewArray(text1,text2,text3,10);
        System.out.println("The new array is:");
        printArray(text3);
    }

    public static void fillStringArray(String[] arr) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter " + arr.length + " strings to the array," +
                "max 10 letters in each string");
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

    public static void createNewArray(String[] text1, String[] text2, String[] text3, int maxLength) {
        for (int index = 0; index < text3.length; index++) {
            if(text1[index].length()+text2[index].length()<maxLength)
                text3[index]=text1[index]+text2[index];
        }
    }
}


