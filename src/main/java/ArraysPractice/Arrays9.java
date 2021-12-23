package ArraysPractice;

import java.util.Scanner;

public class Arrays9 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        final int ARRAY_SIZE=3;
        int[] arr1=new int[ARRAY_SIZE], arr2=new int[ARRAY_SIZE];
        int sum1, sum2, temp1, temp2;
        boolean areMatched=true;

        System.out.println("Please enter " + ARRAY_SIZE + " numbers for the first array");
        for(int i=0; i<ARRAY_SIZE; i++){
            arr1[i]= scanner.nextInt();
        }
        System.out.println("Please enter " + ARRAY_SIZE + " numbers for the second array");
        for(int i=0; i<ARRAY_SIZE; i++){
            arr2[i]= scanner.nextInt();
        }

        for (int i=0; i<ARRAY_SIZE; i++){
            if(sumOfDigits(arr1[i])!=sumOfDigits(arr2[i])){
                areMatched=false;
                break;
            }
        }

        System.out.println("The arrays are " + (areMatched?"":"not ") + "matched");
    }

    public static int sumOfDigits(int num){
        int sum=0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}
