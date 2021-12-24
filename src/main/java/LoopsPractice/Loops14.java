package LoopsPractice;

import java.util.Scanner;

public class Loops14 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter a number");
        int n= scanner.nextInt();

        for(int i=1; i<=n*n; i++){
            for (int j=1; j<=n*n; j++){
                System.out.print("*");
                if(j%n==0){
                    System.out.print("  ");
                }
            }
            System.out.println();
            if(i%n==0){
                System.out.println();
            }

        }
    }
}
