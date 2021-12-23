package LoopsPractice;

import java.util.Scanner;

public class Loops2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num, newNum=0, place=1, tempNum;

        System.out.println("Please enter a number");
        num= scanner.nextInt();
        tempNum=num;

        while (tempNum>0){
            newNum+=(tempNum%10)*place;
            place*=10;
            tempNum/=100;
        }

        System.out.println("The new number is " + newNum);
    }
}
