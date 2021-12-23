package LoopsPractice;

import java.util.Scanner;

public class Loops11 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int number;

        System.out.println("Please enter a number");
        number= scanner.nextInt();
        for (int row = 1; row <=number ; row++) {
            printSign(row,'*');
            printSign(number-row,'#');
            System.out.println();
        }
    }
    public static void printSign(int times, char sign){
        for (int i = 0; i <times ; i++) {
            System.out.print(sign);
        }
    }
}
