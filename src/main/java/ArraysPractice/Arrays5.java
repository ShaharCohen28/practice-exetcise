package ArraysPractice;

import java.util.Scanner;

public class Arrays5 {
    public static void main(String[] args) {
        final int ARRAY_LENGTH=5;
        int[] arr1=new int[ARRAY_LENGTH], arr2= new int[ARRAY_LENGTH];
        boolean isOK=true;

        initiateArray(arr1);
        initiateArray(arr2);
        for(int i=0; i<ARRAY_LENGTH; i++){
            if(arr1[i]!=arr2[(i+1)%ARRAY_LENGTH]){
                isOK=false;
                break;
            }
        }
        System.out.println("the numbers in array 2 are " + (isOK?"":"not ") + "deflected by one place");
    }

    public static void initiateArray(int[] arr){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter " + arr.length + " numbers to the array");
        for (int i=0; i< arr.length; i++){
            arr[i]=scanner.nextInt();
        }
    }

    public static void printArray(int[] arr){
        for (int numbers:arr){
            System.out.print(numbers + ", ");
        }
        System.out.println();
    }
}
