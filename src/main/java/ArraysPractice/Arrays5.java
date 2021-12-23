package ArraysPractice;

import java.util.Scanner;

public class Arrays5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        final int ARRAY_LENGTH=5;
        int[] arr1=new int[ARRAY_LENGTH], arr2= new int[ARRAY_LENGTH];
        boolean isOK=true;

        System.out.println("Please enter " + ARRAY_LENGTH + " numbers to the first array");
        for (int i=0; i<ARRAY_LENGTH; i++){
            arr1[i]=scanner.nextInt();
        }
        System.out.println("Please enter " + ARRAY_LENGTH + " numbers to the second array");
        for (int i=0; i<ARRAY_LENGTH; i++){
            arr2[i]=scanner.nextInt();
        }

        for(int i=0; i<ARRAY_LENGTH; i++){
            if(arr1[i]!=arr2[(i+1)%ARRAY_LENGTH]){
                isOK=false;
                break;
            }
        }

        for (int numbers:arr1){
            System.out.print(numbers + ", ");
        }
        System.out.println();
        for (int numbers:arr2){
            System.out.print(numbers + ", ");
        }
        System.out.println();
        System.out.println("the numbers in array 2 are " + (isOK?"":" not") + " deflected by one place");
    }
}
