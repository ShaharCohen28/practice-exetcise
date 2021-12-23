package LoopsPractice;

import java.util.Scanner;

public class Loops1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int number, digit, count=0, temp;

        System.out.println("PLease enter a number");
        number= scanner.nextInt();
        temp=number;
        System.out.println("Please enter a digit");
        digit= scanner.nextInt();

        while(temp>0){
            if(temp%10==digit){
                count++;
            }
            temp/=10;
        }

        System.out.println("The digit " + digit + " appears in the number "
                + number + " " + count + " times");
    }
}
