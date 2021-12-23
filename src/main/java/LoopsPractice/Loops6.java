package LoopsPractice;

import java.util.Scanner;

public class Loops6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num, newNum, tempNum;

        System.out.println("please enter a number");
        num = scanner.nextInt();
        tempNum = num;
        newNum = num;

        while (tempNum > 0) {
            newNum *= 10;
            newNum += tempNum % 10;
            tempNum /= 10;
        }

        System.out.println("The new number is: " + newNum);

    }
}
