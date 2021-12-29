package LoopsPractice;

import java.util.Scanner;

public class Loops5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num, tempNum, newNum=0, firstDigit, secondDigit , place=1;

        System.out.println("Please enter a number");
        num= scanner.nextInt();
        tempNum=num;
        //exp: given number in the first iteration
        //temp number: 123456
        //first digit: 6
        //second digit: 5
        while(tempNum>=10){
            firstDigit=tempNum%10;
            secondDigit=tempNum%100/10;
            newNum+=firstDigit*10*place+secondDigit*place;
            place*=100;
            tempNum/=100;
        }
        //add the remaining digit of temp number to the new number
        //if the length is even-> tempNum=0
        //if the length is odd-> tempNUm is the most left digit
        newNum+=tempNum*place;
        System.out.println("THe new number is: " + newNum);
    }
}
