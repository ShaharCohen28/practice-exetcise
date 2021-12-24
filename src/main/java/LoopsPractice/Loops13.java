package LoopsPractice;

import java.util.Scanner;

public class Loops13 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int base;

        System.out.println("Please enter a abase for the hourglass");
        base=scanner.nextInt();

        for (int counter = 0; counter <base ; counter++) {
            print(counter,false);
            print(base-counter,true);
            System.out.println();
        }
        for (int counter = 1; counter <=base ; counter++) {
            print(base-counter,false);
            print(counter,true);
            System.out.println();
        }
    }

    public static void print(int times, boolean printStar){
        for (int i = 0; i < times ; i++) {
            System.out.print(printStar?"* ":" ");
        }
    }
}
