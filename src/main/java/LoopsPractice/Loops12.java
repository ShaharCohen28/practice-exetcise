package LoopsPractice;

import java.util.Scanner;

public class Loops12 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int base;

        System.out.println("PLease enter a abase for the triangle");
        base=scanner.nextInt();

        for (int counter = 0; counter <base ; counter++) {
            print(counter,false);
            print(base-counter,true);
            System.out.println();
        }
    }

    public static void print(int times, boolean printStar){
        for (int i = 0; i < times ; i++) {
            System.out.print(printStar?"* ":" ");
        }
    }
}
