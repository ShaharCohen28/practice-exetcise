package ArraysPractice;

import java.util.Scanner;

public class Arrays8 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        final int ARRAY_SIZE=6;
        int[] arr= new int[ARRAY_SIZE];
        int reverseValue, temp;
        boolean isMirror=true;

        System.out.println("Please enter " + ARRAY_SIZE + " numbers for the first array");
        for(int i=0; i<ARRAY_SIZE; i++){
            arr[i]= scanner.nextInt();
        }

        for (int i=0; i<ARRAY_SIZE/2; i++){
            reverseValue=0;
            temp=arr[i];
            while (temp>0){
                reverseValue=10*reverseValue+temp%10;
                temp/=10;
            }
            if(reverseValue!=arr[ARRAY_SIZE-1-i]){
                isMirror=false;
                break;
            }
        }
        System.out.println(isMirror?"Mirror arrays":"Not mirror arrays");
    }
}
