package LoopsPractice;

import java.util.Scanner;

public class Loops15 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int base;

        System.out.println("Please enter a abase for the hourglass");
        base=scanner.nextInt();

        for (int i = 0; i <3 ; i++) {
            printTriangle(base);
        }
        for (int i = 0; i < 3 ; i++) {
            printBase(base);
        }
    }

    public static void printBase(int base) {
        for (int counter = 1; counter <base ; counter++) {
            print(base - counter-1, false);
        }
        System.out.print(" ");
        print(1,true);
        System.out.println();
    }

    public static void printTriangle(int base) {
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
