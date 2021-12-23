package LoopsPractice;

import java.util.Scanner;

public class Loops3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num1, num2, count=0;

        System.out.println("Please enter two number with the same length");
        num1= scanner.nextInt();
        num2= scanner.nextInt();

        while (num1>0){
            if(num1%10==num2%10){
                count++;
            }
            num1/=10;
            num2/=10;
        }

        System.out.println("Result: " + count);
    }
}
