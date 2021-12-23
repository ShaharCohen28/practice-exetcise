package LoopsPractice;

import java.util.Scanner;

public class Loops9 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num1, num2, newNum=0, countDigits=0, place=1, digit1, digit2;
        /*
        exp:
        num1=123, digit1 is for num1
        num2=456, digit2 is for num2
        newNum=455666
         */
        System.out.println("Please enter two numbers with the same length");
        num1=scanner.nextInt();
        num2=scanner.nextInt();

        while(countDigits<9 && num1!=0) {
            digit1 = num1 % 10;
            digit2 = num2 % 10;
            for(int i=0;i<digit1;i++){
                newNum+=digit2*place;
                place*=10;
                countDigits++;
                //System.out.printf("%d %d %d\n", newNum, place, countDigits);
            }
            num1 /= 10;
            num2 /= 10;
            //System.out.printf("%d %d\n", num1, num2);
        }
        //System.out.println(countDigits + " " + num1 + " " + num2);
        System.out.println("The new number is: " + newNum);
    }
}
