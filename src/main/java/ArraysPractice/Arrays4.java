package ArraysPractice;

import java.util.Scanner;

public class Arrays4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] arr=new int[5];
        int number;
        boolean isOK=true;

        System.out.println("Please enter " + arr.length + " numbers to the array");
        for (int i=0; i< arr.length; i++){
            arr[i]= scanner.nextInt();
        }
        System.out.println("Please enter a number");
        number= scanner.nextInt();

        for(int i=0; i< arr.length-1; i++){
            if(arr[i]+arr[i+1]!=number){
                isOK=false;
                break;
            }
        }
        if(isOK){
            System.out.println("Sum of pairs equal to the number");
        }else{
            System.out.println("Sum of pairs not equal to the number");
        }
    }
}
