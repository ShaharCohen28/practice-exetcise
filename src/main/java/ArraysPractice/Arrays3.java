package ArraysPractice;

import java.util.Scanner;

public class Arrays3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] arr=new int[10];

        System.out.println("Please enter the first two numbers to the array");
        arr[0]= scanner.nextInt();
        arr[1]= scanner.nextInt();

        for(int i=2;i< arr.length;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }

        for (int numbers:arr){
            System.out.print(numbers + ", ");
        }
        System.out.println();
    }
}
