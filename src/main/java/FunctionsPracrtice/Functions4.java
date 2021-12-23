package FunctionsPracrtice;

import java.util.Scanner;

public class Functions4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] arr= new int[5];

        System.out.println("Please enter " + arr.length + " numbers");
        for(int i=0; i<arr.length; i++){
            arr[i]=scanner.nextInt();
        }

        System.out.println("The number of values that the sum of their digits is 10 is: " + sumInArray(arr, arr.length));
    }

    //part 1
    public static int sumOfDigits(int num){
        int sum=0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }

    //part2
    public  static int sumInArray(int[] arr, int length){
        int count=0;
        for(int i=0; i<length; i++){
            if(sumOfDigits(arr[i])==10){
                count++;
            }
        }
        return count;
    }
}
